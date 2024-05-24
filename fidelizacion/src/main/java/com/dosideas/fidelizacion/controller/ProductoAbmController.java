/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dosideas.fidelizacion.controller;

import com.dosideas.fidelizacion.domain.Producto;
import com.dosideas.fidelizacion.service.CategoriaService;
import com.dosideas.fidelizacion.service.ProductoService;
import com.dosideas.fidelizacion.service.ProveedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author migue
 */
@Controller
public class ProductoAbmController {

    //Servicios utilizados para el control de ProductoAbmController
    private final ProveedorService proveedorService;
    private final CategoriaService categoriaService;
    private final ProductoService productoService;

    //Constructor de ProductoAbmController
    public ProductoAbmController(ProveedorService proveedorService, CategoriaService categoriaService, ProductoService productoService) {
        this.proveedorService = proveedorService;
        this.categoriaService = categoriaService;
        this.productoService = productoService;
    }

    //Crea los productos para darlos de alta en la BD
    @RequestMapping("/productos/crear")
    public String mostrarFormAlta(Model model) {
        //Muestra los proveedores en la alta de productos
        model.addAttribute("proveedores", proveedorService.buscarTodos());
        //Muestra las categorias en la alta de productos
        model.addAttribute("categorias", categoriaService.buscarTodos());
        model.addAttribute("producto", new Producto());
        return "formproducto.html";
    }

    //Guarda los productos en la Base de Datos
    @PostMapping("/productos/guardar")
    public String guardar(Producto producto) {
        productoService.guardar(producto);
        return "redirect:/listado";
    }
    
    
}
