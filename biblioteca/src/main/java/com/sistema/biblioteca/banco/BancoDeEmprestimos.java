package com.sistema.biblioteca.banco;

import com.sistema.biblioteca.model.Emprestimo;
import com.sistema.biblioteca.model.Livro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BancoDeEmprestimos {
    private List<Emprestimo> emprestimos;

    public BancoDeEmprestimos() {
        this.emprestimos = new ArrayList<>();
    }

    // Insere um novo empréstimo
    public void insert(Emprestimo e) {
        emprestimos.add(e);
    }

    // Busca um empréstimo pelo ID
    public Emprestimo findOne(int id) {
        for (Emprestimo e : emprestimos) {
            if (e.getIdEmprestimo() == id) {
                return e;
            }
        }
        return null;
    }

    // Mostra todos os empréstimos
    public List<Emprestimo> findAll() {
        return new ArrayList<>(emprestimos);
    }

    // Atualiza um empréstimo pelo ID
    public boolean update(Emprestimo e) {
        for (int i = 0; i < emprestimos.size(); i++) {
            if (emprestimos.get(i).getIdEmprestimo() == e.getIdEmprestimo()) {
                emprestimos.set(i, e);
                return true;
            }
        }
        return false;
    }

    // Deleta um empréstimo pelo ID
    public boolean delete(int id) {
        return emprestimos.removeIf(e -> e.getIdEmprestimo() == id);
    }

    // Consulta empréstimos por data final (funcionalidade bônus)
    public List<Emprestimo> findByDataFim(LocalDate dataFim) {
        List<Emprestimo> resultado = new ArrayList<>();
        for (Emprestimo e : emprestimos) {
            if (e.getDataFim().equals(dataFim)) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    // Adiciona um livro a um empréstimo existente
    public boolean adicionarLivro(int idEmprestimo, Livro livro) {
        Emprestimo emprestimo = findOne(idEmprestimo);
        if (emprestimo != null) {
            emprestimo.adicionarLivro(livro);
            return true;
        }
        return false;
    }
}