/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dosideas.fidelizacion.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 *
 * @author migue
 */
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PROD_ID;
    private String PROD_URL_IMAGEN;
    private String PROD_NOMBRE;
    private BigDecimal PROD_PRECIO_COMPRA;
    private BigDecimal PROD_PRECIO_VENTA;
    private int PROD_PUNTOS;
    private int PROD_EXISTENCIA;
    //Indica que la relacion es de Muchos a uno
    @ManyToOne
    //Columna en la base de datos que referencia a Categoria
    @JoinColumn(name = "CAT_ID")
    private Categoria categoria;
    //Indica que la relacion es de Muchos a uno
    @ManyToOne
    //Columna en la base de datos que referencia a Proveedor
    @JoinColumn(name = "PROV_ID")
    private Proveedor proveedor;

    /**
     * @return the PROD_ID
     */
    public int getPROD_ID() {
        return PROD_ID;
    }

    /**
     * @param PROD_ID the PROD_ID to set
     */
    public void setPROD_ID(int PROD_ID) {
        this.PROD_ID = PROD_ID;
    }

    /**
     * @return the PROD_PRECIO_COMPRA
     */
    public BigDecimal getPROD_PRECIO_COMPRA() {
        return PROD_PRECIO_COMPRA;
    }

    /**
     * @param PROD_PRECIO_COMPRA the PROD_PRECIO_COMPRA to set
     */
    public void setPROD_PRECIO_COMPRA(BigDecimal PROD_PRECIO_COMPRA) {
        this.PROD_PRECIO_COMPRA = PROD_PRECIO_COMPRA;
    }

    /**
     * @return the PROD_PRECIO_VENTA
     */
    public BigDecimal getPROD_PRECIO_VENTA() {
        return PROD_PRECIO_VENTA;
    }

    /**
     * @param PROD_PRECIO_VENTA the PROD_PRECIO_VENTA to set
     */
    public void setPROD_PRECIO_VENTA(BigDecimal PROD_PRECIO_VENTA) {
        this.PROD_PRECIO_VENTA = PROD_PRECIO_VENTA;
    }

    /**
     * @return the PROD_PUNTOS
     */
    public int getPROD_PUNTOS() {
        return PROD_PUNTOS;
    }

    /**
     * @param PROD_PUNTOS the PROD_PUNTOS to set
     */
    public void setPROD_PUNTOS(int PROD_PUNTOS) {
        this.PROD_PUNTOS = PROD_PUNTOS;
    }

    /**
     * @return the PROD_EXISTENCIA
     */
    public int getPROD_EXISTENCIA() {
        return PROD_EXISTENCIA;
    }

    /**
     * @param PROD_EXISTENCIA the PROD_EXISTENCIA to set
     */
    public void setPROD_EXISTENCIA(int PROD_EXISTENCIA) {
        this.PROD_EXISTENCIA = PROD_EXISTENCIA;
    }

    /**
     * @return the proveedor
     */
    public Proveedor getProveedor() {
        return proveedor;
    }

    /**
     * @param proveedor the proveedor to set
     */
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the PROD_URL_IMAGEN
     */
    public String getPROD_URL_IMAGEN() {
        return PROD_URL_IMAGEN;
    }

    /**
     * @param PROD_URL_IMAGEN the PROD_URL_IMAGEN to set
     */
    public void setPROD_URL_IMAGEN(String PROD_URL_IMAGEN) {
        this.PROD_URL_IMAGEN = PROD_URL_IMAGEN;
    }

    /**
     * @return the PROD_NOMBRE
     */
    public String getPROD_NOMBRE() {
        return PROD_NOMBRE;
    }

    /**
     * @param PROD_NOMBRE the PROD_NOMBRE to set
     */
    public void setPROD_NOMBRE(String PROD_NOMBRE) {
        this.PROD_NOMBRE = PROD_NOMBRE;
    }

}
