# Kafka Avro Examples
This is a multi-module project. Each project demonstrates a use case of Kafka with Avro.

## Kafka Avro V1 Producer
[Module Folder](https://github.com/msathe-tech/avrokafka/blob/master/kafka-avro-v1)

[Source code](https://github.com/msathe-tech/avrokafka/blob/master/kafka-avro-v1/src/main/java/com/example/KafkaAvroProducerV1.java)

[Avro schema](https://github.com/msathe-tech/avrokafka/blob/master/kafka-avro-v1/src/main/resources/avro/customer-v1.avsc) is under 
[Module Folder/src/main/resources/avro](https://github.com/msathe-tech/avrokafka/blob/master/kafka-avro-v1) folder

*How to run*
* Maven clean - to clean up target folder
* Maven package - to build Java objects
* Check generated Customer.java under **kafka-avro-v1/target** folder
* Run the main()

## Kafka Avro V1 Consumer
[Module Folder](https://github.com/msathe-tech/avrokafka/blob/master/kafka-avro-v1)

[Source code](https://github.com/msathe-tech/avrokafka/blob/master/kafka-avro-v1/src/main/java/com/example/KafkaAvroConsumerV1.java)

[Avro schema](https://github.com/msathe-tech/avrokafka/blob/master/kafka-avro-v1/src/main/resources/avro/customer-v1.avsc) is under 
[Module Folder/src/main/resources/avro](https://github.com/msathe-tech/avrokafka/blob/master/kafka-avro-v1) folder

*How to run*
* Maven clean - to clean up target folder
* Maven package - to build Java objects
* Check generated Customer.java under **kafka-avro-v1/target** folder
* Run the main()

## Kafka Avro V2 Consumer
[Module Folder](https://github.com/msathe-tech/avrokafka/blob/master/kafka-avro-v2)

[Source code](https://github.com/msathe-tech/avrokafka/blob/master/kafka-avro-v2/src/main/java/com/example/KafkaAvroConsumerV2.java)

[Avro schema](https://github.com/msathe-tech/avrokafka/blob/master/kafka-avro-v2/src/main/resources/avro/customer-v2.avsc) is under 
[Module Folder/src/main/resources/avro](https://github.com/msathe-tech/avrokafka/blob/master/kafka-avro-v2) folder.
This is an updated schema. 
The consumer app uses new schema to consume the app. It can consume any message as long as the producer has used either Backward or Full compatible schema. 

*How to run*
* Maven clean - to clean up target folder
* Maven package - to build Java objects
* Check generated Customer.java under **kafka-avro-v2/target** folder
* Run the main()

*Check **backword** compatibility*
* Run [V1 Producer](https://github.com/msathe-tech/avrokafka/blob/master/kafka-avro-v1/src/main/java/com/example/KafkaAvroProducerV1.java)
* Run [V2 Consumer](https://github.com/msathe-tech/avrokafka/blob/master/kafka-avro-v2/src/main/java/com/example/KafkaAvroConsumerV2.java)
 