package com.sistema.biblioteca.controller;

import com.sistema.biblioteca.banco.BancoDeLivros;
import com.sistema.biblioteca.model.Livro;

import java.util.List;

public class LivroController {

    BancoDeLivros bl = new BancoDeLivros();

    // Método para inserir um livro
    public void inserirNoBanco(Livro l) {
        bl.insert(l);
    }

    // Método para buscar todos os livros
    public List<Livro> pegarTodosOsLivros() {
        return bl.findAll();
    }

    // Método para atualizar um livro
    public boolean atualizarLivro(Livro l) {
        return bl.update(l);
    }

    // Método para deletar um livro pelo ID
    public boolean deletarLivro(int id) {
        return bl.delete(id);
    }

    // Método para buscar um livro específico
    public Livro pegarLivroPorId(int id) {
        return bl.findOne(id);
    }
}