package com.example.ControleDeProdutos.controller;

import com.example.ControleDeProdutos.model.Produto;
import com.example.ControleDeProdutos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//controlador REST
@RequestMapping("/produtos") // Define a rota base
public class ProdutoController {

    @Autowired  // Injeta automaticamente uma instância de ProdutoService
    private ProdutoService produtoService;

    // Listar todos os produtos
    @GetMapping // Configura esta rota para o método HTTP GET na URL /produtos.
    public ResponseEntity<List<Produto>> listarTodos() {
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    // Buscar produto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

    // Inserir um novo produto
    @PostMapping
    public ResponseEntity<Produto> inserir(@RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.salvar(produto));
    }

    // Editar um produto
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Integer id, @RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.atualizar(id, produto));
    }

    // Excluir um produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        produtoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
