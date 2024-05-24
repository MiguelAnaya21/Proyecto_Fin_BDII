/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dosideas.fidelizacion.repository;

import com.dosideas.fidelizacion.domain.Proveedor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author migue
 */
public interface ProveedorRepository extends JpaRepository <Proveedor, Integer> {
    //Hace una lista de los proveedires que hay y los ordena por medio de su nombre
    @Query("Select prov from Proveedor prov order by prov.PROV_NOMBRE")
    List<Proveedor> buscarTodos();
    
    //Busca el proveedor similar a la consulta hecha
    @Query("from Proveedor prov where prov.PROV_NOMBRE like %?1%")
    List<Proveedor> buscar(String consulta);
    
    //CONSULTAS MULTITABLA
    // 1. Proveedores con Valoración Mayor a un Valor Específico
    @Query("from Proveedor prov where prov.PROV_VALORACION > ?1 order by prov.PROV_NOMBRE")
    List<Proveedor> buscarPorValoracionMayorA(double valoracion);

    // 2. Proveedores que Suministran Productos con Precio de Venta Mayor a un Valor Específico
    @Query("from Proveedor prov where prov.PROV_ID in (select prod.proveedor.PROV_ID from Producto prod where prod.PROD_PRECIO_VENTA > ?1) order by prov.PROV_NOMBRE")
    List<Proveedor> buscarProveedoresConProductosPrecioVentaMayorA(double precioVenta);

}
