package com.quimerica.psicoquimerica.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    Connection connection;

    public Database(Connection connection) {
        this.connection = connection;
    }

    public Database() {

    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * Metodo para obtener una conexión a la base de datos
     */

    public Connection obtenerConexion(){
        try {

            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/psicoquimerica", "postgres", "informatica.8668");
            System.out.println("Se conectó correctamente a la bdd");
            return this.connection;
        }catch( SQLException e){

            System.out.println("Error a la conexión a la base de datos : " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Metodo para cerrar la conexión a la base de datos
     * @param connection Conexion abierta de base de datos
     */
    public void cerrarConexion(Connection connection){
        try {

            connection.close();
            System.out.println("Conexión cerrada a la base de datos");

        }catch ( SQLException e) {

            System.out.println("Hubo un problema con la conexión : " + e.getMessage());
            e.printStackTrace();

        }
    }

}


