package com.sistema.biblioteca.view;

import com.sistema.biblioteca.controller.ClienteController;
import com.sistema.biblioteca.model.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteView {
    ClienteController cc = new ClienteController();

    // Endpoint para buscar todos os clientes inseridos
    @GetMapping("/cliente")
    public List<Cliente> getAllClientes() {
        return cc.pegarTodosOsClientes();
    }

    // Endpoint para inserir clientes
    @PostMapping("/cliente")
    public String postNovoCliente(@RequestBody Cliente c) {
        cc.inserirNoBanco(c);
        return "Cliente adicionado com sucesso!";
    }

    // Endpoint para atualizar pelo ID cliente já cadastrado
    @PutMapping("/cliente/{id}")
    public String putAtualizarCliente(@PathVariable int id, @RequestBody Cliente clienteAtualizado) {
        Cliente clienteExistente = cc.pegarClientePorId(id);
        if (clienteExistente == null) {
            return "Cliente com ID " + id + " não encontrado.";
        }

        clienteAtualizado.setIdCliente(id); // Garante que o ID não seja alterado
        boolean sucesso = cc.atualizarCliente(clienteAtualizado);
        if (sucesso) {
            return "Cliente atualizado com sucesso!";
        } else {
            return "Falha ao atualizar o cliente.";
        }
    }

    // Endpoint para deletar o cliente pelo ID
    @DeleteMapping("/cliente/{id}")
    public String deleteCliente(@PathVariable int id) {
        boolean sucesso = cc.deletarCliente(id);
        if (sucesso) {
            return "Cliente com ID " + id + " deletado com sucesso!";
        } else {
            return "Cliente com ID " + id + " não encontrado.";
        }
    }
}