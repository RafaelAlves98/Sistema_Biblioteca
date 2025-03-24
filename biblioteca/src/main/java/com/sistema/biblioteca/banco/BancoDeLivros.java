package com.sistema.biblioteca.banco;

import com.sistema.biblioteca.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class BancoDeLivros {
    private List<Livro> livros;

    public BancoDeLivros() {
        this.livros = new ArrayList<>();
    }

    // Insere um novo livro na lista de empréstimo
    public void insert(Livro l) {
        livros.add(l);
    }

    // Busca um livro pelo ID
    public Livro findOne(int id) {
        for (Livro l : livros) {
            if (l.getIdLivro() == id) {
                return l;
            }
        } return null;
    }

    // Mostra todos os livros emprestados
    public List<Livro> findAll() {
        return new ArrayList<>(livros);
    }


    // Atualiza um livro pelo ID
    public boolean update(Livro l) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getIdLivro() == l.getIdLivro()) {
                livros.set(i, l);
                return true;
            }
        } return false;
    }

    // Deleta um livro pelo ID
    public boolean delete(int id) {
        return livros.removeIf(l -> l.getIdLivro() == id);
    }

}
