/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Users;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mixser
 */
public class LoginUserServlet extends HttpServlet {
      @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException{
        String url = request.getRequestURI();
        HttpSession session = request.getSession(true);
        if (url.equals("/login")) {
            if (session.getAttribute("user_id") != null) {
                response.sendRedirect("/home");
                return;
            }
            RequestDispatcher resDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/userLogin.jsp");
            resDispatcher.forward(request, response);
        } else {
            session.removeAttribute("user_id");
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/home"));
        }
            
    }
}
