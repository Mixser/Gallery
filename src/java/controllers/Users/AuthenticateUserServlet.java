/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Users;

import controllers.RequestParams;
import dao.UserDB;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;

/**
 *
 * @author mixser
 */
public class AuthenticateUserServlet extends HttpServlet {

   protected void service(HttpServletRequest request, HttpServletResponse response) 
   throws ServletException, IOException{
       authenicate(request, response);
       RequestDispatcher resDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/home.jsp");
       resDispatcher.forward(request, response);
   }
   
   
   private void authenicate(HttpServletRequest request, HttpServletResponse response) {
       String userLogin = request.getParameter("login");
       String userPassword = request.getParameter("password");
       
       User user =  UserDB.getInstance().getUserByLogin(userLogin);
       if (user != null && userPassword.equals(user.getPassword())){
           HttpSession session = request.getSession(true);
           session.setAttribute(RequestParams.USER_ID, user.getId());
       }  else {
           request.setAttribute("notice", "Bad login/password");
       }
   }
           
}
