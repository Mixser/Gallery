/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.PictureDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mixser
 */
public class LocaleServlet extends HttpServlet {

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
        String locale =(String) request.getParameter("lang");
        String antilocale = null;
        if (locale == null || locale.equals("en")) {
            locale = "ru";
        } else {
            locale = "en";
        }
        request.getSession(true).setAttribute("locale", locale);
        request.setAttribute("lastPicture", PictureDB.getInstance().getLastPictures(5));
        //RequestDispatcher resDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/home");
        //resDispatcher.forward(request, response);
        response.sendRedirect("/home");
    }
}
