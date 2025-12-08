package com.lucas.projeto_estoque.config;

import com.lucas.projeto_estoque.entities.Product;
import com.lucas.projeto_estoque.entities.User;
import com.lucas.projeto_estoque.repositories.ProductRepository;
import com.lucas.projeto_estoque.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Odair da Silva", "odair@gmail.com", "123456");
        userRepository.saveAll(Arrays.asList(u1));

        Product p1 = new Product(null, "Arroz", LocalDate.parse("2025-12-01"), LocalDate.parse("2026-06-11"), 10);
        Product p2 = new Product(null, "Feijão", LocalDate.parse("2025-12-01"), LocalDate.parse("2025-12-30"), 8);
        Product p3 = new Product(null, "Leite", LocalDate.parse("2025-12-01"), LocalDate.parse("2026-01-24"), 15);
        productRepository.saveAll(Arrays.asList(p1, p2, p3));
    }
}
