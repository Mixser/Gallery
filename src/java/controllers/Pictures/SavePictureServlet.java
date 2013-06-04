/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Pictures;

import controllers.FileSaver;
import controllers.RequestParams;
import dao.PictureDB;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Picture;

/**
 *
 * @author mixser
 */
@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class SavePictureServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter(RequestParams.ACTION);

        if (action.equals(RequestParams.SAVE)) {
            savePicture(request, response);
        } else {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/home"));
        }
    }

    private void savePicture(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String id = request.getParameter("id");
        Picture picture = getPicture(id);

        String pictureTitle = request.getParameter(RequestParams.PICTURE_TITLE);
        picture.setTitle(pictureTitle);

        String pictureDetails = request.getParameter(RequestParams.PICTURE_DETAILS);
        picture.setDetails(pictureDetails);

        Long userId = (Long) request.getSession().getAttribute("user_id");
        picture.setUserId(userId);
        String fileName = String.valueOf(System.currentTimeMillis());
        if (isValidate(pictureTitle, pictureDetails) &&  FileSaver.saveFile(request.getPart("picture").getInputStream(), fileName)) {
            //
            //TODO: добавить в имя файла user_id
            
            picture.setFileName(fileName);
            Long user_id = (Long) request.getSession().getAttribute("user_id");
            if (user_id !=  null) {
                picture.setUserId(user_id);
            }
            picture.setRemoveCode(String.valueOf(fileName.hashCode()));
            // TODO: validate;
            PictureDB.getInstance().saveOrUpdatePicture(picture);
            String notice = "url for delete <a href="+picture.getUrlForDelete()+ ">"+picture.getUrlForDelete()+"</a>";
            notice += "url for edit <a href="+picture.getUrlForEdit()+ ">"+picture.getUrlForEdit()+"</a>";
            request.setAttribute("notice", notice);
            RequestDispatcher resDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/home.jsp");
            resDispatcher.forward(request, response);
        } else {
            //TODO: notice
            String notice = "Wrong data";
            request.setAttribute("notice", notice);
            RequestDispatcher resDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/home.jsp");
            resDispatcher.forward(request, response);
        }
    }

    private Picture getPicture(String id) {
        Picture picture = null;
        if (id != null && id.isEmpty() == false) {
            Long pictureId = Long.parseLong(id);
            picture = PictureDB.getInstance().getPictureById(pictureId);
        }
        if (picture == null) {
            picture = new Picture();
        }
        return picture;
    }

    private boolean isValidate(String pictureTitle, String pictureDetails) {
        if (pictureDetails != null && pictureTitle != null) {
            return true;
        }
        return false;
    }
}
