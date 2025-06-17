package org.educa.dao;

import org.educa.dao.hibernate.DAOSession;
import org.educa.entity.ProductoEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class ProductoDAOImple implements ProductoDAO {

    /**
     * Obtiene todos los productos de la base de datos, calcula su precio final aplicando el descuento
     * y elimina los productos duplicados basados en el nombre.
     *
     * @return Una lista de productos únicos con su precio final calculado. Si ocurre un error, se retorna una lista vacía.
     */
    @Override
    public List<ProductoEntity> findAllProducts() {
        try (Session session = DAOSession.getSession()) {

            List<ProductoEntity> listaProductos = session.createQuery("FROM ProductoEntity p", ProductoEntity.class).getResultList();

            for (ProductoEntity productoEntity : listaProductos) {

                BigDecimal precioFinal = productoEntity.getPrecio().multiply(productoEntity.getDescuento().stripTrailingZeros());
                BigDecimal precioFormateado = precioFinal.setScale(1, RoundingMode.HALF_UP);
                productoEntity.setPrecioFinal(precioFormateado);
            }

            Map<String, ProductoEntity> productosMap = new HashMap<>();
            for (ProductoEntity producto : listaProductos) {
                productosMap.putIfAbsent(producto.getNombre(), producto);
            }
            return new ArrayList<>(productosMap.values());
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


    /**
     * Obtiene el primer producto que coincide con el nombre, talla y color especificados.
     *
     * @param nombre El nombre del producto.
     * @param talla  La talla del producto.
     * @param color  El color del producto.
     * @return El primer {@link ProductoEntity} que coincide con los parámetros, o {@code null} si no se encuentra.
     * @throws Exception Si ocurre un error durante la consulta.
     */
    @Override
    public ProductoEntity getFirstProductoByNameTallaAndColor(String nombre, String talla, String color) {
        try (Session session = DAOSession.getSession()) {
            return session.createQuery("FROM ProductoEntity " +
                            "WHERE nombre = :name AND talla = :size AND color = :colors", ProductoEntity.class)
                    .setParameter("name", nombre)
                    .setParameter("size", talla)
                    .setParameter("colors", color)
                    .setMaxResults(1)
                    .uniqueResult();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Busca productos por nombre.
     *
     * @param producto El objeto {@link ProductoEntity} que contiene el nombre a buscar.
     * @return Una lista de {@link ProductoEntity} que coinciden con el nombre proporcionado.
     */
    @Override
    public List<ProductoEntity> findByName(ProductoEntity producto) {

        try (Session session = DAOSession.getSession()) {

            Query<ProductoEntity> q = session.createQuery("FROM ProductoEntity  where nombre=:name", ProductoEntity.class)
                    .setParameter("name", producto.getNombre());
            List<ProductoEntity> listapro = q.getResultList();
            return listapro;
        }
    }
}
