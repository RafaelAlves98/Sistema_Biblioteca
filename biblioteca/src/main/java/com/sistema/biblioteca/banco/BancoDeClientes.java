package com.sistema.biblioteca.banco;

import com.sistema.biblioteca.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class BancoDeClientes {
    private List<Cliente> clientes;

    public BancoDeClientes() {
        this.clientes = new ArrayList<>();
    }

    // Insere um novo cliente
    public void insert(Cliente c) {
        clientes.add(c);
    }

    // Busca um cliente pelo ID
    public Cliente findOne(int id) {
        for (Cliente c : clientes) {
            if (c.getIdCliente() == id) {
                return c;
            }
        }
        return null;
    }

    // Mostra todos os clientes
    public List<Cliente> findAll() {
        return new ArrayList<>(clientes);
    }

    // Atualiza um cliente pelo ID
    public boolean update(Cliente c) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getIdCliente() == c.getIdCliente()) {
                clientes.set(i, c);
                return true;
            }
        }
        return false;
    }

    // Deleta um cliente pelo ID
    public boolean delete(int id) {
        return clientes.removeIf(c -> c.getIdCliente() == id);
    }
}