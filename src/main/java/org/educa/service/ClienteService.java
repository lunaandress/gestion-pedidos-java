package org.educa.service;

import org.educa.dao.ClienteDAO;
import org.educa.dao.ClienteDAOImple;
import org.educa.entity.ClienteEntity;

public class ClienteService {

    private final ClienteDAO clienteDAO = new ClienteDAOImple();

    //TODO: Método de login
    public ClienteEntity login(String dni, String password) {
        return clienteDAO.login(dni, password);
    }
}
