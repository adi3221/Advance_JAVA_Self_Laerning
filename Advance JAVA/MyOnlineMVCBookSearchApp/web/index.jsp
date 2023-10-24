<%-- 
    Document   : index
    Created on : 22 Aug, 2023, 4:43:46 PM
    Author     : atiwari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Search</title>
    </head>
    <body>
        <h2>Book Search Application</h2>
        <form action="BookControllerServlet" method="get">
            <table>
                <tr><th>Enter Subject:</th><td><input type="text" name="subject"> </td></tr>
                <tr><td><input type="submit" value="Show Books"></td></tr>
            </table>
        </form>
    </body>
</html>
