# SpringCloudStream and KafkaUI Demo App
This is a simple demo of how to use SpringCloudStream to connect a Spring App to a message queue and easily switch between using different message queue implementations, in this case Kafka and RabbitMQ. It also demonstrates how to use KafkaUI to inspect/add messages in Kafka. 

## Dependencies
- Docker 
- Docker Compose
- Java (22.0.1)

## Startup Instructions
```
cd <project_directory>
docker compose up
```
In a seperate terminal
```
cd <project_directory>/message-example
./mvnw spring-boot:run
```

## Adding messages with KafkaUI
1. Access Kafka UI at http://localhost:3080/
2. Navigate to messages-in-to-webapp-topic
   1. Click 'local'
   2. Click 'Topics'
   3. Click 'messages-in-to-webapp-topic'
3. Click 'Messages'
4. Click 'Produce Message'
5. In the 'Value' textbox, type a message in JSON format (ex: {"message": "Hello, Kafka!"})
6. View the SpringBoot terminal which should now have a console log 'Recieved: Hello, Kafka!'

## Inspecting messages with KafkaUI
1. Call the app's API to send a message to the queue
```
curl --request POST --location 'localhost:8080' \
--header 'Content-Type: application/json' \
--data '{"message":"Test message from app..."}'
```
2. In KafkaUI, navigate to topic: messages-out-from-webapp-topic

## Switch from using KafkaUI to RabbitMQ
1. Change message-example/src/main/resources/application.yml, property spring.cloud.stream.defaultBinder to 'rabbit'
```
spring:
    application:
        name: message-example
    cloud:
        stream:
            defaultBinder: rabbit
...
```
2. Restart the application
3. Access RabbitMQ admin at http://localhost:15672 (UN: guest, PW: guest)
4. Click on Queues and Streams
