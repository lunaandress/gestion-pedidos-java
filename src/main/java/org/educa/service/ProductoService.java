package org.educa.service;

import org.educa.dao.ProductoDAO;
import org.educa.dao.ProductoDAOImple;
import org.educa.entity.ProductoEntity;

import java.sql.SQLException;
import java.util.List;

public class ProductoService {

    private final ProductoDAO productoDAO = new ProductoDAOImple();

    //TODO: Método que devuelve todos los productos agrupado por Nombre de producto
    public List<ProductoEntity> findAllProducts() throws SQLException {
        return productoDAO.findAllProducts();
    }

    //TODO: Método que devuelve un producto por nombre, talla y color
    public ProductoEntity getFirstProductoByNameTallaAndColor(String nombre, String talla, String color) throws SQLException {
        return productoDAO.getFirstProductoByNameTallaAndColor(nombre, talla, color);
    }

    //TODO: Método que busca productos por nombre
    public List<ProductoEntity> findByName(ProductoEntity producto) throws SQLException {
        return productoDAO.findByName(producto);
    }

}
