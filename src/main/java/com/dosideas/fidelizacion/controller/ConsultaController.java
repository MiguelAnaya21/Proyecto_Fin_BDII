/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dosideas.fidelizacion.controller;

import com.dosideas.fidelizacion.domain.Producto;
import com.dosideas.fidelizacion.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author migue
 */
@Controller
public class ConsultaController {

    private final ProductoService productoService;

    public ConsultaController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/consultas")
    public String mostrarConsultas() {
        return "consultas.html";
    }

    @GetMapping("/subconsulta3")
public String subconsulta3(@RequestParam("precioVenta") double precioVenta, Model model) {
    List<Producto> productos = productoService.buscarPorPrecioVentaMayorAlPromedio(precioVenta);
    model.addAttribute("productos", productos);
    return "resultados.html";
}

@GetMapping("/subconsulta4")
public String subconsulta4(@RequestParam("existencia") int existencia, Model model) {
    List<Producto> productos = productoService.buscarPorExistenciaMenorAlPromedio(existencia);
    model.addAttribute("productos", productos);
    return "resultados.html";
}

    }



