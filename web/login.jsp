<%-- 
    Document   : login
    Created on : 29/10/2021, 11:58:27 PM
    Author     : BrinSirias
--%>

<jsp:include page="header.jsp" />
<%@page session="true" %>
<%@page import="com.brimestore.*" %>
<%@page import="java.util.ArrayList"%>

<% 
    HttpSession sn = request.getSession(true);
    Boolean error = false;

    if (request.getParameter("error") != null) {
        if (request.getParameter("error").equals("true")) {
            error = true;
        }
    }

    if (sn.getAttribute("cliente") != null) {
        response.sendRedirect("catalogo.jsp");
    } else {
        ArrayList<Cliente> clientes = (ArrayList) sn.getAttribute("clientes");
%>
    <div class="container">
        <div class="row">
            <form action="GeneralServlet" method="post" class="col s12">
                <h1 class="center">¡Inicia sesión! <%=clientes.size()%></h1>
                
                <%  if (error) { %>
                    <p class="red darken-4 center">Parece que los datos ingresados no son correctos...</p>
                <%  } %>
                
                <div class="row">
                  <div class="input-field col s12">
                    <input placeholder="Nombre de usuario" id="nombre" name="nombre" type="text" class="validate">
                    <label for="nombre">Nombre</label>
                  </div>
                  <div class="input-field col s12">
                      <input id="contrasena" type="password" class="validate" name="contrasena" placeholder="Contraseña">
                    <label for="contrasena">Contraseña</label>
                  </div>
                </div>
                <div class="right">
                    <input type="hidden" name="option" id="option" value="1">
                    <button type="submit" value="login" class="btn btn-primary">Ingresar</button>
                </div>
            </form>
        </div>
    </div>
<% } %>
        
<jsp:include page="footer.jsp" />
