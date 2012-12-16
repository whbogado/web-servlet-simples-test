/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if6ae.exemplos.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Universidade Tecnológica Federal do Paraná
 * IF6AE Desenvolvimento de Aplicaçoões Web
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
@WebServlet(name = "Modelo", urlPatterns = {"/modelo"})
public class Modelo extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Modelo de Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Modelo de Servlet em " + request.getContextPath() + "</h1>");
            out.println("<form action='modelo' method='post'>");
            out.println("Nome: <input type='text' name='nome'/><br/>");
            out.println("<input type='submit' value='Enviar'/><br/>");
            out.println("</form>");
            String nome = request.getParameter("nome");
            if  (request.getMethod().equalsIgnoreCase("post")) {
                if (nome == null || nome.trim().isEmpty()) {
                    out.println("<h2 style='color: red'><b>Informe o nome!</b></h2>");
                } else {
                    out.println("<h2>Olá, <b>" + nome + "</b></h2>");
                }
            }
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
        return "Modelo de servlet";
    }// </editor-fold>
}
