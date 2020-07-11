<%-- 
    Document   : indexAdmin
    Created on : 8/07/2020, 05:35:54 PM
    Author     : Christian
--%>

<%@page import="Clases.Sucursal"%>
<%@page import="java.util.*"%>
<%@page import="Clases.Servicio"%>
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
            if (sessionOk.getAttribute("usuario")== null || (Integer) sessionOk.getAttribute("privilegio") != 1){
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
                <a href="CitasAdmin.jsp" class="enlace-menu">Citas</a>
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
            <h1 class="Titulo">Bienvenido a "Esteticas AUX"</h1>
            <div class="seccion" id="conocenos">
                <h2 class="titulo">¿Quienes somos?</h2>
                <div class="izquierda">
                    <p class="texto-main">
                        AUX es una cadena de salones de belleza dedicados a satisfacer las necesidades de nuestros clientes
                        desde un simple corte de cabello hasta una pedicura e inclusive un peinado especial.
                        Nuestros empleados cuentan con un amplio conocimiento emn distintas tecnicas de embellecimiento
                        y una gran disposicion de atenderlo como usted lo merece
                    </p>
                </div>
                <div class="derecha">
                    <p><img class="imagen" src="img/salon.jpg"></p>
                </div>
            </div>
            <div class="seccionDoble" id="servicios">   
                <div class="contenedorServicios">
                    <h2 class="titulo">¿Que Ofrecemos?</h2>                    
                    <br>
                    <p class="texto-main">
                        Contamos con un amplio catalogo de servicios para usted, tales como:
                    </p>
                    <br>
                    <table class="serviciostabla" min-width="420px" width="80%" border="1px" height="900px">
                        <tr>
                            <td>
                                Servicio
                            </td>
                            <td>
                                Precio
                            </td>
                            <td>
                                Duracion
                            </td>
                        </tr>
                        <%
                            Vector<Servicio> ls = Servicio.getServicios();
                            for(Servicio a : ls){
                                %>
                                <tr>
                                    <td>
                                        <%= a.getNom_serv() %>
                                    </td>
                                    <td>
                                        $<%= a.getPre_serv() %>
                                    </td>
                                    <td>
                                        <%= a.getDur_serv() %> min
                                    </td>
                                </tr>
                                <%
                            }
                        %>
                    </table>
                </div>   
            </div>
            <div class="seccion" id="citas">
                <h2 class="titulo">¡Agenda tu cita!</h2>
                <div class="izquierda">
                    <p class="texto-main">
                        Si quieres agendar una cita puedes hcaerlo aqui mismo, unicamente debes tener una cuenta registrada para poder hacrlo,
                        recuerda que puedes visitarnos sin cita previa pero no es recomendable ya que estas sujeto
                        a disponibilidad de  la agenda de nuestros trabajadores
                    </p>
                    <br>
                    <br>
                    <a href="AgendarCita.jsp"><input type="button" value="Agenda tu cita"></a>
                    
                    
                </div>
                <div class="derecha">
                    <p><img class="imagen" src="img/agenda.png"></p>
                </div>
            </div>
            <div class="seccion" id="contacto">
                <h2 class="titulo">Contactanos</h2>
                <div class="izquierda">
                    Conoce nuestras diversas sucursales ubicadas en distintos  puntos de la ciudad y elige la que mas te convenga:
                    <br>
                    <ul>
                        <%
                            Vector<Sucursal> lsuc = Sucursal.getSucursales();
                            for(Sucursal suc: lsuc){
                        %>
                        <li class="texto-main">
                            <%= suc.getNom_suc() %> ubicada en:
                            <br>
                            <%= suc.getDir_suc() %>
                        </li>
                        <%
                            }
                        %>
                    </ul>
                    
                </div>
                <div class="derecha">
                    <h3>Informacion de Contacto</h3>
                    <br>
                    <p>
                        Telefono: 5684564989
                        <br>
                        Emial: ContactoAUX@gmail.com
                    </p>
                    <p><img class="imagen" src="img/tel.png"></p>
                </div>
            </div>
        </div>
    </body>
</html>
