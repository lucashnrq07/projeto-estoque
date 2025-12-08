package com.lucas.projeto_estoque.services;

import com.lucas.projeto_estoque.entities.Product;
import com.lucas.projeto_estoque.repositories.ProductRepository;
import com.lucas.projeto_estoque.util.DateUtils;
import com.lucas.projeto_estoque.util.ValidationUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;
    private DateUtils dateUtils;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    // listar em ordem de validade
    public List<Product> listOrderedByExpiration() {
        List<Product> products = new ArrayList<>(repository.findAll());

        // remove automaticamente produtos vencidos
        products.removeIf(Product::isExpired);
        repository.deleteAll(products.stream()
                .filter(Product::isExpired)
                .toList());

        // ordena por validade
        products.sort(Comparator.comparing(Product::getExpirationDate));
        return List.copyOf(products);
    }

    // buscar produto pelo nome
    public Product findProduct(String name) {
        for (Product p : repository.findAll()) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    // adicionar produto
    public Product insert(Product obj) {
        // validações
        ValidationUtils.validName(obj.getName());
        ValidationUtils.validEntryDate(obj.getEntryDate());
        ValidationUtils.validExpirationDate(obj.getExpirationDate());
        ValidationUtils.validQuantity(obj.getQuantity());

        // procura produto existente com mesmo nome e data de entrada
        Optional<Product> existingProductOpt =
                repository.findByNameIgnoreCase(obj.getName());

        if (existingProductOpt.isPresent()) {
            Product existing = existingProductOpt.get();

            // soma quantidade se o produto já existe
            existing.setQuantity(existing.getQuantity() + obj.getQuantity());
            return repository.save(existing);
        }

        // cria se ele não existe
        return repository.save(obj);
    }

    // remover produto
    public void removeProduct(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado!"));

        repository.delete(product);
    }

    // atualizar um produto
    public Product partialUpdate(Long id, Product obj) {
        Product entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        // Atualiza só os campos presentes
        if (obj.getName() != null) {
            entity.setName(obj.getName());
        }
        if (obj.getEntryDate() != null) {
            entity.setEntryDate(obj.getEntryDate());
        }
        if (obj.getExpirationDate() != null) {
            entity.setExpirationDate(obj.getExpirationDate());
        }
        if (obj.getQuantity() != null) {
            entity.setQuantity(obj.getQuantity());
        }

        return repository.save(entity);
    }
}

