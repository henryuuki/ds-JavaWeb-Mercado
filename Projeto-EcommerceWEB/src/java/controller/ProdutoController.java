/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.TableCategoria;
import model.bean.TableProduto;
import model.bean.TableUsuario;
import model.dao.CategoriaDAO;
import model.dao.ProdutoDAO;
import model.dao.UsuarioDAO;

/**
 *
 * @author Senai
 */
public class ProdutoController extends HttpServlet {

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
        String nextPag = "/WEB-INF/jsp/produtos.jsp";
        String url = request.getServletPath();

        if (TableUsuario.getId_usuarioStatic() != 0) {
            UsuarioDAO dao = new UsuarioDAO();
            List<TableUsuario> usuarios = dao.getUsuarioById(TableUsuario.getId_usuarioStatic());
            request.setAttribute("usuario", usuarios);
        }

        int idCat = Integer.parseInt(request.getParameter("cat"));

        CategoriaDAO daoC = new CategoriaDAO();
        List<TableCategoria> listaCategorias = daoC.listarTodosC();
        request.setAttribute("categorias", listaCategorias);

        ProdutoDAO daoP = new ProdutoDAO();
        List<TableProduto> produtos = daoP.listarPorCategoria(idCat);

        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getImagemBytes() != null) {
                String imagemBase64 = Base64.getEncoder().encodeToString(produtos.get(i).getImagemBytes());
                produtos.get(i).setImagemBase64(imagemBase64);
            }
        }
        request.setAttribute("produtos", produtos);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPag);
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

        String url = request.getServletPath();

        if (url.equals("/buscar-produtos")) {

            CategoriaDAO daoC = new CategoriaDAO();
            List<TableCategoria> listaCategorias = daoC.listarTodosC();
            request.setAttribute("categorias", listaCategorias);

            ProdutoDAO daoP = new ProdutoDAO();
            
            List<TableProduto> produtosInput = new ArrayList<>();
            
            String busca = request.getParameter("busca") != null ? request.getParameter("busca") : "";
            if (busca.equals("")) {
                String categoria = request.getParameter("cat");
                produtosInput = daoP.buscaCategoria(Integer.parseInt(categoria));
            } else {
                busca = "%" + busca + "%";
                produtosInput = daoP.buscaProdutos(busca);
            }
            String nextPage = "/WEB-INF/jsp/produtos.jsp";

            for (int i = 0; i < produtosInput.size(); i++) {
                if (produtosInput.get(i).getImagemBytes() != null) {
                    String imagemBase64 = Base64.getEncoder().encodeToString(produtosInput.get(i).getImagemBytes());
                    produtosInput.get(i).setImagemBase64(imagemBase64);
                }
            }
            request.setAttribute("produtos", produtosInput);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else {
            processRequest(request, response);
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
        if (url.equals("/toUniqueProduct")) {
            TableProduto.setIdStaticProduto(Integer.parseInt(request.getParameter("idProduto")));
            response.sendRedirect(request.getContextPath() + "/produto-unico");
        } else {
            processRequest(request, response);
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
