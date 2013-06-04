<%-- 
    Document   : pictureList.jsp
    Created on : May 18, 2013, 6:04:18 PM
    Author     : mixser
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Picture list</title>
        <%@include file="styles.html" %>
        <style>
            body {
                padding-top: 120px;
                padding-left: 97px;
            }
        </style>
    </head>
    <body>
        <%@include file="head.jspf" %>
        <fmt:bundle basename="${locale}">
        <ul class="thumbnails">    
       
        
        <c:forEach items="${pictureList}" var="picture">
            <li class="span4 thumbnail">
                <a href ="/picture/${picture.id}" class ="thumbnail">
                    <img src ="/images/${picture.fileName}" width="300" height="200" alt=""/>
                    <h3><c:out value="${picture.title}"/> </h3>
                    <p><c:out value="${picture.details}"/></p>
                </a>
                    <c:if test="${not empty user_id}">
                        <a class="btn-small btn-primary" href="${picture.urlForEdit}"  ><fmt:message key="edit"/></a>
                        <a class="btn-small btn-primary" href="${picture.urlForDelete}"  ><fmt:message key="delete"/></a>
                    </c:if>
            </li>       
        </c:forEach>
        </ul>
        </fmt:bundle>
    </body>

</html>
