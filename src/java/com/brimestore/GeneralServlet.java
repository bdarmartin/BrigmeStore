/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brimestore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author BrinSirias
 */
@WebServlet(name = "GeneralServlet", urlPatterns = {"/GeneralServlet"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class GeneralServlet extends HttpServlet {
    private final String dbUrl = "jdbc:mysql://remotemysql.com:3306"; // Base de datos string de conexion
    private final String dbUser = "AzITpNfnDk"; // Base de datos username
    private final String dbPassword = "xb3sqdvjfj"; // Base de datos contrasena
    private static final String SAVE_DIR = "/temp";
    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private static ArrayList<Videojuego> videojuegos = new ArrayList<Videojuego>();
    private static ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
    private static ArrayList<PrestamoVideojuego> prestamosJuegos = new ArrayList<PrestamoVideojuego>();
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;
    private static Connection con = null; 
    private static JSONParser parser = new JSONParser();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GeneralServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GeneralServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //try {
            //con = conectar();
            // Statements allow to issue SQL queries to the database
            //statement = con.createStatement();
            
            //preparedStatement = con
            //        .prepareStatement("SELECT * from AzITpNfnDk.cliente");
            //resultSet = preparedStatement.executeQuery();
            //writeClientes(resultSet);
        //} catch (SQLException ex) {
            //Logger.getLogger(GeneralServlet.class.getName()).log(Level.SEVERE, null, ex);
        //}
        
        String stringOption = request.getParameter("option");
        
        if (stringOption == null) {
            stringOption = "3";
        }
        
        int option = Integer.valueOf(stringOption);
        clientes = (ArrayList) request.getSession().getAttribute("clientes");
        Cliente cliente = searchUserAction((String) request.getSession().getAttribute("cliente"));
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String nit = request.getParameter("nit");
        String contrasena = request.getParameter("contrasena");
        
        String appPath = request.getServletContext().getRealPath("");
        String savePath = appPath + File.separator + SAVE_DIR + File.separator;
        
        switch(option) {
            // LoginAction
            case 1:
                if (loginAction(nombre, contrasena)) {
                    request.getSession().setAttribute("cliente", nombre);
                    response.sendRedirect("catalogo.jsp");
                } else {
                    response.sendRedirect("login.jsp?error=true");
                }
                break;
            // RegisterAction
            case 2:
                {
                    try {
                        if (registerAction(nombre, correo, telefono, nit, contrasena)) {
                            request.getSession().setAttribute("clientes", clientes);
                            response.sendRedirect("login.jsp");
                        } else {
                            response.sendRedirect("register.jsp?error=true");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(GeneralServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            // BulkAction
            case 3:
                File flSaveDir = new File(savePath);
                String success = "false";
                
                if (!flSaveDir.exists()) {
                    flSaveDir.mkdir();
                }
                
                try {
                    Part filePart = request.getPart("file");
                    String flname = filePart.getSubmittedFileName();
                    InputStream inStream = null;
                    OutputStream outStream = null;
                    
                    try {
                        File outFile = new File(savePath + flname);
                        inStream = filePart.getInputStream();
                        outStream = new FileOutputStream(outFile);
                        int read = 0;
                        final byte[] bytes = new byte[1024];
                        
                        while((read = inStream.read(bytes)) != -1) {
                            outStream.write(bytes, 0, read);
                        }
                        
                        read(savePath + flname);
                        request.getSession().setAttribute("clientes", clientes);
                        success = "true";
                    } catch(Exception e) {
                        System.out.println(e.toString());
                    } finally {
                        if (outStream != null) {
                            outStream.close();
                        }
                        
                        if (inStream != null) {
                            inStream.close();
                        }
                    }
                } catch(Exception e) {
                    System.out.println(e.toString());
                }
                
                response.sendRedirect("catalogo.jsp?bulk=" + success);
                break;
            // Crear Curso
            case 4: 
                
                break;
            default:
                response.sendRedirect("index.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    /**
     * @param username
     * @return cliente 
     */
    public static Cliente searchUserAction(String username) {
        if (clientes.size() > 0) {
            for (Cliente cliente : clientes) {
                if (cliente.getNombre().equals(username)) {
                    return cliente;
                }
            }
        } else {
            return null;
        }
        
        return null;
    }
    
    /**
     * @param id
     * @return cliente 
     */
    public static Cliente buscarCliente(int id) {
        if (clientes.size() > 0) {
            for (Cliente cliente : clientes) {
                if (cliente.getId() == id) {
                    return cliente;
                }
            }
        } else {
            return null;
        }
        
        return null;
    }
    
    /**
     * @param id
     * @return prestamo
     */
    public static Prestamo buscarPrestamo(int id) {
        if (prestamos.size() > 0) {
            for (Prestamo prestamo : prestamos) {
                if (prestamo.getId() == id) {
                    return prestamo;
                }
            }
        } else {
            return null;
        }
        
        return null;
    }
    
    /**
     * @param id
     * @return videojuego 
     */
    public static Videojuego buscarVideojuego(int id) {
        if (videojuegos.size() > 0) {
            for (Videojuego videojuego : videojuegos) {
                if (videojuego.getId() == id) {
                    return videojuego;
                }
            }
        } else {
            return null;
        }
        
        return null;
    }
    
    /**
     * @param username
     * @param password
     * @return 
     */
    private static Boolean loginAction(String username, String password) {
        Cliente cliente = searchUserAction(username);
        
        if (cliente != null) {
            if (cliente.getContrasena().equals(password)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * @param nombre
     * @param correo
     * @param telefono
     * @param nit
     * @param contrasena
     * @return
     * @throws SQLException 
     */
    public static Boolean registerAction(String nombre, String correo, String telefono, String nit, String contrasena) throws SQLException {
        Cliente cliente = new Cliente(nombre, correo, telefono, nit, contrasena);
        preparedStatement = con
            .prepareStatement("insert into AzITpNfnDk.cliente values (default, ?, ?, ?, ?, ?, ?");
            // Parameters start with 1
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getCorreo());
            preparedStatement.setString(3, cliente.getTelefono());
            preparedStatement.setString(5, cliente.getNit());
            preparedStatement.setString(6, cliente.getContrasena());
            preparedStatement.executeUpdate();
            
            return true;
    }
    
    /**
     * Agregar usuarios de la BD al arrayList clientes
     * @param resultSet
     * @throws SQLException 
     */
    private void writeClientes(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            int id = resultSet.getInt("cliente_id");
            String nombre = resultSet.getString("nombre");
            String correo = resultSet.getString("correo");
            String telefono = resultSet.getString("telefono");
            String nit = resultSet.getString("nit");
            String contrasena = resultSet.getString("contrasena");
            Cliente addCliente = new Cliente(id, nombre, correo, telefono, nit, contrasena);
            clientes.add(addCliente);
        }
    }
    
    /**
     * Conectar a la BD mysql
     *
     * @return a Connection object
     */
    public Connection conectar() {
        Connection conn = null;
        
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            System.out.println("La conexion a la BD mysql fue exitosa!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
    
    /**
     * @param users
     * @param path
     * @throws FileNotFoundException
     * @throws ParseException 
     */
    static void read(String path) throws FileNotFoundException, ParseException, java.text.ParseException {
        try {
            File json = new File(path);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            System.out.println("iniciando carga masiva");
            
            if (json.exists()) {
                Object obj = parser.parse(new FileReader(path));
                JSONArray arreglo = (JSONArray) obj;

                for(int i=0; i<arreglo.size(); i++){
                    JSONObject array = (JSONObject)arreglo.get(i);
                    JSONArray arrayJuegos = (JSONArray)array.get("videojuegos");
                    JSONArray arrayClientes = (JSONArray)array.get("clientes");
                    JSONArray arrayPrestamos = (JSONArray)array.get("prestamos");
                    JSONArray arrayPrestamosJuegos = (JSONArray)array.get("prestamos_videojuegos");

                    for (int j=0; j<arrayJuegos.size(); j++) {
                        JSONObject juego = (JSONObject)arrayJuegos.get(j);
                        Long id = (Long)juego.get("videojuego_id");
                        Long total = (Long)juego.get("cantidad_total");
                        Long exis = (Long)juego.get("existencias");
                        Double precio = (Double)juego.get("precio_prestamo");
                        
                        Videojuego nuevoJuego = new Videojuego(
                            (int)id.intValue(),
                            (String)juego.get("slug"),
                            (String)juego.get("nombre"),
                            (String)juego.get("descripcion"),
                            (int)total.intValue(),
                            (int)exis.intValue(),
                            (float)precio.floatValue()
                        );
                        
                        videojuegos.add(nuevoJuego);
                    }
                    
                    for (int j=0; j<arrayClientes.size(); j++) {
                        JSONObject cliente = (JSONObject)arrayClientes.get(j);
                        Long id = (Long)cliente.get("cliente_id");
                    
                        Cliente nuevoCliente = new Cliente(
                            (int)id.intValue(),
                            (String)cliente.get("nombre"),
                            (String)cliente.get("correo"),
                            (String)cliente.get("telefono"),
                            (String)cliente.get("nit"),
                            (String)cliente.get("contrasena")
                        );
                        
                        clientes.add(nuevoCliente);
                    }
                    
                    for (int j=0; j<arrayPrestamos.size(); j++) {
                        JSONObject prestamo = (JSONObject)arrayPrestamos.get(j);
                        Long id = (Long)prestamo.get("prestamo_id");
                        Long ext = (Long)prestamo.get("extension");
                        Long clienteId = (Long)prestamo.get("cliente_id");
                        Double total = (Double)prestamo.get("total");
                        Double multa = (Double)prestamo.get("multa");
                        String prestado = (String)prestamo.get("prestado_el");
                        String devuelto = (String)prestamo.get("devuelto_el");
                        
                        Prestamo nuevoPrestamo = new Prestamo(
                            (int)id.intValue(),
                            (float)total.floatValue(),
                            (Date)formatter.parse(prestado),
                            !devuelto.equals("") ? (Date)formatter.parse(devuelto) : null,
                            (int)ext.intValue(),
                            (float)multa.floatValue(),
                            buscarCliente((int)clienteId.intValue())
                        );
                        
                        prestamos.add(nuevoPrestamo);
                    }
                    
                    for (int j=0; j<arrayPrestamosJuegos.size(); j++) {
                        JSONObject prestamoJuego = (JSONObject)arrayPrestamosJuegos.get(j);
                        Long id = (Long)prestamoJuego.get("prestamo_videojuego_id");
                        Long prestamoId = (Long)prestamoJuego.get("prestamo_id");
                        Long juegoId = (Long)prestamoJuego.get("videojuego_id");
                        
                        PrestamoVideojuego nuevoPreJue = new PrestamoVideojuego(
                            (int)id.intValue(),
                            buscarPrestamo((int)prestamoId.intValue()),
                            buscarVideojuego((int)juegoId.intValue())
                        );
                        
                        prestamosJuegos.add(nuevoPreJue);
                    }
                }
            }
        } catch(FileNotFoundException f) {
            System.out.println("Error: " + f.getMessage());
        } catch (IOException i) {
            System.out.println("Error: " + i.getMessage());
        }
    }
}
