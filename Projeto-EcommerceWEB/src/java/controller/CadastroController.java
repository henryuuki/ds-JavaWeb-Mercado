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
public class CadastroController extends HttpServlet {

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
        String nextPage = "/WEB-INF/jsp/cadastro.jsp";

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
        String nextPag = "/WEB-INF/jsp/cadastro.jsp";

        UsuarioDAO dao = new UsuarioDAO();

        String errorMessage = "";

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("password");
        String confirmarSenha = request.getParameter("confirm-password");
        String telefone = request.getParameter("telefone");
        String cpf = request.getParameter("cpf");

        if (nome == null || nome.trim().isEmpty()
                || email == null || email.trim().isEmpty()
                || senha == null || senha.trim().isEmpty()
                || confirmarSenha == null || confirmarSenha.trim().isEmpty()
                || telefone == null || telefone.trim().isEmpty()
                || cpf == null || cpf.trim().isEmpty()) {
            errorMessage = "Todos os campos são obrigatórios.";

        } else if (!senha.equals(confirmarSenha)) {
            errorMessage = "As senhas devem ser iguais";

        } else if (cpf.length() != 14) {
            errorMessage = "Digite o CPF corretamente";

        } else if (telefone.length() != 14) {
            errorMessage = "Digite o telefone corretamente";

        } else {

            TableUsuario usuario = new TableUsuario();
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setSenha(senha);
            usuario.setTelefone(telefone);
            usuario.setCpf(cpf);

            dao.create(usuario);

            request.setAttribute("successMessage", "Cadastro realizado com sucesso!");
            nextPag = "/home";
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
