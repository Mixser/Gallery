/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Pictures;
import controllers.RequestParams;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.PictureDB;
/**
 *
 * @author mixser
 */
public class PictureListServlet extends HttpServlet {

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
        request.setAttribute(RequestParams.PICTURE_LIST,PictureDB.getInstance().getPictures());
        RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/pictureList.jsp");
        reqDispatcher.forward(request, response);
    }
}
