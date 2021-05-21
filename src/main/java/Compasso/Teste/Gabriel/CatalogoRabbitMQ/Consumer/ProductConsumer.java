package Compasso.Teste.Gabriel.CatalogoRabbitMQ.Consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import Compasso.Teste.Gabriel.CatalogoRabbitMQ.Config.MessagingConfig;
import Compasso.Teste.Gabriel.CatalogoRabbitMQ.Model.Product;
import Compasso.Teste.Gabriel.CatalogoRabbitMQ.Repository.ProductRepository;

@Component
public class ProductConsumer {
	
	@Autowired
	private ProductRepository repository;
	
	@RabbitListener(queues = MessagingConfig.QUEUE)
	public void consumeMessagesFromQueue(Product product) {
		product.setName(product.getName()+"(1)");
		repository.save(product);
	}

}
