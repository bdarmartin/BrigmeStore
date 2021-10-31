<%-- 
    Document   : header
    Created on : 28/10/2021, 11:21:08 PM
    Author     : BrinSirias
--%>

<%@page import="com.brimestore.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>

<%
    HttpSession sn = request.getSession(true);

    if (sn.getAttribute("clientes") == null) {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        Cliente cliente = new Cliente(0, "superadmin", "bsiriasr@miumg.edu.gt", "78895645123", "7889564-5", "superadmin");
        clientes.add(cliente);

        sn.setAttribute("clientes", clientes);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <title>BrigmeStore</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="assets/css/styles.css" rel="stylesheet">
        <script src="assets/js/jquery.js"></script>
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    </head>
    <body>
        <nav>
            <div class="nav-wrapper">
              <a href="index.jsp" class="brand-logo">BrigmeStore</a>
              <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li><a href="login.jsp">Iniciar sesión</a></li>
                <li><a href="#">Registrar</a></li>
              </ul>
            </div>
        </nav>
