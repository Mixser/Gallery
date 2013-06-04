/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.PictureDB;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author mixser
 */
public class HomeServlet extends HttpServlet {

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
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        if (request.getSession(true).getAttribute("locale")==null)
            request.getSession(true).setAttribute("locale", "en");
        request.setAttribute("lastPicture", PictureDB.getInstance().getLastPictures(5));
        RequestDispatcher requestDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/home.jsp");
        requestDispatcher.forward(request, response);
    }
    
}
