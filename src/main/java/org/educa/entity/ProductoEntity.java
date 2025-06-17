package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the producto database table.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "producto")
public class ProductoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "codigo_barra")
    private String codigoBarra;
    private String color;
    private BigDecimal descuento;
    private String nombre;
    private BigDecimal precio;
    @Transient
    private BigDecimal precioFinal;

    private String talla;

    @Column(name = "fec_cre")
    private Timestamp fecCre;
    @Column(name = "fec_mod")
    private Timestamp fecMod;
    @Column(name = "usu_cre")
    private String usuCre;
    @Column(name = "usu_mod")
    private String usuMod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coleccion")
    private ColeccionEntity coleccionBean;// tablas con las que la clase comparte claves forneas

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado")
    private EstadoProductoEntity estadoProducto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo")
    private TipoProductoEntity tipoProducto;

    @ManyToMany(mappedBy = "productos")
    private List<PedidoEntity> pedidos;


}