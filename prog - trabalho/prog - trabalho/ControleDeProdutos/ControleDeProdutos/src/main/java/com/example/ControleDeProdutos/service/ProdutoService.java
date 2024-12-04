package com.example.ControleDeProdutos.service;

import com.example.ControleDeProdutos.model.Produto;
import com.example.ControleDeProdutos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Listar todos os produtos
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    // Buscar produto por ID
    public Produto buscarPorId(Integer id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
    }

    // Salvar novo produto
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    // Atualizar produto existente
    public Produto atualizar(Integer id, Produto produto) {
        Produto produtoExistente = buscarPorId(id);
        produtoExistente.setNome(produto.getNome());
        produtoExistente.setDescricao(produto.getDescricao());
        produtoExistente.setPreco(produto.getPreco());
        produtoExistente.setQuantidade(produto.getQuantidade());
        return produtoRepository.save(produtoExistente);
    }

    // Excluir produto
    public void excluir(Integer id) {
        Produto produto = buscarPorId(id);
        produtoRepository.delete(produto);
    }
}
