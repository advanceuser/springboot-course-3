package com.luis.curso.springboot.di.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luis.curso.springboot.di.app.models.Product;
import com.luis.curso.springboot.di.app.services.IProductService;

@RestController
@RequestMapping("/api")
public class SomeController {

	@Autowired
	private IProductService productService;

	@GetMapping({ "", "/" })
	public List<Product> list() {
		return productService.findAll();
	}

	@GetMapping("/{id}")
	public Product show(@PathVariable Long id) {
		return productService.findById(id);
	}
}
