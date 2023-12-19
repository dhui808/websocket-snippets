## Spring Boot, Apache Kafka, WebSocket

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 16.0.3.

	npm i

	
### Build

	ng build
		
### Development server

	ng serve --serve

### Connect to WebSocket Server

	http://localhost:4200
	
	Topic to connect on:
	123

	where topic 123 matches the userId in the producer REST API URL.
	
### Start NotificationWebsocketApplication

### Start KafkaProducerApplication

### Send a message
	curl localhost:9080/producer/123/sayhello-123
	
	where userId 123 matches the part of WebSocket topic path.
	 
