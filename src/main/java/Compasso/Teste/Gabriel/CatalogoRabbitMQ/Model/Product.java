package Compasso.Teste.Gabriel.CatalogoRabbitMQ.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Product {

	@Id
	private String id;
	private String name;
	private String description;
	private Double price;

}
