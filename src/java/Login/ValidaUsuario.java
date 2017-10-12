/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import bd.Conexion;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alumno
 */
public class ValidaUsuario extends HttpServlet {
    
    String user, contra;
    Conexion conect = new Conexion();
    Statement stm = null;
    ResultSet result = null;
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        user = request.getParameter("user");
        contra = request.getParameter("contra");
        
        Connection conexion = conect.getConexion();
        try {
            stm = (Statement) conexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ValidaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try (PrintWriter out = response.getWriter()) {
            
            try{
                out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet ValidaUsuario</title>");            
                    out.println("</head>");
                    out.println("<body>");
                result = stm.executeQuery("Select * from users where nombre = '" + user + "' && pass = '" + contra + "';");
                if(result.first()){
                    out.println("<h1>Validado</h1>");
                }
                else{
                    out.println("<h1>Usuario no encontrado</h1>");
                }
                out.println("</body>");
                out.println("</html>");
            }catch(SQLException error)
            {
                System.out.println(error.toString());
            }
            
        }
        
    }


}
