package com.sistema.biblioteca.view;

import com.sistema.biblioteca.controller.LivroController;
import com.sistema.biblioteca.model.Livro;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LivroView {

    LivroController lc = new LivroController();

    @GetMapping("/livro")
    public List<Livro> getAllLivros() {
        return lc.pegarTodosOsLivros();
    }

    @PostMapping("/livro")
    public String postNovoLivro(@RequestBody Livro l) {
        lc.inserirNoBanco(l);
        return "Sucesso!";
    }

    // Novo endpoint para atualizar um livro existente
    @PutMapping("/livro/{id}")
    public String putAtualizarLivro(@PathVariable int id, @RequestBody Livro livroAtualizado) {
        Livro livroExistente = lc.pegarLivroPorId(id);
        if (livroExistente == null) {
            return "Livro com ID " + id + " não encontrado.";
        }

        // Garantir que o ID do livro atualizado seja o mesmo do path
        livroAtualizado.setIdLivro(id);
        boolean sucesso = lc.atualizarLivro(livroAtualizado);
        if (sucesso) {
            return "Livro atualizado com sucesso!";
        } else {
            return "Falha ao atualizar o livro.";
        }
    }

    // Novo endpoint para deletar um livro
    @DeleteMapping("/livro/{id}")
    public String deleteLivro(@PathVariable int id) {
        boolean sucesso = lc.deletarLivro(id);
        if (sucesso) {
            return "Livro com ID " + id + " deletado com sucesso!";
        } else {
            return "Livro com ID " + id + " não encontrado.";
        }
    }
}