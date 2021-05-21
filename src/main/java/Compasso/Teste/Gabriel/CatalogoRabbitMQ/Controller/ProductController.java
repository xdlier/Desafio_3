package Compasso.Teste.Gabriel.CatalogoRabbitMQ.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Compasso.Teste.Gabriel.CatalogoRabbitMQ.Model.Product;
import Compasso.Teste.Gabriel.CatalogoRabbitMQ.Service.ProductServiceImpl;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductServiceImpl productService;

	@PostMapping
	public Product create(@RequestBody Product product) {
		return productService.create(product);
	}

	@PutMapping("/{id}")
	public Product edit(@PathVariable(name = "id") String id, @RequestBody Product product) {
		return productService.edit(id, product);
	}

	@GetMapping("/{id}")
	public Product findById(@PathVariable(name = "id") String id) {
		return productService.findById(id);
	}

	@GetMapping
	public List<Product> findAll() {
		return productService.findAll();
	}

	@GetMapping("/search")
	public List<Product> search(
			@RequestParam(name = "min_price", required = false, defaultValue = "0.0") double min_price,
			@RequestParam(name = "max_price", required = false, defaultValue = "1000000.0") double max_price,
			@RequestParam(name = "q", required = false, defaultValue = "") String q) {
		return productService.search(min_price, max_price, q);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Product> deleteById(@PathVariable(name = "id") String id) {
		return productService.deleteById(id);
	}

}
