package org.educa.dao;

import org.educa.dao.hibernate.DAOSession;
import org.educa.entity.EstadoPedidoEntity;
import org.educa.entity.PedidoEntity;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import java.sql.Timestamp;

public class PedidoDAOImple implements PedidoDAO {

    /**
     * Inserta un nuevo pedido en la base de datos.
     * Si el pedido no tiene un estado asignado, se establece el estado por defecto como "Preparando".
     *
     * @param pedido El {@link PedidoEntity} que se desea insertar.
     */
    @Override
    public void insertarPedido(PedidoEntity pedido) {
        try (Session session = DAOSession.getSession()) {

            if (pedido.getEstadoPedido() == null) {

                EstadoPedidoEntity estadoDefault = new EstadoPedidoEntity();
                estadoDefault.setId(1);
                estadoDefault.setNombre("Preparando");
                pedido.setEstadoPedido(estadoDefault);
                pedido.setFecha(new Timestamp(System.currentTimeMillis()));
            }
            Hibernate.initialize(pedido.getEstadoPedido());
            session.merge(pedido);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
