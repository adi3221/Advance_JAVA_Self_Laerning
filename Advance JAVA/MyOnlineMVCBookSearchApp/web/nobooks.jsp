<%-- 
    Document   : nobooks
    Created on : 22 Aug, 2023, 9:19:19 PM
    Author     : atiwari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Not Found!</title>
    </head>
    <body>
        <h2>Sorry! the books of <%= request.getAttribute("title")%> are not found!</h2><br>
        
    </body>
</html>
