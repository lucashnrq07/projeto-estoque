package com.lucas.projeto_estoque.resources;

import com.lucas.projeto_estoque.entities.Product;
import com.lucas.projeto_estoque.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService service;

    // retorna todos os produtos ordenados por validade
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = service.listOrderedByExpiration();
        return ResponseEntity.ok().body(list);
    }

    // busca um produto pelo nome
    @GetMapping(value = "/{name}")
    public ResponseEntity<Product> findByName(@PathVariable String name) {
        Product obj = service.findProduct(name);
        return ResponseEntity.ok().body(obj);
    }

    // insere um novo produto se existir
    // se não existir, soma a quantidade
    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody Product obj) {
        Product newObj = service.insert(obj);
        return ResponseEntity.ok().body(newObj);
    }

    //deleta um produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.removeProduct(id);
        return ResponseEntity.noContent().build();
    }

    // atualiza um produto
    @PatchMapping("/{id}")
    public ResponseEntity<Product> partialUpdate(
            @PathVariable Long id,
            @RequestBody Product obj) {

        Product updated = service.partialUpdate(id, obj);
        return ResponseEntity.ok(updated);
    }


}
