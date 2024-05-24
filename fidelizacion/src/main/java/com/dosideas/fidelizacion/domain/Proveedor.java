/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dosideas.fidelizacion.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author migue
 */
@Entity
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PROV_ID;
    private String PROV_NOMBRE;
    private String PROV_EMAIL;
    private String PROV_TELEFONO;
    private String PROV_DIRECCION;
    private int PROV_COD_POSTAL;
    private int PROV_VALORACION;


    /**
     * @return the PROV_ID
     */
    public int getPROV_ID() {
        return PROV_ID;
    }

    /**
     * @param PROV_ID the PROV_ID to set
     */
    public void setPROV_ID(int PROV_ID) {
        this.PROV_ID = PROV_ID;
    }

    /**
     * @return the PROV_NOMBRE
     */
    public String getPROV_NOMBRE() {
        return PROV_NOMBRE;
    }

    /**
     * @param PROV_NOMBRE the PROV_NOMBRE to set
     */
    public void setPROV_NOMBRE(String PROV_NOMBRE) {
        this.PROV_NOMBRE = PROV_NOMBRE;
    }

    /**
     * @return the PROV_EMAIL
     */
    public String getPROV_EMAIL() {
        return PROV_EMAIL;
    }

    /**
     * @param PROV_EMAIL the PROV_EMAIL to set
     */
    public void setPROV_EMAIL(String PROV_EMAIL) {
        this.PROV_EMAIL = PROV_EMAIL;
    }

    /**
     * @return the PROV_TELEFONO
     */
    public String getPROV_TELEFONO() {
        return PROV_TELEFONO;
    }

    /**
     * @param PROV_TELEFONO the PROV_TELEFONO to set
     */
    public void setPROV_TELEFONO(String PROV_TELEFONO) {
        this.PROV_TELEFONO = PROV_TELEFONO;
    }

    /**
     * @return the PROV_DIRECCION
     */
    public String getPROV_DIRECCION() {
        return PROV_DIRECCION;
    }

    /**
     * @param PROV_DIRECCION the PROV_DIRECCION to set
     */
    public void setPROV_DIRECCION(String PROV_DIRECCION) {
        this.PROV_DIRECCION = PROV_DIRECCION;
    }

    /**
     * @return the PROV_COD_POSTAL
     */
    public int getPROV_COD_POSTAL() {
        return PROV_COD_POSTAL;
    }

    /**
     * @param PROV_COD_POSTAL the PROV_COD_POSTAL to set
     */
    public void setPROV_COD_POSTAL(int PROV_COD_POSTAL) {
        this.PROV_COD_POSTAL = PROV_COD_POSTAL;
    }

    /**
     * @return the PROV_VALORACION
     */
    public int getPROV_VALORACION() {
        return PROV_VALORACION;
    }

    /**
     * @param PROV_VALORACION the PROV_VALORACION to set
     */
    public void setPROV_VALORACION(int PROV_VALORACION) {
        this.PROV_VALORACION = PROV_VALORACION;
    }
    
    
}
