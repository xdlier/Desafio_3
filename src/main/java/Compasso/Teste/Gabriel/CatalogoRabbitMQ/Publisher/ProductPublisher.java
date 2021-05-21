package Compasso.Teste.Gabriel.CatalogoRabbitMQ.Publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Compasso.Teste.Gabriel.CatalogoRabbitMQ.Config.MessagingConfig;
import Compasso.Teste.Gabriel.CatalogoRabbitMQ.Model.Product;

@Component
public class ProductPublisher {

	@Autowired
	private RabbitTemplate template;
	
	public void sendTemp(Product product) {
		template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, product);
	}
	
	public void sendPerm(Product product) {
		template.convertAndSend(MessagingConfig.EXCHANGE2, MessagingConfig.ROUTING_KEY, product);
	}
}
