/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Christian
 */
public class validarLogIn extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            Usuario u = Usuario.verificarUsuario(email, password);
            
            if (u != null) {
                HttpSession session = request.getSession(true);

                session.setAttribute("usuario", u);

                HttpSession sessionOk = request.getSession();
                sessionOk.setAttribute("id", u.getId_usu());
                sessionOk.setAttribute("usuario", u.getNom_usu());
                sessionOk.setAttribute("email", u.getEmail_usu());
                sessionOk.setAttribute("password", u.getPass_usu());
                sessionOk.setAttribute("privilegio", u.getPriv_usu());
                sessionOk.setAttribute("direccion", u.getDir_usu());
                sessionOk.setAttribute("telefono", u.getTel_usu());
                sessionOk.setAttribute("status", u.getStatus_usu());
                if (u.getStatus_usu().equalsIgnoreCase("activo")) {
                    if (u.getPriv_usu() == 3) {
                        response.sendRedirect("indexCliente.jsp");
                    }else if(u.getPriv_usu() == 2 || u.getPriv_usu() == 1){
                        response.sendRedirect("indexAdmin.jsp");
                    }
                }else{
                    response.sendRedirect("error.jsp");
                    
                }
            }else{
                response.sendRedirect("error.jsp");
            }
                
                
        }catch(Exception e){
                e.getMessage();
                e.getStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(validarLogIn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(validarLogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(validarLogIn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(validarLogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
