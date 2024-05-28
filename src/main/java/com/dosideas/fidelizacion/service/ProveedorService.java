/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dosideas.fidelizacion.service;

import com.dosideas.fidelizacion.domain.Proveedor;
import com.dosideas.fidelizacion.repository.ProveedorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author migue
 */
@Service
public class ProveedorService {
    //Hace un objeto tipo proveedorRepository
    private final ProveedorRepository proveedorRepository;

    //Se crea el constructor
    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }
    //Hace una lista de todos los proveedores
    public List<Proveedor> buscarTodos(){
        return proveedorRepository.findAll();
    }
    //Elimina el proveedor por medio de su ID 
    public void eliminarPorId(int id){
        proveedorRepository.deleteById(id);
    }
    //Guarda los cambios de hechos al editar el proveedor
    public void guardarCambios(Proveedor proveedor){
        proveedorRepository.save(proveedor);
    }
    //Guarda los datos dados de alta del proveedor
    public Proveedor guardar(Proveedor proveedor){
        return proveedorRepository.save(proveedor);
    }
    //Busca el proveedor por medio de su ID
    public Optional<Proveedor> buscarPorId(int id){
        return proveedorRepository.findById(id);        
    }
    //Hace una lista de busqueda por medio de una consulta
    public List<Proveedor> buscar(String consulta){
        return proveedorRepository.buscar(consulta);
    }
    
    //Consultas multitab
    //Busca la valoracion del proveedor mayor a la agregada
    public List<Proveedor> buscarPorValoracionMayorA(double valoracion) {
        return proveedorRepository.buscarPorValoracionMayorA(valoracion);
    }
}
