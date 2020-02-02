package paulo.lopes.demos.kafka.consumer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import paulo.lopes.demos.kafka.producer.OrderProducerReply;

// https://emmanuelneri.com.br/2019/06/04/kafka-no-spring-boot/
@Component
public class OrderConsumer {
	@Autowired
    private OrderProducerReply orderProducerReply;
    
    
//    @KafkaListener(topics = "${order.topic}", groupId = "${spring.kafka.consumer.group-id}")
//    public void consumer(String order) {
//    	System.out.println("Order: " + order);
//    }
    
    @KafkaListener(topics = "${order.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(final ConsumerRecord consumerRecord) {
    	System.out.println("key: " + consumerRecord.key());
    	System.out.println("Headers: " + consumerRecord.headers());
    	System.out.println("Partion: " + consumerRecord.partition());
    	System.out.println("Order: " + consumerRecord.value());
    	this.processOrder(consumerRecord.key().toString(), consumerRecord.value().toString());
    }
    
    public void processOrder(String key, String value) {
    	Date date=new Date();
    	DateFormat dateFormat=new SimpleDateFormat("dd-MM-YY_HH:mm:ss");
    	String newValue=value.concat(dateFormat.format(date));
    	newValue=newValue.replace("\"", "");
    	orderProducerReply.reaply(key, newValue);
    	
    }
}
