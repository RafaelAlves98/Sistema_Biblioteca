package com.sistema.biblioteca.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Emprestimo {
    private int idEmprestimo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<Livro> livrosEmprestados;
    private Cliente cliente;

    // Construtor
    public Emprestimo(int idEmprestimo, LocalDate dataInicio, LocalDate dataFim, Cliente cliente) {
        this.idEmprestimo = idEmprestimo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.livrosEmprestados = new ArrayList<>();
        this.cliente = cliente;
    }

    // Getters e Setters
    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public List<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void adicionarLivro(Livro livro) {
        this.livrosEmprestados.add(livro);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}