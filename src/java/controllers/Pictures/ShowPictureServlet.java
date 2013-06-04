/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Pictures;

import controllers.RequestParams;
import dao.PictureDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Picture;

/**
 *
 * @author mixser
 */
public class ShowPictureServlet extends HttpServlet {

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

            String uid = request.getPathInfo();
        RequestDispatcher resDispatcher = null;
        uid =  uid.replace('/', '0');
        Picture picture = PictureDB.getInstance().getPictureById(Long.valueOf(uid));
        if (picture != null) {
            request.setAttribute(RequestParams.PICTURE, picture);
            resDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/showPicture.jsp");
        } else {
            resDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/404.jsp");
        }
        resDispatcher.forward(request, response);
    }
}
