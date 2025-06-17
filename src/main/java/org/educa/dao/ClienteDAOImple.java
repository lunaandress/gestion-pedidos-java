package org.educa.dao;
import org.educa.dao.hibernate.DAOSession;
import org.educa.entity.ClienteEntity;
import org.hibernate.Hibernate;
import org.hibernate.Session;

public class ClienteDAOImple implements ClienteDAO {

    /**
     * Realiza el inicio de sesión de un cliente utilizando su DNI y contraseña.
     *
     * @param dni El DNI del cliente.
     * @param password La contraseña del cliente.
     * @return El {@link ClienteEntity} que coincide con el DNI y la contraseña proporcionados, o {@code null} si no se encuentra.
     */
    @Override
    public ClienteEntity login(String dni, String password) {

        try (Session session = DAOSession.getSession()) {

            ClienteEntity cliente = session.createQuery(
                            "FROM ClienteEntity c WHERE c.dni = :dn AND c.pass = :pasw", ClienteEntity.class)
                    .setParameter("dn", dni)
                    .setParameter("pasw", password)
                    .uniqueResult();
            Hibernate.initialize(cliente.getDirecciones());
            return cliente;
        }

    }

}
