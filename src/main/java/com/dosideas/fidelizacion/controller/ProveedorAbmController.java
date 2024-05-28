/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dosideas.fidelizacion.controller;

import com.dosideas.fidelizacion.domain.Proveedor;
import com.dosideas.fidelizacion.service.ProveedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author migue
 */
@Controller
public class ProveedorAbmController {

    //Obtiene los Servicios utilizados por el ProveedorAbmController
    private final ProveedorService proveedorService;

    //Hace el constructor del ProveedorAbmController
    public ProveedorAbmController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    //Elimina el proveedor por medio de su ID
    @RequestMapping("/proveedor/eliminar")
    public String eliminarProveedorPorId(@RequestParam("id") String idProveedor) {
        //Obtiene el ID del proveedor y lo guarda en una variable entera
        int idp = Integer.parseInt(idProveedor);
        //Manda esa variable a el metodo de eliminar en el service
        proveedorService.eliminarPorId(idp);
        //Te redirecciona a la pagina principal
        return "redirect:/listado";
    }

    //Guarda los cambios hechos al editar el proveedor
    @PostMapping("/proveedor/guardarCambios")
    public String guardarCambiosProveedor(Proveedor proveedor) {
        proveedorService.guardarCambios(proveedor);
        return "redirect:/listado";
    }

    //Crea los proveedores en la Alta de proveedores
    @RequestMapping("/proveedores/crear")
    public String mostrarFormAltaProveedores(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "formproveedor.html";
    }

    //Guarda el proveedor dado de alta
    @PostMapping("/proveedor/guardar")
    public String guardar(Proveedor proveedor) {
        proveedorService.guardar(proveedor);
        return "redirect:/listado";
    }
}
