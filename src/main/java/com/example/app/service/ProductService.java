package com.example.app.service;

import java.util.List;

import com.example.app.model.Product;

public interface ProductService {

	Product saveProduct(Product product);

	List<Product> getAllProducts();

	Product getProduct(Integer id);

	void deleteProduct(Integer id);

	Product updateProduct(Product product, Integer id);

	



}
