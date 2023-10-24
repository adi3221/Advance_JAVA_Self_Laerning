<%-- 
    Document   : addnos
    Created on : 23 Aug, 2023, 1:41:20 PM
    Author     : atiwari
--%>

<%@page errorPage="showerror.jsp" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Division Result!</h2>
        <%
            int a = Integer.parseInt(request.getParameter("fno"));
            int b = Integer.parseInt(request.getParameter("sno"));
            int c = a/b;
            out.println("Div is "+c);
        %>
    </body>
</html>
