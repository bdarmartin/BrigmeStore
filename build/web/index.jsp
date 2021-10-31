<%-- 
    Document   : index
    Created on : 29/10/2021, 10:37:26 PM
    Author     : BrinSirias
--%>

<%@page session="true" %>
<%@page import="com.brimestore.*" %>
<%@page import="java.util.ArrayList"%>
<%
    HttpSession sn = request.getSession(true);
    Cliente u = null;
    ArrayList<Cliente> clientes = null;
    
    if (sn.getAttribute("cliente") != null) {
%>
        <jsp:include page="loggedHeader.jsp" />
<%  } else { %>
        <jsp:include page="header.jsp" />
<%  } %>
        <div class="container">
            <div class="row">
                <div class="col s12 center">
                    <h1 class="">BrigmeStore</h1>
                    <h4 class="pb-5">¡La tienda de prestamo de videojuegos más especializada del condado!</h4>
                    <div>
                        <p>Inicia hoy!!</p>
                        <a href="register.jsp" class="btn btn-outline-danger mb-3">Registrarme</a>
                        <p>O si tienes cuenta, <a class="text-danger" href="login.jsp">inicia sesión</a></p>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col s12">
                    <p class="">
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque egestas iaculis justo eu aliquam. Maecenas ut viverra ligula. Morbi in commodo lectus. Aliquam tempus ante non libero pulvinar interdum. Duis aliquam nulla a posuere iaculis. Praesent nec bibendum sem. Ut et diam sit amet dolor malesuada placerat quis in turpis. Mauris tempor dapibus quam, in cursus nunc facilisis id. Phasellus eget urna tincidunt, congue eros quis, laoreet erat. Donec vestibulum velit eget dapibus consectetur. Sed iaculis purus non sodales suscipit. Pellentesque orci dolor, rhoncus quis aliquam eget, fermentum eget leo. Pellentesque id fermentum sem. Interdum et malesuada fames ac ante ipsum primis in faucibus.
                        Curabitur in volutpat mauris, sed porta libero. Praesent eu maximus erat. Pellentesque sit amet euismod leo, at laoreet sem. Sed malesuada, sapien sed pretium tincidunt, lectus nisl vehicula neque, quis porttitor velit libero vitae odio. Donec ac auctor quam. Proin tristique finibus urna, efficitur convallis mi feugiat ut. Duis suscipit scelerisque sapien at suscipit. Donec finibus metus nibh, nec varius nibh tempor eget. Fusce ut lectus varius magna vehicula dignissim ut sed tellus. Phasellus dignissim ante sed ligula vehicula elementum. Etiam dolor arcu, imperdiet eu erat nec, varius volutpat eros. Vestibulum risus velit, iaculis a aliquam nec, ullamcorper a risus.
                        Suspendisse volutpat odio id semper congue. Sed ultrices massa quam, vel sodales est facilisis eu. Suspendisse facilisis gravida risus nec tristique. Proin ultricies auctor erat at luctus. Duis eget finibus nunc, sed fringilla velit. Quisque posuere sapien a dui scelerisque, dapibus tincidunt est malesuada. Nullam ultrices tortor nec ipsum convallis, a varius lectus mattis. Sed dictum libero eget ligula tincidunt, eget auctor mi consectetur.
                    </p>
                </div>
            </div>
        </div>
        
<jsp:include page="footer.jsp" />
