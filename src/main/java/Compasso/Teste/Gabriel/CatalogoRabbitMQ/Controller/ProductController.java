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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST Catalogo de Produtos com RabbitMQ")
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductServiceImpl productService;

	@ApiOperation(value = "Cadastra um produto, publica e consome no RabbitMQ")
	@PostMapping
	public Product create(@RequestBody Product product) {
		return productService.create(product);
	}

	@ApiOperation(value = "Atualizar um produto, publica e consome no RabbitMQ")
	@PutMapping("/{id}")
	public Product edit(@PathVariable(name = "id") String id, @RequestBody Product product) {
		return productService.edit(id, product);
	}

	@ApiOperation(value = "Retornar um produto")
	@GetMapping("/{id}")
	public Product findById(@PathVariable(name = "id") String id) {
		return productService.findById(id);
	}

	@ApiOperation(value = "Retorna uma lista de produtos")
	@GetMapping
	public List<Product> findAll() {
		return productService.findAll();
	}

	@ApiOperation(value = "Retorna uma lista de produtos filtrados")
	@GetMapping("/search")
	public List<Product> search(
			@RequestParam(name = "min_price", required = false, defaultValue = "0.0") double min_price,
			@RequestParam(name = "max_price", required = false, defaultValue = "1000000.0") double max_price,
			@RequestParam(name = "q", required = false, defaultValue = "") String q) {
		return productService.search(min_price, max_price, q);
	}

	@ApiOperation(value = "Deletar um produto")
	@DeleteMapping("/{id}")
	public ResponseEntity<Product> deleteById(@PathVariable(name = "id") String id) {
		return productService.deleteById(id);
	}

}
