package org.educa.dao;

import org.educa.entity.ProductoEntity;

import java.util.List;

public interface ProductoDAO {
    List<ProductoEntity> findAllProducts();

    ProductoEntity getFirstProductoByNameTallaAndColor(String nombre, String talla, String color);

    List<ProductoEntity> findByName(ProductoEntity producto);
}
