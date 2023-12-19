### WebSocket
	WebSockets is a bidirectional, full-duplex, persistent connection between a web browser 
 	and a server. Once a WebSocket connection is established, the connection stays open until 
	the client or server decides to close this connection.
 
### Spring WebSocket
	Enable WebSocket in Spring:
 	@EnableWebSocketMessageBroker

	Set the context root
 	config.setApplicationDestinationPrefixes("/app");

	Register an endpoint:
	registry.addEndpoint("/chat");

	On the clisne side:
	stompClient.send("/app/chat", {}, jsonstring);
 
	Rest controller uses @SendTo("/topic/pushmessages") to publish messages to websocket
	Scheduler uses simpMessagingTemplate.convertAndSend("/topic/pushmessages", message);});
 
### Run
	Run WebsocketApplication
	
	http://localhost:8080
	or 
	http://localhost:8080/bots.html
	
