<%-- 
    Document   : showbooks.jsp
    Created on : 22 Aug, 2023, 8:59:43 PM
    Author     : atiwari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="booksearch.mvc.Book,java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books Details</title>
    </head>
    <body>
        <h2>Books Details</h2>
        <p>Following are the books of the subject: <%= request.getAttribute("title")%></p><br>
        <%
            out.println("<table border='2'>");
            out.println("<tr><th>Book Name</th><th>Book Price</th></tr>");
            ArrayList<Book> bookList;
            bookList=(ArrayList<Book>) request.getAttribute("bookList");
            for(Book b:bookList){
                out.println("<tr><td>"+b.getBookname()+"</td><td>"+b.getPrice()+"</td></tr>");
            }
            out.println("</table>");
        %>
    </body>
</html>
