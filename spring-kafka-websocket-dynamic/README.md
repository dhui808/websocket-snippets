## Spring Boot, Spring for Apache Kafka, WebSocket - Part 2

	Override configureClientInboundChannel to create Kafka listener dynamically.
	
	Note:
	The approach used in spring-kafka-websocket-registry is the right way for dynamically starting and stopping Kafka listener container.
	
### Start Kafka with the -d option to run in detached mode
	docker-compose up -d

	http://localhost:3040
	
### WebsocketExample

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 16.0.3.

	npm i

	
### Build

	ng build
		
### Development server

	ng serve --open

### Connect to WebSocket Server

	http://localhost:4200
		
	Topic to connect on:
	123

### Start NotificationWebsocketApplication

### Start KafkaProducerApplication

### Send a message
	curl localhost:9080/producer/123/sayhello-123
	
