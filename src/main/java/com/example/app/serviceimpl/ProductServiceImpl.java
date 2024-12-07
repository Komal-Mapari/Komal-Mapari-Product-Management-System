package com.example.app.serviceimpl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.app.model.Product;
import com.example.app.repository.ProductRepositoy;
import com.example.app.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{

	private ProductRepositoy productRepository;

	public ProductServiceImpl(ProductRepositoy productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public Product saveProduct(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> list = productRepository.findAll();
		return list;
	}
	
	@Override
	public Product getProduct(Integer id) {
		Product product = productRepository.findById(id).get();
		return product;
	}
	
	@Override
	public void deleteProduct(Integer id) {
		
	productRepository.deleteById(id);
		
	}
	
	@Override
		public Product updateProduct(Product product, Integer id) {
			if(productRepository.existsById(id)) {
				Product p = productRepository.save(product);
				
				return p;
			}
			
			return null;
		}	
	
	
	
}
