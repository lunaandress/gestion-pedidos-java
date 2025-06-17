package org.educa.service;

import org.educa.dao.PedidoDAO;
import org.educa.dao.PedidoDAOImple;
import org.educa.entity.PedidoEntity;

public class PedidoService {

    private final PedidoDAO pedidoDAO = new PedidoDAOImple();

    //TODO: Crear pedido
    public void insertarPedido(PedidoEntity pedido) {
        pedidoDAO.insertarPedido(pedido);

    }
}
