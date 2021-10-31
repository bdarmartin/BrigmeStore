<%-- 
    Document   : logoutAction
    Created on : 28/10/2021, 12:42:20 AM
    Author     : BrinSirias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BrigmeStore</title>
    </head>
    <body>
        <%
            HttpSession sn = request.getSession(true);
            
            sn.setAttribute("cliente", null);
            
            response.sendRedirect("index.jsp");
        %>
    </body>
</html>
