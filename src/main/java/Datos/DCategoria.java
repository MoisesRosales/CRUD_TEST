package Datos;

import Entitys.ECategoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author moise
 */
public class DCategoria {
    
    private String mensaje = "";
    
    public String addCategoria(Connection con, ECategoria c){
        
        PreparedStatement pst = null;
        String sql = "INSERT INTO CATEGORIES(CATEGORY_ID, CATEGORY_NAME, DESCRIPTION, PICTURE) "
                    + "VALUES (CATEGORIES_SEQ.NEXTVAL, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1,c.getCATEGORY_NAME());
            pst.setString(2,c.getDESCRIPTION());
            pst.setString(3,c.getPICTURE());
            mensaje = "GUARDADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "NO SE PUDO GUARDAR CORRECTAMENTE\n" + e.getMessage();
        }
        return mensaje;
    }
    public String updateCategoria(Connection con, ECategoria c){
        
        PreparedStatement pst = null;
        String sql = "UPDATE CATEGORIES SET CATEGORY_NAME = ?, DESCRIPTION=?, PICTURE=?"
                    + "WHERE CATEGORY_ID = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1,c.getCATEGORY_NAME());
            pst.setString(2,c.getDESCRIPTION());
            pst.setString(3,c.getPICTURE());
            pst.setInt(4, c.getCATEGORY_ID());
            mensaje = "ACTUALIZADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "NO SE PUDO ACTUALIZAR CORRECTAMENTE\n" + e.getMessage();
        }
        return mensaje;
    }
    public String deleteCategoria(Connection con, int id){
        
        PreparedStatement pst = null;
        String sql = "DELETE FROM CATEGORIES WHERE CATEGORY_ID = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,id);
            mensaje = "ELIMINADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "NO SE PUDO ELIMINAR CORRECTAMENTE\n" + e.getMessage();
        }
        return mensaje;
    }
    public void listarCategoria(Connection con,JTable table){
       
        DefaultTableModel model;
        String [] col = {"ID","NAME","DESCRIPCION","PICTURE"};
        model = new DefaultTableModel(null,col);
        
        String sql = "SELECT * FROM CATEGORIES ORDER BY CATEGORY_ID";
        
        String [] filas = new String [4];
        Statement st = null;
        ResultSet rs = null;
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                for (int i = 0; i < 4; i++) {
                    filas[i] = rs.getString(i+1);
                    System.out.println(i);
                }
                System.out.println("q");
                model.addRow(filas);
            }
            System.out.println("x");
            table.setModel(model);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO CARGAR DATOS" + e.getMessage());
        }
    }
}
