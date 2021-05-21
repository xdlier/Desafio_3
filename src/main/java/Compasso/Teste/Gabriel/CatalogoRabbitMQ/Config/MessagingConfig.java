package Compasso.Teste.Gabriel.CatalogoRabbitMQ.Config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {
	
	public static final String ROUTING_KEY = "Product_RoutingKey";
	public static final String EXCHANGE = "Product_exchange";
	public static final String QUEUE = "Product_Queue";
	
	public static final String EXCHANGE2 = "Product_exchange2";
	public static final String QUEUE2 = "Product_Queue2";

	@Bean
	public Queue queue() {
		return new Queue(QUEUE);
	}
	
	@Bean
	public Queue queue2() {
		return new Queue(QUEUE2);
	}
	
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(EXCHANGE);
	}
	
	@Bean
	public TopicExchange exchange2() {
		return new TopicExchange(EXCHANGE2);
	}
	
	@Bean
	public Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}
	
	@Bean
	public Binding binding2(Queue queue2, TopicExchange exchange2) {
		return BindingBuilder.bind(queue2).to(exchange2).with(ROUTING_KEY);
	}
	
	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public AmqpTemplate template(ConnectionFactory connection) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connection);
		rabbitTemplate.setMessageConverter(converter());
		return rabbitTemplate;
	}
	
}
