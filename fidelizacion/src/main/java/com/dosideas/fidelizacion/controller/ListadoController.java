 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dosideas.fidelizacion.controller;

import com.dosideas.fidelizacion.domain.Categoria;
import com.dosideas.fidelizacion.domain.Producto;
import com.dosideas.fidelizacion.domain.Proveedor;
import com.dosideas.fidelizacion.domain.User;
import com.dosideas.fidelizacion.service.CategoriaService;
import com.dosideas.fidelizacion.service.ProductoService;
import com.dosideas.fidelizacion.service.ProveedorService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
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
public class ListadoController {

    //Servicios usados por el controlador
    private final ProductoService productoService;
    private final ProveedorService proveedorService;
    private final CategoriaService categoriaService;


    //Constructor de Listado controller
    public ListadoController(ProductoService productoService, ProveedorService proveedorService, CategoriaService categoriaService) {
        this.productoService = productoService;
        this.proveedorService = proveedorService;
        this.categoriaService = categoriaService;
        
    }

    //Lista los productos de 8 en 8 para la paginacion del menu
    @RequestMapping("/listado")
    public String listarProductos(Model model, @RequestParam(defaultValue = "0") int pagina) {
        int tamañoProductos = 8; // Número de productos por página
        List<Producto> destacados = productoService.buscarDestacados();

        // Calcular el número total de páginas
        int totalPaginas = (int) Math.ceil((double) destacados.size() / tamañoProductos);

        // Asegurarse de que la página solicitada no sea mayor que el total de páginas
        if (pagina >= totalPaginas) {
            pagina = totalPaginas - 1;
        }

        // Calcular el índice del primer y último producto en la página actual
        int inicioIndice = pagina * tamañoProductos;
        int finalIndice = Math.min(inicioIndice + tamañoProductos, destacados.size());

        // Obtener los productos para la página actual
        List<Producto> productosPaginados = destacados.subList(inicioIndice, finalIndice);
        // Obtener las categorias para la pagina actual
        List<Categoria> cat = categoriaService.buscarTodos();
        // Obtener los proveedores para la pagina actual
        List<Proveedor> prov = proveedorService.buscarTodos();

        //Manda los resultados a la pagina de listado.html
        model.addAttribute("productos", productosPaginados);
        model.addAttribute("categorias", cat);
        model.addAttribute("proveedores", prov);
        model.addAttribute("totalPaginas", totalPaginas);
        model.addAttribute("currentPage", pagina);

        return "listado.html";
    }

    //Lista los productos por medio del proveedor
    @RequestMapping("/productosPorProveedor")
    public String listarProductoPorProveedor(@RequestParam("PROV_ID") int proveedorId, Model model) {
        //Hace la lista de los productos por medio del Id del proveedor
        List<Producto> productos = productoService.buscarPorProveedor(proveedorId);
        //Manda los productos de la lista a listado.html para que se muestren
        model.addAttribute("productos", productos);
        return "listado.html";
    }
    
    
    //Lista los productos por medio de categorias
    @RequestMapping("/productosPorCategoria")
    public String listarProductoPorCategoria(int CAT_ID, Model model) {
        //Recibe el Id de la categoria y busca los productos relacionados con ella
        List<Producto> productos = productoService.buscarPorCategoria(CAT_ID);
        //Manda los productos de la lista a listado.html para que se muestren
        model.addAttribute("productos", productos);
        return "listado.html";
    }

    //Busca el producto por medio de una consulta
    @RequestMapping("/buscar")
    public String buscar(@RequestParam("q") String consulta, Model model) {
        //Hace una lista de los productos relacionados con la consulta
        List<Producto> productos = productoService.buscar(consulta);
        //Hace una lista de las categorias relacionados con esa consulta 
        List<Categoria> cat = categoriaService.buscarTodos();
        //Hace una lista de los proveedores relacionados con esa consulta
        List<Proveedor> prov = proveedorService.buscarTodos();

        //Manda todos los datos a listado.html para que los muestre
        model.addAttribute("productos", productos);
        model.addAttribute("categorias", cat);
        model.addAttribute("proveedores", prov);
        model.addAttribute("consulta", consulta);
        return "listado.html";
    }

    //Bussca el producto por medio de su ID 
    @RequestMapping("/buscarProductoPorId")
    public String buscarProductoPorId(@RequestParam("productoId") String idProducto, Model model) {
        String mensajeError = "";

        try {
            // Intenta convertir el ID del producto a un entero
            int id = Integer.parseInt(idProducto);

            // Busca el producto por su ID
            Optional<Producto> opcionalProducto = productoService.buscarPorId(id);

            if (opcionalProducto.isPresent()) {
                // Si el producto se encuentra, lo agrega al modelo y muestra la vista del producto
                Producto producto = opcionalProducto.get();
                model.addAttribute("producto", producto);
                return "producto.html";
            } else {
                // Si el producto no se encuentra, muestra una página de error con el mensaje correspondiente
                mensajeError = "Producto no encontrado";
                model.addAttribute("mensajeError", mensajeError);
                return "error";
            }
        } catch (NumberFormatException e) {
            // Si ocurre una excepción al convertir el ID a entero, muestra una página de error con el mensaje correspondiente
            mensajeError = "Id. del producto inválido";
            model.addAttribute("mensajeError", mensajeError);
            return "error";
        }
    }

    //Elimina un producto por medio de su ID
    @RequestMapping("/productos/eliminar")
    public String eliminarProductoPorId(@RequestParam("id") String idProducto) {
        //Recibe el ID del producto y lo envia al service
        int idp = Integer.parseInt(idProducto);
        //Hace una consulta  a la base de datos para que elimine ese producto por medio del ID
        productoService.eliminarPorId(idp);
        //Te dirige a la pagina principal
        return "redirect:/listado";
    }

    //Edita los productos por medio de su ID
    @RequestMapping("/productos/editar")
    public String mostrarEditarVideojuego(@RequestParam("id") String idProducto, Model model) {
        String mensajeError = "";

        try {
            // Intenta convertir el ID del producto a un entero
            int id = Integer.parseInt(idProducto);

            // Busca el producto por su ID
            Optional<Producto> opcionalProducto = productoService.buscarPorId(id);

            if (opcionalProducto.isPresent()) {
                // Si el producto se encuentra, lo agrega al modelo y muestra la vista del producto
                Producto producto = opcionalProducto.get();
                model.addAttribute("producto", producto);
                model.addAttribute("proveedores", proveedorService.buscarTodos());
                model.addAttribute("categorias", categoriaService.buscarTodos());
                return "formEditarProducto.html";
            } else {
                // Si el rpoducto no se encuentra, muestra una página de error con el mensaje correspondiente
                mensajeError = "Producto no encontrado";
                model.addAttribute("mensajeError", mensajeError);
                return "error";
            }
        } catch (NumberFormatException e) {
            // Si ocurre una excepción al convertir el ID a entero, muestra una página de error con el mensaje correspondiente
            mensajeError = "Id. del producto inválido";
            model.addAttribute("mensajeError", mensajeError);
            return "error";
        }
    }

    //Guarda los cambios que se realizaron al Editar el producto
    @PostMapping("/productos/guardarCambios")
    public String guardarCambios(Producto producto) {
        productoService.guardarCambios(producto);
        return "redirect:/listado";
    }


    /*------------------ Proveedor --------------------*/
    //Muestra la listad de Proveedores
    @RequestMapping("/listaProv")
    public String listarProveedoresLista(Model model) {
        //Hace una lista con los proveedores que le aporta el Service
        List<Proveedor> prov = proveedorService.buscarTodos();
        //Manda los proveedores a la tabla de proveedores
        model.addAttribute("proveedores", prov);
        return "tablaproveedores.html";
    }

    //Edita los proveedores por medio de su ID
    @RequestMapping("/proveedores/editar")
    public String mostrarEditarProveedor(@RequestParam("id") String idProducto, Model model) {
        String mensajeError = "";

        try {
            // Intenta convertir el ID del proveedor a un entero
            int id = Integer.parseInt(idProducto);

            // Busca el proveedor por su ID
            Optional<Proveedor> opcionalProveedor = proveedorService.buscarPorId(id);

            if (opcionalProveedor.isPresent()) {
                // Si el proveedor se encuentra, lo agrega al modelo y muestra la vista del proveedor
                Proveedor proveedor = opcionalProveedor.get();
                model.addAttribute("proveedor", proveedor);

                return "formEditarProveedor.html";
            } else {
                // Si el proveedor no se encuentra, muestra una página de error con el mensaje correspondiente
                mensajeError = "Proveedor no encontrado";
                model.addAttribute("mensajeError", mensajeError);
                return "error";
            }
        } catch (NumberFormatException e) {
            // Si ocurre una excepción al convertir el ID a entero, muestra una página de error con el mensaje correspondiente
            mensajeError = "Id. del producto inválido";
            model.addAttribute("mensajeError", mensajeError);
            return "error";
        }
    }

    @RequestMapping("/buscarPROV")
    public String buscarProveedor(@RequestParam("searchProv") String consulta, Model model) {
        //Hace una lista de los proveedores relacionados con esa consulta
        List<Proveedor> prov = proveedorService.buscar(consulta);

        model.addAttribute("proveedores", prov);
        model.addAttribute("consulta", consulta);
        return "tablaproveedores.html";
    }
    
     @RequestMapping("/buscarValoracionPROV")
    public String buscarProveedor(@RequestParam("searchValoracion") double valoracion, Model model) {
        // Hace una lista de los pproveedores relacionados con esa consulta
        List<Proveedor> proveedores = proveedorService.buscarPorValoracionMayorA(valoracion);

        model.addAttribute("proveedores", proveedores);
        model.addAttribute("consulta", valoracion);
        return "tablaproveedores";
    }
    
    //------------------consulta-------------//
    //Método para mostrar la página de consultas
    @RequestMapping("/listadoConsultas")
public String mostrarConsultas() {
    return "consultas.html";
}


    //Método para realizar la primera subconsulta
    @RequestMapping("/subconsulta1")
    public String realizarSubconsulta1(@RequestParam("param1") String param1, Model model) {
        List<Producto> resultados = productoService.subconsulta1(param1);
        model.addAttribute("resultados", resultados);
        return "resultadosSubconsulta1.html";
    }

    //Método para realizar la segunda subconsulta
    @RequestMapping("/subconsulta2")
    public String realizarSubconsulta2(@RequestParam("param2") String param2, Model model) {
        List<Producto> resultados = productoService.subconsulta2(param2);
        model.addAttribute("resultados", resultados);
        return "resultadosSubconsulta2.html";
    }

    
}
   
