/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.TableCategoria;
import model.bean.TableProduto;
import model.dao.CategoriaDAO;
import model.dao.ProdutoDAO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Senai
 */
public class AdminController extends HttpServlet {

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
        String nextPage = "/WEB-INF/jsp/admin.jsp";
        
        CategoriaDAO dao = new CategoriaDAO();
        List<TableCategoria> listaCategorias = dao.listarTodosC();
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
        // Verifica se a requisição é do tipo multipart (upload de arquivo)
        String url = request.getServletPath();
        if (url.equals("/cadastrar-produto")) {
            System.out.println("E");
            try {
                // Parseia a requisição para obter os itens do formulário
                List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                // Instancia um novo produto
                TableProduto produto = new TableProduto();
                // Processa cada item do formulário
                for (FileItem item : items) {
                    // Verifica se o item é um campo de formulário
                    if (item.isFormField()) {
                        // Se sim, verifica o nome do campo e define o valor do produto de acordo
                        switch (item.getFieldName()) {
                            case "nome":
                                produto.setNome(item.getString());
                                break;
                            case "valor":
                                produto.setValor(Float.parseFloat(item.getString()));
                                break;
                            case "descricao":
                                produto.setDescricao(item.getString());
                                break;
                            case "categoria":
                                produto.setCategoria_FK(Integer.parseInt(item.getString()));
                                break;
                        }
                    } else {
                        // Se não, o item é um arquivo de imagem
                        // Converte o InputStream do arquivo em um array de bytes
                        InputStream inputStream = item.getInputStream();
                        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                        byte[] buffer = new byte[4096];
                        int bytesRead;
                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);
                        }
                        byte[] imagemBytes = outputStream.toByteArray();
                        // Define a imagem do produto
                        produto.setImagemBytes(imagemBytes);
                        // Fecha os fluxos de entrada e saída
                        inputStream.close();
                        outputStream.close();
                    }
                }
                // Após processar todos os itens do formulário, insere o produto no banco de dados
                ProdutoDAO dao = new ProdutoDAO();
                boolean sucesso = dao.inserirProduto(produto);
                if (sucesso) {
                    // Se a inserção for bem-sucedida, redireciona para a página de produtos
                    redirectToSuccessPage(request, response);
                } else {
                    // Se ocorrer algum erro, redireciona para a página de erro
                    redirectToErrorPage(request, response);
                }
            } catch (FileUploadException e) {
                throw new ServletException("Cannot parse multipart request.", e);
            }
        } else {
            // Se a requisição não for multipart, redireciona para a página inicial
            redirectToIndexPage(request, response);
        }
    }
    private void redirectToSuccessPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Redireciona para a página de produtos
        response.sendRedirect(request.getContextPath() + "/admin-panel");
    }

    private void redirectToErrorPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Redireciona para a página de erro
        response.sendRedirect(request.getContextPath() + "/admin-panel");
    }

    private void redirectToIndexPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Redireciona para a página inicial
        response.sendRedirect(request.getContextPath() + "/index.jsp");
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
