package Compasso.Teste.Gabriel.CatalogoRabbitMQ.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Compasso.Teste.Gabriel.CatalogoRabbitMQ.Model.Product;
import Compasso.Teste.Gabriel.CatalogoRabbitMQ.Publisher.ProductPublisher;
import Compasso.Teste.Gabriel.CatalogoRabbitMQ.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private ProductPublisher publisher;

	@Override
	public Product create(Product product) {
		publisher.sendPerm(product);
		publisher.sendTemp(product);
		return this.repository.save(product);
	}
	
	@Override
	public Product edit(String id, Product product) {
		
		Optional<Product> optional = this.repository.findById(id);
		Product newProduct = optional.get();
		if (product.getName() != null)
			newProduct.setName(product.getName());
		if (product.getDescription() != null)
			newProduct.setDescription(product.getDescription());
		if (product.getPrice() != null)
			newProduct.setPrice(product.getPrice());
		return this.repository.save(newProduct);
	}

	@Override
	public List<Product> findAll() {
		return this.repository.findAll();
	}

	@Override
	public Product findById(String id) {
		Optional<Product> optional = this.repository.findById(id);
		return optional.get();
	}

	@Override
	public List<Product> search(double min_price, double max_price, String q) {
		return this.repository.search(min_price, max_price, q);
	}

	@Override
	public ResponseEntity<Product> deleteById(String id) {
		Optional<Product> optional = this.repository.findById(id);
		repository.delete(optional.get());
		return ResponseEntity.ok().build();
	}

}
