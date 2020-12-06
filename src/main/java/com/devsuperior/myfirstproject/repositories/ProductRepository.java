package com.devsuperior.myfirstproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.devsuperior.myfirstproject.entities.Product;

@Repository // necessário para o Autowired funcionar!
public interface ProductRepository extends JpaRepository<Product, Long> {

}