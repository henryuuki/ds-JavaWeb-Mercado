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
import model.bean.TableEndereco;
import model.bean.TablePedido;
import model.bean.TableUsuario;
import model.dao.CarrinhoDAO;
import model.dao.CategoriaDAO;
import model.dao.EnderecoDAO;
import model.dao.UsuarioDAO;

/**
 *
 * @author Usuário
 */
public class CheckoutController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    float total = 0;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nextPage = "/WEB-INF/jsp/checkout.jsp";
        
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

        UsuarioDAO ud = new UsuarioDAO();
        TableUsuario u = ud.checkout();
        request.setAttribute("usuarios", u);

        EnderecoDAO ed = new EnderecoDAO();
        TableEndereco e = ed.mostrarCheckout();
        request.setAttribute("endereco", e);

        TablePedido p = new TablePedido();

        for (TableCarrinho c : carrinho) {
            total += c.getSubProduto();
        }
        request.setAttribute("total", total);

        List<TableEndereco> end = ed.visualizarEnderecos();
        request.setAttribute("enderecos", end);

        if (end.isEmpty()) {
            request.setAttribute("errorMessage", "Você precisa adicionar um endereço antes de fazer um pedido.");
        }

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
        processRequest(request, response);
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
