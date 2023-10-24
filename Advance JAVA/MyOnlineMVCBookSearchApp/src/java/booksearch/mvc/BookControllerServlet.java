/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksearch.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author atiwari
 */
public class BookControllerServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = null;
        PrintWriter out = response.getWriter();
        try {
            String subject = request.getParameter("subject");
            if(subject.isEmpty()){
                rd = request.getRequestDispatcher("showerror.html");
                rd.forward(request, response);
                
            }
            else{
                try{
                    ArrayList<Book>bookList;
                    bookList = BookDAO.getBooksBySubject(subject);
                    if(bookList.isEmpty()){
                        rd = request.getRequestDispatcher("nobooks.jsp");
                        request.setAttribute("title",subject);
                        rd.forward(request,response);
                    }
                    else{
                        rd = request.getRequestDispatcher("showbooks.jsp");
                        request.setAttribute("title",subject);
                        request.setAttribute("bookList", bookList);
                        rd.forward(request, response);
                    }
                }
                catch(SQLException ex){
                    System.out.println("Error in DB" + ex.getMessage());
                    rd = request.getRequestDispatcher("showdberror.html");
                    rd.forward(request,response);
                }
            }
        } finally {
            out.close();
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
