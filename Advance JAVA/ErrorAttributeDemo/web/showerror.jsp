<%-- 
    Document   : showerror
    Created on : 23 Aug, 2023, 3:09:50 PM
    Author     : atiwari
--%>

<%@page isErrorPage="true" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <%--automatically exception object mil jayega bcoz ye isErrorPage=true hai yaha pe--%>
        <%
        out.println("<h2>Sorry a problem occured while processing the request</h2> <br>");
        out.println("<h1>Exception Details: "+exception.getMessage()+"</h1>");
        %>
    </body>
    
</html>
