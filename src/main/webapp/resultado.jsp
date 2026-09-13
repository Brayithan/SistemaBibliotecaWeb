<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Resultado del Login</title>
    </head>
    <body>

        <h1><%= request.getAttribute("mensaje") %></h1>

        <%
            String usuario = (String) request.getAttribute("usuario");

            if (usuario != null && !usuario.isEmpty()) {
        %>

            <p>Bienvenido, <%= usuario %></p>

        <%
            }
        %>

        <br>

        <a href="index.jsp">Volver al inicio de sesión</a>

    </body>
</html>