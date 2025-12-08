package com.lucas.projeto_estoque.util;

import java.time.LocalDate;

public class ValidationUtils {

    private ValidationUtils() {
    }

    // garante que o produto tenha nome
    public static void validName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
    }

    // garante que a data de entrada não seja uma data futura
    public static void validEntryDate(LocalDate entryDate) {
        LocalDate today = LocalDate.now();
        if (entryDate.isAfter(today)) {
            throw new IllegalArgumentException("Data de entrada não pode ser uma data futura.");
        }
    }

    // garante que a data de validade não seja uma data passada
    public static void validExpirationDate(LocalDate expirationDate) {
        LocalDate today = LocalDate.now();
        if (expirationDate.isBefore(today)) {
            throw new IllegalArgumentException("Data de validade não pode ser uma data passada.");
        }
    }

    //garante que a quantidade seja maior que zero
    public static void validQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantidade não pode ser igual ou menor que zero.");
        }
    }
}
