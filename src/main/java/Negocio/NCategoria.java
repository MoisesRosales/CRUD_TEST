package Negocio;

import DB.Conexion;
import Datos.DCategoria;
import Entitys.ECategoria;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author moise
 */
public class NCategoria {
    
    private String mensaje = "";
    private DCategoria dCategoria = new DCategoria();
    
    public String addCategoria(ECategoria c){
        
        Connection conn  = Conexion.getConnection();
        try {
            mensaje = dCategoria.addCategoria(conn, c);
        } catch (Exception e) {
            mensaje = mensaje + " " +e.getMessage();
        }finally{
            try {
                if (conn != null) {
                  conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " +e.getMessage();
            }
        }
        return mensaje;
    }
    public String updateCategoria(ECategoria c){
        
        Connection conn  = Conexion.getConnection();
        try {
            mensaje = dCategoria.updateCategoria(conn, c);
        } catch (Exception e) {
            mensaje = mensaje + " " +e.getMessage();
        }finally{
            try {
                if (conn != null) {
                  conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " +e.getMessage();
            }
        }
        return mensaje;
    }
    public String deleteCategoria(int id){
        
        Connection conn  = Conexion.getConnection();
        try {
            mensaje = dCategoria.deleteCategoria(conn, id);
        } catch (Exception e) {
            mensaje = mensaje + " " +e.getMessage();
        }finally{
            try {
                if (conn != null) {
                  conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " +e.getMessage();
            }
        }
        return mensaje;
    }
    public void listarCategoria(JTable table){
       Connection conn = Conexion.getConnection();
       dCategoria.listarCategoria(conn, table);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
