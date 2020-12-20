/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBClass;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author chamod
 */
public class DBFacade {

 /*
 * @author Chamod
 * 
 */


    private static Connection c     =  null;
  protected static String host    =  "localhost";
//    protected static String host    = "192.168.8.59";
    protected static String port    = "3306";
    protected static String DB      = "customer_management";
    protected static String username= "root";
    protected static String pasword = "root";
    
//     protected static String pasword = "medirep@123Incentive";
    
//    protected static String username= "sa";
//    protected static String pasword = "Medirep@#12345";

    public static Connection connect() throws ClassNotFoundException {
        try {
            if (c == null || c.isClosed()) {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://" + host + ":" + port + "/" + DB;
                c = (Connection) DriverManager.getConnection(url, username, pasword);
            }
        }catch (com.mysql.jdbc.CommunicationsException ex) {
            JOptionPane.showMessageDialog(null, "Network Connection Fail", "Alert", JOptionPane.ERROR_MESSAGE);
           // log.logWrite("DatabaseConnection.DBFacade", ex.toString());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex);
//            Logger.getLogger(DBFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    public void save(String sql) throws Exception {
        if (c == null) {
            connect();
        }
        System.out.println(sql);
        try {
            c.createStatement().executeUpdate(sql);
        } catch (Exception e) {
            c =null;
        }
    }

    public ResultSet fetch(String sql) throws Exception {
        if (c == null) {
            connect();
        }
        System.out.println(sql);
        try {
            return c.createStatement().executeQuery(sql);
        } catch (Exception e) {
            c =null;
            return null;
        }
    }

    public PreparedStatement psmt(String sql) throws Exception {
        if (c == null) {
            connect();
        }
        System.out.println(sql);
        try {
            return (PreparedStatement) c.prepareStatement(sql);
        } catch (Exception e) {
            c = null;
            return null;
        }
    }
    
    public boolean saveForUpdate(String sql) throws Exception {
        if (c == null) {
            connect();
        }
        System.out.println(sql);
        try {
            c.createStatement().executeUpdate(sql);
            return true;
        } catch (Exception e) {
            c = null;
            return false;
        }
    }
}
 
