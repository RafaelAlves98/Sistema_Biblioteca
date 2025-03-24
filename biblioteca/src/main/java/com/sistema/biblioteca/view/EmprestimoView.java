package com.sistema.biblioteca.view;

import com.sistema.biblioteca.controller.EmprestimoController;
import com.sistema.biblioteca.model.Cliente;
import com.sistema.biblioteca.model.Emprestimo;
import com.sistema.biblioteca.model.Livro;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoView {
    EmprestimoController ec = new EmprestimoController();

    // Endpoint para buscar todos os empréstimos inseridos
    @GetMapping
    public List<Emprestimo> getAllEmprestimos() {
        return ec.pegarTodosOsEmprestimos();
    }

    // Endpoint para inserir empréstimos
    @PostMapping
    public String postNovoEmprestimo(@RequestBody Emprestimo e) {
        ec.inserirNoBanco(e);
        return "Empréstimo adicionado com sucesso!";
    }

    // Endpoint para buscar todos os empréstimos por data final
    @GetMapping("/data-fim")
    public List<Emprestimo> getEmprestimosPorDataFim(
            @RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {
        return ec.pegarEmprestimosPorDataFim(dataFim);
    }

    // Endpoint para atualizar pelo ID empréstimo já feito
    @PutMapping("/{id}")
    public String putAtualizarEmprestimo(@PathVariable int id, @RequestBody Emprestimo emprestimoAtualizado) {
        Emprestimo emprestimoExistente = ec.pegarEmprestimoPorId(id);
        if (emprestimoExistente == null) {
            return "Empréstimo com ID " + id + " não encontrado.";
        }
        emprestimoAtualizado.setIdEmprestimo(id); // Garante que o ID não mude
        boolean sucesso = ec.atualizarEmprestimo(emprestimoAtualizado);
        return sucesso ? "Empréstimo atualizado com sucesso!" : "Falha ao atualizar o empréstimo.";
    }

    // Endpoint para deletar um empréstimo pelo ID
    @DeleteMapping("/{id}")
    public String deleteEmprestimo(@PathVariable int id) {
        boolean sucesso = ec.deletarEmprestimo(id);
        return sucesso ? "Empréstimo com ID " + id + " deletado com sucesso!" :
                "Empréstimo com ID " + id + " não encontrado.";
    }

    // POST - Adiciona um livro a um empréstimo existente
    @PostMapping("/{id}/livro")
    public String postAdicionarLivro(@PathVariable int id, @RequestBody Livro livro) {
        boolean sucesso = ec.adicionarLivroAoEmprestimo(id, livro);
        return sucesso ? "Livro adicionado ao empréstimo com sucesso!" :
                "Empréstimo com ID " + id + " não encontrado.";
    }

    // PUT - Atualiza a data final de um empréstimo
    @PutMapping("/{id}/data-fim")
    public String putAtualizarDataFim(@PathVariable int id, @RequestParam("novaData") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate novaDataFim) {
        boolean sucesso = ec.atualizarDataFim(id, novaDataFim);
        return sucesso ? "Data final atualizada com sucesso!" :
                "Empréstimo com ID " + id + " não encontrado.";
    }

    // PUT - Atualiza o cliente de um empréstimo
    @PutMapping("/{id}/cliente")
    public String putAtualizarCliente(@PathVariable int id, @RequestBody Cliente novoCliente) {
        boolean sucesso = ec.atualizarClienteDoEmprestimo(id, novoCliente);
        return sucesso ? "Cliente do empréstimo atualizado com sucesso!" : "Empréstimo com ID " + id + " não encontrado.";
    }
}