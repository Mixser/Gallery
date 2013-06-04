/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Pictures;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controllers.RequestParams;
import models.Picture;
import dao.PictureDB;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author mixser
 */
public class DeletePictureServlet extends HttpServlet {

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
        String remCode = (String) request.getParameter(RequestParams.REMOVE);
        String notice = "Picture was removed =) </br>Have a nice day";
        String id = (String) request.getParameter(RequestParams.ID);
        Picture picture = PictureDB.getInstance().getPictureById(Long.parseLong(id));
        
        if (picture != null) {
            String code = picture.getRemoveCode();
            if (code.equals(remCode)) {
                PictureDB.getInstance().deletePictureById(picture.getId());
            }
            else  {
                notice = "Wrong id or remove code";
            }
        } else {
            notice = "Wrong id or remove code";
        }
        request.setAttribute("notice", notice);
        RequestDispatcher resDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/home.jsp");
        resDispatcher.forward(request, response);
    }
}
