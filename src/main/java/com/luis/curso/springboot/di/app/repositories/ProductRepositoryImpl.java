package com.luis.curso.springboot.di.app.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.luis.curso.springboot.di.app.models.Product;

@Repository("productList")
/*
 * La anotacion @RequestScope define un bean/componente como no singleton lo
 * configura para que aplique por peticion y despues sea destruido
 */
//@RequestScope
/*
 * La anotacion @SessionScope define un bean/componente como no singleton lo
 * configura para que aplique por sesion(mientras este activo un
 * cliente/navegador)
 */
//@SessionScope
@Primary
public class ProductRepositoryImpl implements IProductRepository {

	private List<Product> data;

	public ProductRepositoryImpl() {
		this.data = Arrays.asList(new Product(1L, "Memoria Corsair", 300L), new Product(2L, "CPU Intel Core i9", 850L),
				new Product(3L, "Teclado Raizen Mini 60%", 180L), new Product(4L, "Motherboard Gigabyte", 490L));
	}

	@Override
	public List<Product> findAll() {
		return data;
	}

	@Override
	public Product findById(Long id) {
		return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
	}
}
