/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Pictures;

import java.io.IOException;
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
public class EditPictureServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException{
        String id = request.getParameter(RequestParams.ID);
        String code = request.getParameter("code");
        Picture picture = new Picture();
        if (id != null && code != null) {
            Long pictureId = Long.parseLong(id);
            picture = PictureDB.getInstance().getPictureById(pictureId);
            if (picture != null && !code.equals(picture.getRemoveCode())) {
                request.setAttribute("notice", "Access denied!!!");
                RequestDispatcher resDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/home");
                resDispatcher.forward(request, response);
                return;
            }
        }
        request.setAttribute(RequestParams.PICTURE, picture);
        request.setAttribute("code", code);
        request.setAttribute("id", id);
        RequestDispatcher resDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/editPicture.jsp");
        resDispatcher.forward(request, response);
    }
}
