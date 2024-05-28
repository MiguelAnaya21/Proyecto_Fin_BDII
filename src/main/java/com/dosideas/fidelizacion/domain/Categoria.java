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
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //Crea el ID para el tipo de categoria
    private int CAT_ID;
    //guarda el nombre de la categoria
    private String CAT_NOMBRE;

    /**
     * @return the CAT_ID
     */
    public int getCAT_ID() {
        return CAT_ID;
    }

    /**
     * @param CAT_ID the CAT_ID to set
     */
    public void setCAT_ID(int CAT_ID) {
        this.CAT_ID = CAT_ID;
    }

    /**
     * @return the CAT_NOMBRE
     */
    public String getCAT_NOMBRE() {
        return CAT_NOMBRE;
    }

    /**
     * @param CAT_NOMBRE the CAT_NOMBRE to set
     */
    public void setCAT_NOMBRE(String CAT_NOMBRE) {
        this.CAT_NOMBRE = CAT_NOMBRE;
    }

}
