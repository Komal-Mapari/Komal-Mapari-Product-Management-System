package com.example.app.restController;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.Product;
import com.example.app.service.ProductService;

@RestController
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@PostMapping(value = "/products")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		Product p = productService.saveProduct(product);
		
		return new ResponseEntity<Product>(p, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> productList = productService.getAllProducts();
		
		return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);
	}
	
	@GetMapping(value = "/products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
		Product p=productService.getProduct(id);
		
		return new ResponseEntity<Product>(p,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/products/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Integer id){
		productService.deleteProduct(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping(value = "products/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable Integer id){
	   Product p = productService.updateProduct(product,id);
	   
	   return new ResponseEntity<Product>(p,HttpStatus.OK);
	}
	
	
	

	
}
