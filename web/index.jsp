
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Index page</title>
        <%@include file="styles.html" %>
    </head>
    
    <body>
        <script type="text/javascript">
            document.location.href = '${pageContext.servletContext.contextPath}/home';
    </script>
    </body>
</html>