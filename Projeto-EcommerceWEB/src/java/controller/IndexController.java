/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.TableCategoria;
import model.bean.TableUsuario;
import model.dao.CategoriaDAO;
import model.dao.UsuarioDAO;

/**
 *
 * @author Senai
 */
public class IndexController extends HttpServlet {

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
        String nextPage = "/WEB-INF/jsp/index.jsp";
        
        if (TableUsuario.getId_usuarioStatic() != 0) {
            UsuarioDAO dao = new UsuarioDAO();
            List<TableUsuario> usuarios = dao.getUsuarioById(TableUsuario.getId_usuarioStatic());
            request.setAttribute("usuario", usuarios);
        }
        
        CategoriaDAO daoC = new CategoriaDAO();
        List<TableCategoria> listaCategorias = daoC.listarTodosC();
        request.setAttribute("categorias", listaCategorias);
        
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
        
        String url = request.getServletPath();
        
        if(url.equals("/sair")){
          TableUsuario.setId_usuarioStatic(0);
            response.sendRedirect(request.getContextPath() + "/home");

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
        
        String url = request.getServletPath();
        
        if(url.equals("/sair")){
          TableUsuario.setId_usuarioStatic(0);
            response.sendRedirect(request.getContextPath() + "/home");

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
