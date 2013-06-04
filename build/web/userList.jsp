<%-- 
    Document   : userList
    Created on : May 19, 2013, 9:02:34 PM
    Author     : mixser
--%>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table> 
            <c:forEach items="${userList}" var="user" >
                <tr>
                    <td> ${user.id} </td>
                    <td> ${user.login} </td>
                    <td> ${user.password} </td>
                    <td> ${user.admin} </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
