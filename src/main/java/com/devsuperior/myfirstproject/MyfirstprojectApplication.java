package com.devsuperior.myfirstproject;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.myfirstproject.entities.Category;
import com.devsuperior.myfirstproject.entities.Product;
import com.devsuperior.myfirstproject.repositories.CategoryRepository;
import com.devsuperior.myfirstproject.repositories.ProductRepository;

@SpringBootApplication
public class MyfirstprojectApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository cr;
	@Autowired
	private ProductRepository pr;
	
	public static void main(String[] args) {
		SpringApplication.run(MyfirstprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Cria duas categorias
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		//Cria quatro produtos
		Product p1 = new Product(null, "TV", 2200.00, cat1);
		Product p2 = new Product(null, "Domain Driven Design", 120.00, cat2);
		Product p3 = new Product(null, "PS5", 2800.00, cat1);
		Product p4 = new Product(null, "Docker", 100.00, cat2);
		// Adiciona os produtos a uma lista e adiciona essa lista às categorias 
		cat1.getProducts().addAll(Arrays.asList(p1, p3)); 
		cat2.getProducts().addAll(Arrays.asList(p2, p4));
		// Salva
		cr.save(cat1);
		cr.save(cat2);
		pr.save(p1);
		pr.save(p2);
		pr.save(p3);
		pr.save(p4);
	}
}
