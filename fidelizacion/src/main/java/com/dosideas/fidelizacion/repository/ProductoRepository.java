/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dosideas.fidelizacion.repository;

import com.dosideas.fidelizacion.domain.Producto;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author migue
 */
public interface ProductoRepository extends JpaRepository <Producto, Integer>{
    
    //Selecciona todos los productos y los ordena por medio de su nombre
    @Query("Select prod from Producto prod order by prod.PROD_NOMBRE")
    List<Producto> buscarTodos();
    
    //Hace una lista de los productos buscandolos por medio del ID de su proveedor y los ordena por el nombre del proveedor
    @Query("from Producto prod where prod.proveedor.PROV_ID = ?1 order by prod.PROD_NOMBRE")
    List<Producto> buscarPorProveedor(int PROV_ID);

    //Busca los productos similares a la consulta hecha
    @Query("from Producto prod where prod.PROD_NOMBRE like %?1%")
    List<Producto> buscar(String consulta);
    
    //Hace una lista de productos buscandolos por medio de su ID de la categoria a la que pertenecen
    @Query("from Producto prod where prod.categoria.CAT_ID = ?1")
    List<Producto> buscarPorCategoria(int CAT_ID);
    
    //Consultas
    @Query("SELECT p FROM Producto p WHERE p.categoria.CAT_NOMBRE = ?1")
    List<Producto> subconsulta1(String param1);

    @Query("SELECT p FROM Producto p WHERE p.proveedor.PROV_NOMBRE = ?1")
    List<Producto> subconsulta2(String param2);

    @Query("SELECT p FROM Producto p WHERE p.PROD_PRECIO_VENTA > :precioVenta AND p.PROD_PRECIO_VENTA > (SELECT AVG(p2.PROD_PRECIO_VENTA) FROM Producto p2)")
List<Producto> buscarPorPrecioVentaMayorAlPromedio(@Param("precioVenta") double precioVenta);

    @Query("SELECT p FROM Producto p WHERE p.PROD_EXISTENCIA < :existencia AND p.PROD_EXISTENCIA < (SELECT AVG(p2.PROD_EXISTENCIA) FROM Producto p2)")
List<Producto> buscarPorExistenciaMenorAlPromedio(@Param("existencia") int existencia);


}
