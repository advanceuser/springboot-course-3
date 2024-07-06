package com.luis.curso.springboot.di.app.services;

import java.util.List;

import com.luis.curso.springboot.di.app.models.Product;

public interface IProductService {

	public List<Product> findAll();

	public Product findById(Long id);
}
