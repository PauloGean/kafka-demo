package paulo.lopes.demos.kafka.consumer;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
// https://emmanuelneri.com.br/2019/06/04/kafka-no-spring-boot/
@Component
public class OrderConsumer {
 
    @KafkaListener(topics = "${order.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(String order) {
    	System.out.println("Order: " + order);
    }
    
//    @KafkaListener(topics = "${order.topic}", groupId = "${spring.kafka.consumer.group-id}")
//    public void consumer(final ConsumerRecord consumerRecord) {
//    	System.out.println(("key: " + consumerRecord.key());
//    	System.out.println(("Headers: " + consumerRecord.headers());
//    	System.out.println(("Partion: " + consumerRecord.partition());
//    	System.out.println(("Order: " + consumerRecord.value());
//    }
}
