package com.sistema.biblioteca.controller;

import com.sistema.biblioteca.banco.BancoDeClientes;
import com.sistema.biblioteca.model.Cliente;

import java.util.List;

public class ClienteController {
    BancoDeClientes bc = new BancoDeClientes();

    public void inserirNoBanco(Cliente c) {
        bc.insert(c);
    }

    public List<Cliente> pegarTodosOsClientes() {
        return bc.findAll();
    }

    public Cliente pegarClientePorId(int id) {
        return bc.findOne(id);
    }

    public boolean atualizarCliente(Cliente c) {
        return bc.update(c);
    }

    public boolean deletarCliente(int id) {
        return bc.delete(id);
    }
}