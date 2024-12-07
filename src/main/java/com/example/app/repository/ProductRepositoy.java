package com.example.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.model.Product;

@Repository
public interface ProductRepositoy extends JpaRepository<Product, Integer>{
	
	
}
