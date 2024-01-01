package example.websocket.notif.example;

import org.springframework.context.ApplicationEvent;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

public class KafkaMessageProcessedApplicationEvent extends ApplicationEvent {

	private static final long serialVersionUID = 8953625541376016930L;

	private ConcurrentMessageListenerContainer<String, String> container;
	
	public KafkaMessageProcessedApplicationEvent(ConcurrentMessageListenerContainer<String, String> source) {
        super(source);
        container = source;
    }
	
	public ConcurrentMessageListenerContainer getContainer() {
		return container;
	}
}
