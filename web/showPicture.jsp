<%-- 
    Document   : showPicture
    Created on : May 29, 2013, 5:30:46 PM
    Author     : mixser
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Details</title>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
        <script src="/res/bootstrap.js"></script>
        <%@include file="styles.html" %>
    </head>
    <body>
        <%@include file="head.jspf" %>
        <fmt:bundle basename="${locale}">
        <div class ="container pagination-centered" style="padding-top: 10%;" >
            <img src ="/images/${picture.fileName}" width="350" hediht="350">
            
            <p><fmt:message key="show.title"/><c:out value="${picture.title}"/></p>
            <p><fmt:message key="show.details"/> <c:out value="${picture.details}"/></p>
            
            
            <c:if test="${not empty user_id}">
                
                    <a type="button" class="btn btn-large btn-primary" href="${picture.urlForEdit}"><fmt:message key="edit"/></a>
             <a type="button" class="btn btn-large btn-primary" href="${picture.urlForDelete}"><fmt:message key="delete"/></a>
             </c:if>
            </fmt:bundle>
        </div>
    </body>
</html>
