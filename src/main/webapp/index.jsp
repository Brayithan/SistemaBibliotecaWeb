<%-- 
    Document   : index
    Created on : 13/09/2026, 11:04:55 a. m.
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Inicio de Sesion - Biblioteca</title>
    </head>
    <body>
        <h1>Inicio de Sesion</h1>
        <form action="LoginServlet" method="POST">
            <label for="usuario">Usuario:</label>
             <input type="text" id="usuario" name="usuario" required>
             <br><br>
               <label for="password">Contraseña:</label>
        <input type="password" id="password" name="password" required>

        <br><br>

        <button type="submit">Iniciar sesión</button>

    </form>
</body>
</html>
