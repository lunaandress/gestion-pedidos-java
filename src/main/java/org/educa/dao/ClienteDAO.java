package org.educa.dao;

import org.educa.entity.ClienteEntity;

public interface ClienteDAO {
    ClienteEntity login(String dni, String password);
}
