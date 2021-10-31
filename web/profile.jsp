<%-- 
    Document   : profile
    Created on : 28/10/2021, 03:31:18 AM
    Author     : BrinSirias
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="loggedHeader.jsp" />
<%@page session="true" %>
<%@page import="com.brimestore.*" %>

    <% 
        HttpSession sn = request.getSession(true);
        Boolean error = false;
        ArrayList<Cliente> clientes = null;
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
                clientes = new ArrayList<Cliente>();
                Cliente superAdmin = new Cliente(0, "superadmin", "bsiriasr@miumg.edu.gt", "78895645123", "7889564-5", "superadmin");
                clientes.add(superAdmin);

                sn.setAttribute("clientes", clientes);
            } else {
                clientes = (ArrayList) sn.getAttribute("clientes");
                cliente = GeneralServlet.searchUserAction(username);
            }
    %>
        
        <div class="container">
            <div class="row">
                <div class="col s12">
                    <h1 class="center">Mi perfil</h1>
                </div>
            </div>
            <div class="row">
                <div class="col s12">
                    <div class="row">
                        <% 
                            if (cliente != null) {
                        %>
                        <div class="col s12">
                            <table class="table table-striped table-dark">
                                <tbody>
                                  <tr>
                                    <th scope="row">Nombre: </th>
                                    <td><%=cliente.getNombre()%></td>
                                  </tr>
                                  <tr>
                                    <th scope="row">Correo: </th>
                                    <td><%=cliente.getCorreo()%></td>
                                  </tr>
                                  <tr>
                                    <th scope="row">Telefono: </th>
                                    <td><%=cliente.getTelefono()%></td>
                                  </tr>
                                  <tr>
                                    <th scope="row">Nit: </th>
                                    <td><%=cliente.getNit()%></td>
                                  </tr>
                                  <tr>
                                    <th scope="row">Contraseña: </th>
                                    <td><%=cliente.getContrasena()%></td>
                                  </tr>
                                </tbody>
                            </table>
                        </div>
                        <%  } %>
                    </div>
                </div>
            </div>
        </div>
    <% } %>
        
<jsp:include page="footer.jsp" />
