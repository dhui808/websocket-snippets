package example.websocket.notif.example;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

import example.websocket.notif.example.kafka.KafkaMessageListener;

//Alternative to SubscribeKafkaMessageListener. Use only one of them.
@Service
public class SubscribeApplicationListener implements ApplicationListener<SessionSubscribeEvent> {

	private ApplicationContext context;
    
    @Autowired
    public SubscribeApplicationListener(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void onApplicationEvent(SessionSubscribeEvent event) {
    	
    	System.out.println("onApplicationEvent is invoked");
    	Map map = (Map)event.getMessage().getHeaders().get("nativeHeaders");
    	List list = (List)map.get("destination");
    	String topicpath = (String)list.get(0);
    	
    	String[] s = topicpath.split("/");
    	
    	System.out.println("Create message listener, topic = " + s[s.length - 1]);
    	// Create message listener
    	KafkaMessageListener listener = context.getBean(KafkaMessageListener.class, "greetingGrp", s[s.length - 1]);
        
        System.out.println("Done creating message listener");
    }
}