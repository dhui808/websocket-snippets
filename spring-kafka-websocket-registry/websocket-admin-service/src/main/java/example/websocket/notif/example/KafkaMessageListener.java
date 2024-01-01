package example.websocket.notif.example;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class KafkaMessageListener implements MessageListener<String, String>  {
    private final String id;

    private final String topic;

	private SimpMessagingTemplate simpMessagingTemplate;

	private ConcurrentMessageListenerContainer<String, String> container;
	
    public String getId() {
        return this.id;
    }

    public String getTopic() {
        return this.topic;
    }
	public KafkaMessageListener(String id, String topic, SimpMessagingTemplate simpMessagingTemplate, ConcurrentMessageListenerContainer<String, String> container) {
		this.id = id;
        this.topic = topic;
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.container = container;
	}

	@Override
	public void onMessage(ConsumerRecord<String, String> data) {
		
		String message = data.value();
        System.out.println("Received Json Message in groupId='" + id + "'," + message);

      String[] messageArray  = message.split(";");
      simpMessagingTemplate.convertAndSend("/topic/greetings/"+ messageArray[1], messageArray[0]);
      System.out.println("message is sent: " + message);
	
      // Stop container. No need to be async
      container.stop();
      
	}

}
