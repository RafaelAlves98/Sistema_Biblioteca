package com.sistema.biblioteca.controller;

import com.sistema.biblioteca.banco.BancoDeEmprestimos;
import com.sistema.biblioteca.model.Cliente;
import com.sistema.biblioteca.model.Emprestimo;
import com.sistema.biblioteca.model.Livro;

import java.time.LocalDate;
import java.util.List;

public class EmprestimoController {
    BancoDeEmprestimos be = new BancoDeEmprestimos();

    public void inserirNoBanco(Emprestimo e) {
        be.insert(e);
    }

    public List<Emprestimo> pegarTodosOsEmprestimos() {
        return be.findAll();
    }

    public Emprestimo pegarEmprestimoPorId(int id) {
        return be.findOne(id);
    }

    public boolean atualizarEmprestimo(Emprestimo e) {
        return be.update(e);
    }

    public boolean deletarEmprestimo(int id) {
        return be.delete(id);
    }

    public List<Emprestimo> pegarEmprestimosPorDataFim(LocalDate dataFim) {
        return be.findByDataFim(dataFim);
    }

    public boolean adicionarLivroAoEmprestimo(int idEmprestimo, Livro livro) {
        return be.adicionarLivro(idEmprestimo, livro);
    }

    public boolean atualizarDataFim(int idEmprestimo, LocalDate novaDataFim) {
        Emprestimo emprestimo = be.findOne(idEmprestimo);
        if (emprestimo != null) {
            emprestimo.setDataFim(novaDataFim);
            return be.update(emprestimo);
        }
        return false;
    }

    public boolean atualizarClienteDoEmprestimo(int idEmprestimo, Cliente novoCliente) {
        Emprestimo emprestimo = be.findOne(idEmprestimo);
        if (emprestimo != null) {
            emprestimo.setCliente(novoCliente);
            return be.update(emprestimo);
        }
        return false;
    }
}