/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dosideas.fidelizacion.service;

import com.dosideas.fidelizacion.domain.Producto;
import com.dosideas.fidelizacion.repository.ProductoRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author migue
 */
@Service
public class ProductoService {
    
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    
    //Busca todos los productos que estan dados de alta en la BD
    public List<Producto> buscarDestacados(){
        return productoRepository.buscarTodos();
    }
    //Hace una lista de todos los productos que estan relacionados con el ID del proveedor
    public List<Producto> buscarPorProveedor(int PROV_ID){
        return productoRepository.buscarPorProveedor(PROV_ID);
    }
    //Hace una lista de todos los productos que estan relacionados con el ID de la categoria
    public List<Producto> buscarPorCategoria(int CAT_ID){
        return productoRepository.buscarPorCategoria(CAT_ID);
    }
    //Busca por medio de la consulta los productos similares a la consulta
    public List<Producto> buscar(String consulta){
        return productoRepository.buscar(consulta);
    }
    //Guarda los productos que son dados de alta
    public Producto guardar(Producto producto){
        return productoRepository.save(producto);
    }
    //Busca los productos por medio de su ID
    public Optional<Producto> buscarPorId(int id){
        return productoRepository.findById(id);        
    }
    //Elimina los productos por medio de su ID
    public void eliminarPorId(int id) {
        productoRepository.eliminar_producto(id);
    }
    //Guarda los cambios hechos al editar el producto
    public void guardarCambios(Producto producto){
        productoRepository.save(producto);
    }
    //Consultas
    public List<Producto> subconsulta1(String param1) {
        return productoRepository.subconsulta1(param1);
    }

    public List<Producto> subconsulta2(String param2) {
        return productoRepository.subconsulta2(param2);
    }

    public List<Producto> buscarPorPrecioVentaMayorAlPromedio(double precio) {
    return productoRepository.buscarPorPrecioVentaMayorAlPromedio(precio);
}
    public List<Producto> buscarPorExistenciaMenorAlPromedio(int existencia) {
    return productoRepository.buscarPorExistenciaMenorAlPromedio(existencia);
}


    }

