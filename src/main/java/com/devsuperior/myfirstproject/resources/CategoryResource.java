package com.devsuperior.myfirstproject.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.myfirstproject.entities.Category;
import com.devsuperior.myfirstproject.repositories.CategoryRepository;

@RestController // define que a classe será um recurso REST
@RequestMapping(value = "/categories") // define o caminho pelo qual o recurso vai responder
public class CategoryResource {
	
	@Autowired // obtém a depêndencia CategoryRepository por baixo dos panos
	private CategoryRepository categoryRepository;

	@GetMapping // ao inserir no navegador localhost:8080/caregories será chamada esta função
	public ResponseEntity<List<Category>> findAll() { //retorna uma lista de Categorias
		List<Category> list = categoryRepository.findAll();  		
		return ResponseEntity.ok().body(list); //instaciar uma resposta de código 200
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) { // PathVariable reconhece o /id 
		Category categoria = categoryRepository.findById(id).get(); 
		return ResponseEntity.ok().body(categoria);
	}
}
