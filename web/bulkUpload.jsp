<%-- 
    Document   : bulkUpload
    Created on : 29/10/2021, 02:33:57 AM
    Author     : BrinSirias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%@page import="com.brimestore.*" %>
<!DOCTYPE html>
<jsp:include page="loggedHeader.jsp" />

    <% 
        Boolean error = false;

        if (request.getParameter("error") != null) {
            if (request.getParameter("error").equals("true")) {
                error = true;
            }
        }
    %>

    <div class="container">
        <div class="row">
            <div class="col s12">
                <h1 class="center">Carga masiva</h1>
                <p class="center">Ingrese el archivo (.json) para realizar la carga masiva de datos al sistema.</p>

                <form action="GeneralServlet" method="post" class="w-50 mb-5 ml-auto mr-auto" enctype="multipart/form-data">
                    <%  if (error) { %>
                            <p class="text-danger text-center">Parece que el archivo no es correcto o tiene información corrupta...</p>
                    <%  } %>
                    
                    <div class="file-field input-field">
                        <div class="btn">
                          <span>Subir archivo</span>
                          <input type="file" id="file" name="file" required>
                        </div>
                        <div class="file-path-wrapper">
                          <input class="file-path validate" type="text">
                        </div>
                    </div>
                    
                    <div class="right">
                        <input type="hidden" name="option" id="option" value="3">
                        <button type="submit" value="bulk" class="btn btn-primary">Cargar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

<jsp:include page="footer.jsp" />
