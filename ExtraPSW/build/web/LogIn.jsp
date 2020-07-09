<%-- 
    Document   : LogIn
    Created on : 8/07/2020, 05:33:45 PM
    Author     : Christian
--%>

<%@page import="java.util.*"%>
<%@page import="Clases.Sucursal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> LogIn </title>
        <link rel="stylesheet" href=""/>
    </head>
    <body>
        <script src="js/ValidacionLogIn.js"/>
        <h1>Estetica AUX</h1>
        <div class="login">
            <h3>Si ya tienes una cuenta Inicia Sesion Aqui</h3>
            <form action="validarLogin" method="post">
                Email:
                <br>
                <input type="text" name="nombre" required>
                <br>
                <br>
                Contraseña:
                <br>
                <input type="password" name="password" required>
                <br>
                <br>
                <input type="submit" value="Ingresar">
            </form>
        </div>
        <div>
            <h3>Si aun no tienes una cuenta registrada con nosotros puedes hacerlo aqui</h3>
            <form method="" action="registrarUsuario">
                Nombre:
                <br>
                <input type="text" name="nombre" required>
                <br>
                <br>
                Correo:
                <br>
                <input type="text" name="email" required>
                <br>
                <br>
                Contraseña:
                <br>
                <input type="password" name="password" required>
                <br>
                <br>
                Telefono:
                <br>
                <input type="text" name="telefono" required>
                <br>
                <br>
                Direccion:
                <br>
                <input type="text" name="direccion" required>
                <br>
                <br>
                Sucursal:
                <br>
                <select name="sucursal">
                    <option value="0">
                        Cliente
                    </option>
                    <%
                        Vector<Sucursal> lsuc = Sucursal.getSucursales();
                        for (Sucursal a: lsuc) {
                    %>
                    <option value="<%= a.getId_suc() %>">
                        <%= a.getNom_suc() %>
                    </option>
                    <%
                            }
                    %>
                </select> 
                <br>
                <br>
                <input type="submit" value="Registrarse">
                
            </form>
        </div>
        <a href="javascript: window.history.go(-2);">volver</a>
    </body>
</html>
