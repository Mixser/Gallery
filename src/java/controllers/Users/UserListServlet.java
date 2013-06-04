/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import dao.UserDB;
import java.util.List;
import models.User;

/**
 *
 * @author mixser
 */
public class UserListServlet extends HttpServlet {
       @Override
       protected void service(HttpServletRequest request, HttpServletResponse response) 
               throws ServletException, IOException {
           List<User> user = UserDB.getInstance().getUsers();
           request.setAttribute("userList", user);
           RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/userList.jsp");
           reqDispatcher.forward(request, response);
        }
}
