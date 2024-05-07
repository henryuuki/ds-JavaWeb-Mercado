/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.TableUsuario;
import model.dao.UsuarioDAO;

/**
 *
 * @author Senai
 */
public class LoginController extends HttpServlet {

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
            throws ServletException, IOException {
        String nextPage = "/WEB-INF/jsp/login.jsp";
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);  
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
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();
        String nextPage = "/WEB-INF/jsp/index.jsp";
        
        if(url.equals("/logar")){
            TableUsuario u = new TableUsuario();
            UsuarioDAO dao =  new UsuarioDAO();
            
            u.setEmail(request.getParameter("email"));
            u.setSenha(request.getParameter("password"));
            try{
                dao.validlogin(u);
                
                if(TableUsuario.getAcessoStatic() != 0){
                    if(TableUsuario.getAcessoStatic() == 1){
                        int idUsuario = dao.getId(request.getParameter("email"));
                        response.sendRedirect(request.getContextPath() + "/admin-panel");
                        return;
                    }
                    else if(TableUsuario.getAcessoStatic() == 2){
                        int idUsuario = dao.getId(request.getParameter("email"));
                        response.sendRedirect(request.getContextPath() + "/index.htm");
                        return;
                    }
                    else{
                        
                    }
                }
                else {
                    request.setAttribute("errorMessage", "Usuário ou senha inválidos");
                }
                
            }catch (Exception e){
                request.setAttribute("errorMessage", "Usuário ou senha inválidos");

            }
            
        }
        TableUsuario user = new TableUsuario();
        user.setId_usuario(TableUsuario.getId_usuarioStatic());
        request.setAttribute("usuario", user);
        
        RequestDispatcher d = getServletContext().getRequestDispatcher(nextPage);
        d.forward(request, response);
    
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
