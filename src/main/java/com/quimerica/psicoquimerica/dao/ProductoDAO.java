package com.quimerica.psicoquimerica.dao;

import com.quimerica.psicoquimerica.dao.interfaces.IProductoDAO;
import com.quimerica.psicoquimerica.dto.Producto;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class ProductoDAO implements IProductoDAO {

    @Override
    public Producto findById(Integer id) {
        return new Producto(id, "MacBookPro", 19d);
    }

    @Override
    public boolean insertProducto(Producto producto) {

        Database baseDeDatos = new Database();
        Connection bdd;
        baseDeDatos.getConnection();
        bdd = baseDeDatos.obtenerConexion();
        String sql = "INSERT INTO PRODUCTO (pr_nombre,pr_precio) values ( ? , ? )";

        try{
            
            PreparedStatement st = bdd.prepareStatement(sql);
            st.setString(1, producto.getNombre());
            st.setDouble(2, producto.getPrecio());
            st.executeUpdate();
            st.close();
            return true;

        }catch( SQLException e){
            
            System.out.println("Hubo un error en:" + e.getMessage());
            e.getStackTrace();
            return false;

        }finally{

            baseDeDatos.cerrarConexion( bdd );

        }

    }

    @Override
    public boolean deleteProducto(Producto producto) {
        Database baseDeDatos = new Database();
        Connection bdd;
        baseDeDatos.getConnection();
        bdd = baseDeDatos.obtenerConexion();
        String sql = "DELETE FROM PRODUCTO WHERE (pr_id = ?)";

        try{
            
            PreparedStatement st = bdd.prepareStatement(sql);
            st.setInt(1, producto.getId());
            st.executeUpdate();
            st.close();
            return true;

        }catch( SQLException e){
            
            System.out.println("Hubo un error en:" + e.getMessage());
            e.getStackTrace();
            return false;

        }finally{

            baseDeDatos.cerrarConexion( bdd );

        }

    }

    @Override
    public boolean updateProducto(Producto producto) {
        Database baseDeDatos = new Database();
        Connection bdd;
        baseDeDatos.getConnection();
        bdd = baseDeDatos.obtenerConexion();
        String sql = "UPDATE PRODUCTO SET pr_nombre = ? , pr_precio = ? WHERE (pr_id = ?) ; ";

        try{
            
            PreparedStatement st = bdd.prepareStatement(sql);
            st.setInt(3, producto.getId());
            st.setString(1, producto.getNombre());
            st.setDouble(2, producto.getPrecio());
            st.executeUpdate();
            st.close();
            return true;

        }catch( SQLException e){
            
            System.out.println("Hubo un error en:" + e.getMessage());
            e.getStackTrace();
            return false;

        }finally{

            baseDeDatos.cerrarConexion( bdd );

        }
    }

    @Override
    public ArrayList<Producto> finbProducts() {
        Database baseDeDatos = new Database();
        Connection bdd;
        baseDeDatos.getConnection();
        bdd = baseDeDatos.obtenerConexion();
        String sql = "SELECT pr_id, pr_nombre, pr_precio FROM PRODUCTO ";
        ArrayList<Producto> productos = new ArrayList<>();
        try{
            
            PreparedStatement st = bdd.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while( rs.next()){

                Producto producto = new Producto( rs.getInt( 1 ), rs.getString( 2 ) , rs.getDouble(3) );
                productos.add( producto );

            }

            st.close();
            return productos;

        }catch( SQLException e){
            
            System.out.println("Hubo un error en:" + e.getMessage());
            e.getStackTrace();
            return productos;

        }finally{

            baseDeDatos.cerrarConexion( bdd );

        }
    }

}
