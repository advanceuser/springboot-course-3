package com.luis.curso.springboot.di.app.repositories;

import java.util.List;

import com.luis.curso.springboot.di.app.models.Product;

public interface IProductRepository {

	public List<Product> findAll();
	
	public Product findById(Long id);
}
