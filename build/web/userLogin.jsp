<%-- 
    Document   : userLogin
    Created on : May 20, 2013, 12:52:17 AM
    Author     : mixser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="styles.html" %>
        
          <style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 100px auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

    </style>
    </head>
    <body>
        <%@include file="head.jspf" %>
        <fmt:bundle basename="${locale}">
        <div class="container">
            
        <form class="form-signin" action="${pageContext.servletContext.contextPath}/user/authenticate" method="POST">
            <h2 class="form-signin-heading"><fmt:message key="signin.title"/></h2>
            <input type="text" name="login" id="login" class="input-block-level" placeholder="<fmt:message key="signin.login"/>">
            <input type="password" name="password" id="password" class="input-block-level" placeholder="<fmt:message key="signin.pass"/>">
            <label class="checkbox">
              <%-- <input type="checkbox" value="remember-me"> Remember me --%>
            </label>
            <button class="btn btn-large btn-primary" type="submit"><fmt:message key="signin"/></button>
       </form>

        </div>
            </fmt:bundle>
    </body>
</html>
