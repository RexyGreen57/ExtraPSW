<%-- 
    Document   : CitasAdmin
    Created on : 10/07/2020, 05:58:23 PM
    Author     : Christian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <link rel="stylesheet" href="css/estilos.css"/>
    </head>
    <body>
        <% 
            String usuario = "";
            HttpSession sessionOk = request.getSession();
            if (sessionOk.getAttribute("usuario")== null || 
                    ( (Integer) sessionOk.getAttribute("privilegio") != 1 &&
                    (Integer) sessionOk.getAttribute("privilegio") != 2) ){
        %>
        
        <jsp:forward page="LogIn.jsp">
            <jsp:param name="error" value="es obligatorio identificarse"></jsp:param>
        </jsp:forward>
        
        <%
            }else{
                usuario = (String)sessionOk.getAttribute("usuario");
            }
        %>
        <div class="menu">
            
            <div class="logo">    
            </div>
            <div class="contenedor">
                <a href="#inicio" class="enlace-menu">Inicio</a>
            </div>
            <div class="contenedor">
                <a href="#conocenos" class="enlace-menu">Conocenos</a>
            </div>
            <div class="contenedor">
                <a href="#servicios" class="enlace-menu">Servicios</a>
            </div>
            <div class="contenedor">
                <a href="#citas" class="enlace-menu">Agendar Cita</a>
            </div>
            <div class="contenedor">
                <a href="#contacto" class="enlace-menu">Contacto</a>
            </div>
            <div class="contenedor">
                <a href="citasAdmin.jsp" class="enlace-menu">Citas</a>
            </div>
            <div class="contenedor">
                <a href="usuariosAdmin.jsp" class="enlace-menu">Usuarios</a>
            </div>
            <div class="contenedor">
                <a href="Graficas.jsp" class="enlace-menu">Graficas</a>
            </div>
            <div class="contenedor">
                <a href="index.jsp" class="enlace-menu">Salir</a>
            </div>
        </div>
        <div class="body" id="inicio">
            <%
                if((Integer) sessionOk.getAttribute("privilegio") == 1){
            %>
                    <h1>Administrador</h1> 
            <%
                }else if((Integer) sessionOk.getAttribute("privilegio") == 2){
            %>
                    <h1>Gerente</h1>>
            <%
            }else{
            %>
            wojfwojf
            <%
            }
            %>
        </div>
    </body>
</html>
