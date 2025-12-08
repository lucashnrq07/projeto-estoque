package com.lucas.projeto_estoque.repositories;

import com.lucas.projeto_estoque.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
