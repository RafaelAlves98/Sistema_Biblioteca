package com.sistema.biblioteca.model;

public class Livro {

    private int idLivro;
    private String nomeLivro;
    private String autor;
    private String generoLivro;

    // Construtor
    public Livro(int idLivro, String nomeLivro, String autor, String generoLivro) {
        this.idLivro = idLivro;
        this.nomeLivro = nomeLivro;
        this.autor = autor;
        this.generoLivro = generoLivro;
    }

    // Getters e Setters
    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGeneroLivro() {
        return generoLivro;
    }

    public void setGeneroLivro(String generoLivro) {
        this.generoLivro = generoLivro;
    }

    // Método para exibir as informações do livro
    public void exibirInfo() {
        System.out.println("ID: " + idLivro);
        System.out.println("Nome: " + nomeLivro);
        System.out.println("Autor: " + autor);
        System.out.println("Gênero: " + generoLivro);
    }
}
