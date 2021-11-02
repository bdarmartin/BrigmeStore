<%-- 
    Document   : catalogo
    Created on : 30/10/2021, 07:18:22 PM
    Author     : BrinSirias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%@page import="com.brimestore.*" %>
<%@page import="java.util.ArrayList"%>
<jsp:include page="loggedHeader.jsp" />

<% 
        HttpSession sn = request.getSession(true);
        Boolean error = false;
        ArrayList<Cliente> clientes = null;
        ArrayList<Videojuego> juegos = null;
        Cliente cliente = null;
        String username = null;
        Boolean isSuper = false;
        Boolean bulk = false;
        
        if (sn.getAttribute("cliente") != null) {
                if (sn.getAttribute("cliente").equals("superadmin")) {
                    isSuper = true;
                }
            }
        
        if (sn.getAttribute("cliente") == null) {
            response.sendRedirect("login.jsp");
        } else {
            username = (String) sn.getAttribute("cliente");
        
            if (username.equals("superadmin")) {
                isSuper = true;
            }

            if (sn.getAttribute("clientes") == null) {
                juegos = new ArrayList<Videojuego>();
            }
            
            if (sn.getAttribute("clientes") == null) {
                clientes = new ArrayList<Cliente>();
                Cliente superAdmin = new Cliente(0, "superadmin", "bsiriasr@miumg.edu.gt", "78895645123", "7889564-5", "superadmin");
                clientes.add(superAdmin);

                sn.setAttribute("clientes", clientes);
            } else {
                clientes = (ArrayList) sn.getAttribute("clientes");
                juegos = (ArrayList) sn.getAttribute("juegos");
                cliente = GeneralServlet.searchUserAction(username);
            }
    %>

<div class="container">
            <div class="row">
                <div class="col s12">
                    <h1 class="center">Catalogo de videojuegos</h1>
                </div>
            </div>
            <div class="row">
                <div class="col s12">
                    <div class="row">
                        <%  if (juegos != null) { 
                            if (juegos.size() > 0) {
                                for (int i = 0; i<juegos.size(); i++) {
                                    Videojuego j = juegos.get(i); 
                                    if (j != null) { %>
                                        <div class="col s6 m6">
                                            <div class="card blue-grey darken-1">
                                                <div class="card-content white-text">
                                                  <span class="card-title"><%=j.getNombre()%></span>
                                                  <p><%=j.getDescripcion()%></p>
                                                  <small>Existencias: <%=j.getExistencias()%></small>
                                                </div>
                                                <div class="card-action">
                                                  <a class="<% if (j.getExistencias() <= 0) { %>disabled<% } %>" href="#">Rentar juego</a>
                                                </div>
                                            </div>
                                       </div>
                            <%      } 
                                } %>
                        <%  } else { %>
                            <div class="col s12">
                                <p class="center">Parece que no existen videjuegos en la plataforma...</p>
                            </div>
                        <%  } %>
                        <% } else { %>
                            <div class="col s12">
                                <p class="center">Parece que no existen videjuegos en la plataforma...</p>
                            </div>
                        <% } %>
                    </div>
                </div>
            </div>
        </div>
    <% } %>
        
<jsp:include page="footer.jsp" />