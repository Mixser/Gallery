<%-- 
    Document   : editPicture
    Created on : May 19, 2013, 3:35:55 PM
    Author     : mixser
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload New Picture</title>
        <%@include file="styles.html" %>
        <script type="text/javascript">
         function submitForm(action) {
            var formValid = true;
            
            var title = document.getElementById("title");
            if (title.value.trim() == "" ) {
                title.style.backgroundColor = "red";
                formValid = false;
            }
            
            var details = document.getElementById("details");
            if (details.value.trim() == "") {
                details.style.backgroundColor = "red";
                formValid = false;
            }
            
            var picture = document.getElementById("picture");
            if (picture.value.trim() == "") {
                picture.style.backgroundColor = "red";
                formValid = false;
            }
            
            if (picture.files[0].size > 5 * 1024 * 1024) {
                picture.style.backgroundColor = "red";
                formValid = false; 
            }
            
            if (formValid) {
                document.getElementById("action").value = action;
                document.forms[0].submit();
                
            }
            
            
            return formValid;
        }
        </script>
        
    </head>
    <body>
    
    <fmt:bundle basename="${locale}">
        <%@include file="head.jspf" %>
        
         <style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-upload {
        max-width: 300px;
        padding: 19px 82px 29px;
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
      .form-upload .form-upload-heading,
      .form-upload .checkbox {
        margin-bottom: 10px;
      }
      

    </style>
        
            
           
        <form class ="form-upload" id="pictureForm" action="${pageContext.servletContext.contextPath}/picture/save" method="POST" enctype="multipart/form-data">
            <fieldset>
                    <label class="" for="title"><fmt:message key="edit.title"/></label>
                    <input type="text" id="title" placeholder="title" name="pictureTitle">
                        
                    <label class="" for="details"><fmt:message key="edit.details"/></label>
                    <input type="text" id="details" placeholder="details" name="pictureDetails">
                        
                    <label class="" for="picture"><fmt:message key="edit.upload_file"/></label>
                    <input type ="file" id="picture" name="picture" multiple accept="image/*,image/jpeg" /> <br /><br /><br />
                    <input type="hidden" id="id" name="id" value ="${id}">
                    <input type="hidden" id="code" name="code" value ="${code}">
                    <input type="hidden" id="action" name="action" value="cancel"/>
                    <button type="button" class="btn btn-large btn-primary" href="javascript:void(0);" onclick="submitForm('save');"><fmt:message key="edit.update"/></button>
                    <input type="submit" class="btn btn-large btn-danger" value ="<fmt:message key="edit.cancel"/>"> 
             </fieldset>
           
        </form>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
        <script src="/bootstrap.js"></script>
        </fmt:bundle>
    </body>
</html>
