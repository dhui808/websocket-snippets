# websocket-snippets
Spring Boot WebSocket Kafka

### Spring Boot Stomp Kafka Integration
[Routing messages from Kafka to web socket clients](https://stackoverflow.com/questions/58385826/routing-messages-from-kafka-to-web-socket-clients-connected-to-application-serve)

### Spring Stomp Messsage Handler

	@Controller
	public class GreetingController {
	
	
	  @MessageMapping("/hello")
	  @SendTo("/topic/greetings")
	  public Greeting greeting(HelloMessage message) throws Exception {
	    Thread.sleep(1000); // simulated delay
	    return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	  }
	
	}

	The @MessageMapping annotation ensures that, if a message (STOMP over WebSocket) is sent to the /hello destination, 
	the greeting() method is called.

 	The return value is broadcast to all subscribers (STOMP over WebSocket) of /topic/greetings.
  
### Configure Spring for STOMP messaging
	@Configuration
	@EnableWebSocketMessageBroker
	public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	
	  @Override
	  public void configureMessageBroker(MessageBrokerRegistry config) {
	    config.enableSimpleBroker("/topic");
	    config.setApplicationDestinationPrefixes("/app");
	  }
	
	  @Override
	  public void registerStompEndpoints(StompEndpointRegistry registry) {
	    registry.addEndpoint("/websocket");
	  }
	
	}

 	config.setApplicationDestinationPrefixes("/app") defines the context root of Spring Stomp application.
  
   	registry.addEndpoint("/websocket") sets up a WebSocket endpoint ("/websocket"). WebSocket clients can 
    	connect to this endpoint to establish WebSocket connections. From the browser:
	ws://localhost:9082/websocket/437/glok5mri/websocket
  
