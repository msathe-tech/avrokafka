package com.example;

import java.util.Properties;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaAvroProducerV1 {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty("bootstrap.servers", "localhost:9092");
		props.setProperty("acks", "1");
		props.setProperty("retries", "10");

		props.setProperty("key.serializer", StringSerializer.class.getName());
		props.setProperty("value.serializer", KafkaAvroSerializer.class.getName());
		props.setProperty("schema.registry.url", "http://localhost:8081");

		KafkaProducer<String, Customer> producer = new KafkaProducer<String, Customer>(props);
		String topic = "customer-avro";

		Customer customer = Customer.newBuilder()
				.setFirstName("Le")
				.setLastName("Li")
				.setAge(43)
				.setWeight(160f)
				.setHeight(80f)
				.setAutomatedEmail(false)
				.build();

		ProducerRecord<String, Customer> record = new ProducerRecord<String, Customer>(
				topic, customer);

		producer.send(record, new Callback() {
			@Override
			public void onCompletion(RecordMetadata recordMetadata, Exception e) {
				if(e == null) {
					System.out.println("Sent!");
					System.out.println(recordMetadata.toString());
				} else {
					System.out.println(e.getMessage());
				}
			}
		});

		producer.flush();
		producer.close();

	}
}
