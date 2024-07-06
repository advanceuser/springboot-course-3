package com.luis.curso.springboot.di.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import com.luis.curso.springboot.di.app.repositories.IProductRepository;
import com.luis.curso.springboot.di.app.repositories.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

	@Value("classpath:json/product.json")
	private Resource resource;

	@Bean("productJson") // Se le da nombre cuando no queremos que se llame igual al metodo
	IProductRepository productRepositoryJson() {
		return new ProductRepositoryJson(resource);
	}
}
