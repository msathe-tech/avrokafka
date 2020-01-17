package com.example;

import java.util.Collections;
import java.util.Properties;
import java.util.Random;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaAvroConsumerV2 {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty("bootstrap.servers", "localhost:9092");
		props.setProperty("group.id", "my-avro-cosumer-v1");
		props.setProperty("enable.auto.commit", "false");
		props.setProperty("auto.offset.reset", "earliest");
		props.setProperty("key.deserializer", StringDeserializer.class.getName());
		props.setProperty("value.deserializer", KafkaAvroDeserializer.class.getName());
		props.setProperty("schema.registry.url", "http://localhost:8081");
		props.setProperty("specific.avro.reader", "true");

		String topic = "customer-avro";

		KafkaConsumer<String, Customer> consumer = new KafkaConsumer<String, Customer>(props);
		consumer.subscribe(Collections.singleton(topic));

		Customer customer;
		ConsumerRecords<String, Customer> records;

		while (true) {
			records = consumer.poll(500);
			for (ConsumerRecord<String, Customer> record: records) {
				customer = record.value();
				System.out.println(customer);
			}
			consumer.commitSync();
		}
	}
}
