package Compasso.Teste.Gabriel.CatalogoRabbitMQ.Service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import Compasso.Teste.Gabriel.CatalogoRabbitMQ.Model.Product;

public interface ProductService {

	public Product create(Product product);

	public Product edit(String id, Product product);

	public List<Product> findAll();

	public Product findById(String id);

	public List<Product> search(double min_price, double max_price, String q);

	public ResponseEntity<Product> deleteById(String id);

}
