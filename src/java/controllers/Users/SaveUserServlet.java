/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Users;

import controllers.RequestParams;
import dao.PictureDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Picture;

/**
 *
 * @author mixser
 */
public class SaveUserServlet extends HttpServlet {

       @Override
       protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
           String action = request.getParameter(RequestParams.ACTION);
           if  (action.equals(RequestParams.SAVE)) {
               savePicture(request, response);
           } else {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/picture/list"));
        }
       }
       
       private void savePicture(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
           response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/picture/list"));
           
       }
       
       private Picture getPicture(String id) {
           Picture picture = null;
           if (id != null) {
               Long pictureId = Long.parseLong(id);
               picture = PictureDB.getInstance().getPictureById(pictureId);
           }
           if (picture == null) {
               picture = new Picture();
           }
           return picture;
       }
}
