
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Index page</title>
        <%@include file="styles.html" %>
    </head>
    
    <body>
        
        <%@include file="head.jspf" %>
        
        <%@include file="carousel.jspf" %>
        <fmt:bundle basename="${locale}">
            <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
            <script src="/res/bootstrap.js"></script>
            <c:if test="${not empty notice}">
                    <div class ="bla"> <br />
                        <h1 align ="center">${notice}</h1>
                    </div>
                </c:if>
            <div class="container">
                
                <hr class="featurette-divider">

                        <div class="featurette">
                            <img class="featurette-image pull-left" src="http://bootstrap-ru.com/assets/img/examples/browser-icon-firefox.png">
                            <h2 class="featurette-heading">And lastly, this one. <span class="muted">Checkmate.</span></h2>
                            <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
                        </div>

                <hr class="featurette-divider">
                
                
                
                
                <footer>
                    <p class="pull-right"><a href="#">Back to top</a></p>
                    <p>&copy; 2012 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
            
                </footer>
                
                
                
            </div>

    <script>
      $(function () {
        $(function(){
          $('#myCarousel').carousel();
        });
      }(window.jQuery));
    </script>
        </fmt:bundle>
    </body>
</html>