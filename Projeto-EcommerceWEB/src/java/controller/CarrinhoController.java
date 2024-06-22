/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.TableCarrinho;
import model.bean.TableCategoria;
import model.bean.TableProduto;
import model.bean.TableUsuario;
import model.dao.CarrinhoDAO;
import model.dao.CategoriaDAO;
import model.dao.ProdutoDAO;
import model.dao.UsuarioDAO;

/**
 *
 * @author Usuário
 */
public class CarrinhoController extends HttpServlet {

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
        String nextPag = "/WEB-INF/jsp/carrinho.jsp";

        if (TableUsuario.getId_usuarioStatic() != 0) {
            UsuarioDAO dao = new UsuarioDAO();
            List<TableUsuario> usuarios = dao.getUsuarioById(TableUsuario.getId_usuarioStatic());
            request.setAttribute("usuario", usuarios);
        }

        CarrinhoDAO cd = new CarrinhoDAO();
        List<TableCarrinho> carrinho = cd.visualizarCarrinho();
        for (int i = 0; i < carrinho.size(); i++) {
            if (carrinho.get(i).getImagemBytes() != null) {
                String imagemBase64 = Base64.getEncoder().encodeToString(carrinho.get(i).getImagemBytes());
                carrinho.get(i).setImagemBase64(imagemBase64);
            }
        }
        request.setAttribute("carrinhos", carrinho);

        CategoriaDAO daoC = new CategoriaDAO();
        List<TableCategoria> listaCategorias = daoC.listarTodosC();
        request.setAttribute("categorias", listaCategorias);

        CarrinhoDAO daoP = new CarrinhoDAO();
        List<TableCarrinho> produtos = daoP.visualizarCarrinho();
       
        RequestDispatcher d = getServletContext().getRequestDispatcher(nextPag);
        d.forward(request, response);
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

        if (url.equals("/aumentarQTD")) {
            int id_carrinho = Integer.parseInt(request.getParameter("id_carrinho"));
            System.out.println("o id do carrinho é: " + id_carrinho);

            int qtd = Integer.parseInt(request.getParameter("quantidade"));
            System.out.println("Sua quantidade é: " + qtd);

            CarrinhoDAO cdd = new CarrinhoDAO();
            cdd.mudarQuantidade(qtd, id_carrinho);
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
