package paulo.lopes.demos.kafka.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderProducerReply {
	@Value("${order.topic_reply}")
	private String orderTopic;

	private final KafkaTemplate kafkaTemplate;

	public OrderProducerReply(final KafkaTemplate kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void reaply(final String key, final String value) {
		kafkaTemplate.send(orderTopic, key, value);
	}
}
