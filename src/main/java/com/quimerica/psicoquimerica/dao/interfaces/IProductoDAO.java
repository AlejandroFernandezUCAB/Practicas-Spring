package com.quimerica.psicoquimerica.dao.interfaces;

import com.quimerica.psicoquimerica.dto.Producto;

import java.util.ArrayList;

public interface IProductoDAO {

    Producto findById(Integer id);

    boolean insertProducto(Producto producto);

    boolean deleteProducto(Producto producto);

    boolean updateProducto(Producto producto);

    ArrayList<Producto> finbProducts();

}
