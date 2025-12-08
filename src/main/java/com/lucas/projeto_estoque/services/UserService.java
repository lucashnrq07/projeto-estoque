package com.lucas.projeto_estoque.services;

import com.lucas.projeto_estoque.entities.User;
import com.lucas.projeto_estoque.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    // busca todos os usuários
    public List<User> findAll() {
        return repository.findAll();
    }

    // busca um usuário pelo id
    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }
}
