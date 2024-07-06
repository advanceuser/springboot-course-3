package com.luis.curso.springboot.di.app.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.luis.curso.springboot.di.app.models.Product;

//Implementacion por default entre muchas implementaciones (Principal)
//@Primary
@Repository("productFoo")
public class ProductRepositoryFoo implements IProductRepository {

	@Override
	public List<Product> findAll() {
		return Collections.singletonList(new Product(1L, "Monitor Asus 27'", 600L));

	}

	@Override
	public Product findById(Long id) {
		return new Product(1L, "Monitor Asus 27'", 600L);
	}

}