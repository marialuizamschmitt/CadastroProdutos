package com.example.ControleDeProdutos.model;

import jakarta.persistence.*;

@Entity //entidade gerenciada pelo JPA
@Table (name = "Produtos") // nome da tabela dentro do banco

public class Produto{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //ordenar id
    private Integer id;
    private String nome;
    private String descricao;
    private Double preco;
    private Integer quantidade; // colunas da tabela

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    // Permitem acessar e alterar o valor do atributo nome.

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    // Permitem acessar e alterar o valor do atributo descricao.
    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    // Permitem acessar e alterar o valor do atributo nome.

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    // Permitem acessar e alterar o valor do atributo quantidade.

}


