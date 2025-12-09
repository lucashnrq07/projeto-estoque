package com.lucas.projeto_estoque.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "tb_products")
public class Product implements Serializable {
    private static final long SerieVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate entryDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;
    private Integer quantity;

    // construtor sem argumentos
    public Product() {
    }

    // construtor com argumentos
    public Product(Long id, String name, LocalDate entryDate, LocalDate expirationDate, Integer quantity) {
        this.id = id;
        if (expirationDate.isBefore(entryDate)) {
            throw new IllegalArgumentException("A data de validade não pode ser antes da data de entrada.");
        }
        this.name = name;
        this.entryDate = entryDate;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
    }

    // getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    // método que verifica se um produto está vencido
    public boolean isExpired() {
        return expirationDate.isBefore(LocalDate.now());
    }

    // método que verifica quantos dias para o produto vencer
    @JsonProperty
    public long daysToExpire() {
        return ChronoUnit.DAYS.between(LocalDate.now(), expirationDate);
    }

    // equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product p = (Product) o;

        return name.equalsIgnoreCase(p.name)
                && expirationDate.equals(p.expirationDate);
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode() * 31 + expirationDate.hashCode();
    }
}
