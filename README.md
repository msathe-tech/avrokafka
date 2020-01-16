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