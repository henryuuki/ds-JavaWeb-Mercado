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
import model.bean.TableCategoria;
import model.bean.TableEndereco;
import model.bean.TableProduto;
import model.bean.TableUsuario;
import model.dao.CategoriaDAO;
import model.dao.EnderecoDAO;
import model.dao.ProdutoDAO;
import model.dao.UsuarioDAO;

/**
 *
 * @author Usuário
 */
public class EnderecoController extends HttpServlet {

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
        String nextPage = "/WEB-INF/jsp/endereco.jsp";

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
        String nextPag = "/WEB-INF/jsp/endereco.jsp";
        
        if (TableUsuario.getId_usuarioStatic() != 0) {
            UsuarioDAO dao = new UsuarioDAO();
            List<TableUsuario> usuarios = dao.getUsuarioById(TableUsuario.getId_usuarioStatic());
            request.setAttribute("usuario", usuarios);
        }
        
        CategoriaDAO daoC = new CategoriaDAO();
        List<TableCategoria> listaCategorias = daoC.listarTodosC();
        request.setAttribute("categorias", listaCategorias);
        
        EnderecoDAO dao = new EnderecoDAO();

        String errorMessage = "";

        String rua = request.getParameter("rua");
        String numero = request.getParameter("numero");
        String cep = request.getParameter("cep");
        String complemento = request.getParameter("complemento");
        int usuarioId = TableUsuario.getId_usuarioStatic();

        if (rua == null || rua.trim().isEmpty()
                || numero == null || numero.trim().isEmpty()
                || cep == null || cep.trim().isEmpty()) {
            errorMessage = "Todos os campos são obrigatórios.";

        } else if (cep.length() != 9) {
            errorMessage = "Digite o CEP corretamente";
            
        } else {
            
            TableEndereco en = new TableEndereco();
            en.setRua(rua);
            en.setNumero(numero);
            en.setCep(cep);
            en.setComplemento(complemento);
            en.setUsuario_FK(usuarioId);
            System.out.println("Aqqqqqq");
            dao.create(en);

            request.setAttribute("successMessage", "Cadastro realizado com sucesso!");
            nextPag = "/checkout";
        }

        if (!errorMessage.isEmpty()) {
            request.setAttribute("errorMessage", errorMessage);
        }

        RequestDispatcher d = getServletContext().getRequestDispatcher(nextPag);
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
