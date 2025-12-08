package com.lucas.projeto_estoque.repositories;

import com.lucas.projeto_estoque.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

// repositório de usuários
public interface UserRepository extends JpaRepository<User, Long> {
}
