package com.luis.curso.springboot.di.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.luis.curso.springboot.di.app.models.Product;
import com.luis.curso.springboot.di.app.repositories.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	@Qualifier("productJson") // Se queda como primary RepoImpl
	private IProductRepository productRepository;

	@Value("${config.price.tax}")
	private double taxValue;

	public List<Product> findAll() {
		return productRepository.findAll().stream().map(p -> {
			Double priceTax = p.getPrice() * taxValue;
			// Product newProd = new Product(p.getId(), p.getName(), priceImp.longValue());

			/*
			 * Esta seccion de codigo aplica para la implementacion repository con
			 * anotacion @RequestScope Aplica unicamente a cada peticion del objeto [No
			 * singleton]
			 */
//			 p.setPrice(priceTax.longValue());
//			 return p;

			/*
			 * Esta seccion de codigo muta el objeto del repository
			 */
			Product newProd = (Product) p.clone();
			newProd.setPrice(priceTax.longValue());
			return newProd;

		}).collect(Collectors.toList());
	}

	public Product findById(Long id) {
		return productRepository.findById(id);
	}

}
