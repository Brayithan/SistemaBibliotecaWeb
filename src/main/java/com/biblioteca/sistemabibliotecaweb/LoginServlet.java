package com.biblioteca.sistemabibliotecaweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("index.jsp");
    }

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String usuario = request.getParameter("usuario");
    String password = request.getParameter("password");

    String sql = "SELECT id_usuario, nombre FROM usuario WHERE nombre = ? AND contrasena = ?";

    try (Connection con = conexion.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, usuario);
        ps.setString(2, password);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                request.setAttribute("mensaje", "Inicio de sesión exitoso");
                request.setAttribute("usuario", rs.getString("nombre"));
            } else {
                request.setAttribute("mensaje", "Usuario o contraseña incorrectos");
                request.setAttribute("usuario", "");
            }

            request.getRequestDispatcher("resultado.jsp").forward(request, response);
        }

    } catch (SQLException e) {
        request.setAttribute("mensaje", "Error al conectar con la base de datos");
        request.setAttribute("usuario", "");
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
    }
}

    @Override
    public String getServletInfo() {
        return "Servlet para el inicio de sesión de la biblioteca";
    }
}