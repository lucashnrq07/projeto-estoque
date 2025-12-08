package com.lucas.projeto_estoque.services;

import com.lucas.projeto_estoque.entities.Product;
import com.lucas.projeto_estoque.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    // listar em ordem de validade
    public List<Product> listOrderedByExpiration() {
        List<Product> produtos = new ArrayList<>(repository.findAll());
        produtos.sort(Comparator.comparing(Product::getExpirationDate));
        return List.copyOf(produtos);
    }

    // buscar produto
    public Product findProduct(String name) {
        for (Product p : repository.findAll()) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
}

