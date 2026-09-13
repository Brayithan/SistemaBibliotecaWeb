package com.biblioteca.sistemabibliotecaweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion
{

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

   public static Connection conectar() throws SQLException {

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new SQLException("No se encontró el controlador de MySQL", e);
    }

    return DriverManager.getConnection(URL, USER, PASSWORD);
}
}