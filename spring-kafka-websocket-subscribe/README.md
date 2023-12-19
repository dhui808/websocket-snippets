## Spring Boot, Spring for Apache Kafka, WebSocket
	Using SessionSubscribeEvent to create Kafka listener dynamically.
	
	Use either SubscribeKafkaMessageListener (uncomment code)or
	SubscribeApplicationListener.
	
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
	

### SessionSubscribeEvent
	SessionSubscribeEvent.getMessage ->
	GenericMessage 
	[payload = byte[0], headers = {
	        simpMessageType = SUBSCRIBE,
	        stompCommand = SUBSCRIBE,
	        nativeHeaders = {
	            id = [sub - 0],
	            destination = [/topic/greetings / 123]
	        },
	        simpSessionAttributes = {},
	        simpHeartbeat = [J @ 64d2d30f, simpSubscriptionId = sub - 0, simpSessionId = 3c047ff5 - dd69 - c3af - ba93 - 920d49df3388, simpDestination = /topic/greetings / 123
	    }
	]
