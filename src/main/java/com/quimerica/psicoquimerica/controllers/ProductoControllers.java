package com.quimerica.psicoquimerica.controllers;

import java.util.ArrayList;

import com.quimerica.psicoquimerica.dao.interfaces.IProductoDAO;
import com.quimerica.psicoquimerica.dto.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
public class ProductoControllers {

    @Autowired
    private IProductoDAO productoDAO;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Producto getProducto(@PathVariable Integer id){
        return productoDAO.findById(id);
    }


    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public ArrayList<Producto> getProductos(){
        return productoDAO.finbProducts();
    }

    @RequestMapping(value = "/insertar", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public boolean insertProducto(@RequestBody Producto producto){

        return productoDAO.insertProducto( producto );
    }

    @RequestMapping(value = "/borrar", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public boolean deleteProducto(@RequestBody Producto producto){
        return productoDAO.deleteProducto( producto );
    }

    @RequestMapping(value = "/actualizar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public boolean updateProducto(@RequestBody Producto producto){
        return productoDAO.updateProducto( producto );
    }
}
