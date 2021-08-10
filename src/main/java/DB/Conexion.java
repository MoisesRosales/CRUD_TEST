package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author moise
 */
public class Conexion {
    
    private static Connection conn = null;
    private static String user = "DESARROLLO";
    private static String pass = "noshka";
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    
    public static Connection getConnection(){
    
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url,user,pass);
            conn.setAutoCommit(false);
            if(conn != null){
                System.out.println("CONEXION EXITOSA");   
            }else{
                System.out.println("CONEXION FALLIDA"); 
            }
        } catch (ClassNotFoundException |SQLException e) {
            JOptionPane.showMessageDialog(null,"CONEXION FALLIDA " + e.getMessage());
        }
        return conn;
    }
    
    public void closeConnection(){
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("DESCONEXION FALLIDA "+ e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Conexion c = new Conexion();
        c.getConnection();
    }
}
