package com.example;

import java.util.Properties;
import java.util.Random;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaAvroProducerV2 {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty("bootstrap.servers", "localhost:9092");
		props.setProperty("acks", "1");
		props.setProperty("retries", "10");
		props.setProperty("key.serializer", StringSerializer.class.getName());
		props.setProperty("value.serializer", KafkaAvroSerializer.class.getName());
		props.setProperty("schema.registry.url", "http://localhost:8081");

		KafkaProducer<String, Customer> producer = new KafkaProducer<String, Customer>(props);
		final String[] firstNames = {"Le", "Sa", "Ge", "Go", "Aa", "Za", "Po", "Pe"};
		Random random = new Random();

		String firstName = firstNames[random.nextInt(7)];
		Customer customer = Customer.newBuilder()
				.setFirstName(firstName)
				.setLastName("Li")
				.setAge(43)
				.setWeight(160f)
				.setHeight(80f)
				.setEmail(firstName.concat("@example.com"))
				.setPhoneNumber("300.400.500")
				.build();

		final String topic = "customer-avro";

		ProducerRecord<String, Customer> record = new ProducerRecord<String, Customer>(topic, customer);

		producer.send(record, new Callback() {
			@Override
			public void onCompletion(RecordMetadata recordMetadata, Exception e) {
				if(e == null) {
					System.out.println("Customer V2 Sent!");
					System.out.println(recordMetadata);
				} else {
					e.printStackTrace();
				}
			}
		});

		producer.flush();
		producer.close();

	}
}
