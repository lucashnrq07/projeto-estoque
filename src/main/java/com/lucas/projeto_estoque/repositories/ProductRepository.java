package com.lucas.projeto_estoque.repositories;

import com.lucas.projeto_estoque.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// repositório de produtos
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByNameIgnoreCase(String name);
}
