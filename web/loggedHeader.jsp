<%-- 
    Document   : loggedHeader
    Created on : 29/10/2021, 02:30:06 AM
    Author     : BrinSirias
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%@page import="com.brimestore.*" %>
<!DOCTYPE html>
<html>
    <head>
        <title>BrigmeStore</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <link href="assets/css/fontawesome/all.min.css" rel="stylesheet">
        <link href="assets/css/datatables/datatables.min.css" rel="stylesheet">
        <link href="assets/css/styles.css" rel="stylesheet">
        <script src="assets/js/jquery.js"></script>
        <script src="assets/js/fontawesome/all.min.js"></script>
        <script src="assets/js/datatables/datatables.min.js"></script>
    </head>
    <body>
        <% 
            HttpSession sn = request.getSession(true);
            Boolean isSuper = false;
            ArrayList<Cliente> clientes = null;
            
            if (sn.getAttribute("cliente") != null) {
                if (sn.getAttribute("cliente").equals("superadmin")) {
                    isSuper = true;
                }
                
                if (sn.getAttribute("clientes") == null) {
                    clientes = new ArrayList<Cliente>();
                    Cliente cliente = new Cliente(0, "superadmin", "bsiriasr@miumg.edu.gt", "78895645123", "7889564-5", "superadmin");
                    clientes.add(cliente);

                    sn.setAttribute("clientes", clientes);
                }
            }
        %>
        <nav>
            <div class="nav-wrapper">
              <a href="index.jsp" class="brand-logo">BrigmeStore</a>
              <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li><a href="catalogo.jsp">Catalogo</a></li>
                <% if (!isSuper) { %>
                <li><a href="profile.jsp">Mis prestamos</a></li>
                <% } %>
                <li><a href="profile.jsp">Mi perfil</a></li>
                <% if (isSuper) { %>
                <li><a href="bulkUpload.jsp">Carga Masiva</a></li>
                <% } %>
                <li><a href="logoutAction.jsp">Cerrar Sesión</a></li>
              </ul>
            </div>
        </nav>