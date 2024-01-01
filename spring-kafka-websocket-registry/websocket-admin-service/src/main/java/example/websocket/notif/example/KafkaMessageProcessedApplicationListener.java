package example.websocket.notif.example;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.event.ListenerContainerIdleEvent;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

//Alternative to SubscribeKafkaMessageListener. Use only one of them.
@Service
public class KafkaMessageProcessedApplicationListener implements ApplicationListener<KafkaMessageProcessedApplicationEvent> {

	private ApplicationContext context;
	private TaskExecutor exec = new SimpleAsyncTaskExecutor();

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    
    @Autowired
    public KafkaMessageProcessedApplicationListener(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void onApplicationEvent(KafkaMessageProcessedApplicationEvent event) {
    	
        //log.info(event.toString());
        exec.execute(() -> {
            ConcurrentMessageListenerContainer container = event.getContainer();
            //log.info("stopping container: " + container.getBeanName());
            container.stop();
        });
    }
}