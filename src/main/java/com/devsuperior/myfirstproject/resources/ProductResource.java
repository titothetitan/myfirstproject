package com.devsuperior.myfirstproject.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.myfirstproject.entities.Product;
import com.devsuperior.myfirstproject.repositories.ProductRepository;

@RestController // define que a classe será um recurso REST
@RequestMapping(value = "/products") // define o caminho pelo qual o recurso vai responder
public class ProductResource {
	
	@Autowired // obtém a depêndencia ProductRepository por baixo dos panos
	private ProductRepository productRepository;

	@GetMapping // ao inserir no navegador localhost:8080/caregories será chamada esta função
	public ResponseEntity<List<Product>> findAll() { //retorna uma lista de Categorias
		List<Product> list = productRepository.findAll();  		
		return ResponseEntity.ok().body(list); //instaciar uma resposta de código 200
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) { // PathVariable reconhece o /id 
		Product product = productRepository.findById(id).get(); 
		return ResponseEntity.ok().body(product);
	}
}
