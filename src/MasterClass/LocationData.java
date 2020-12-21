/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MasterClass;

import DBClass.DBFacade;
import Model.Location;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Chamod
 */
public class LocationData {
     DBFacade db = new DBFacade();
     
     public ResultSet getLocation() {
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM location ";
            rs = (ResultSet) db.fetch(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
     
      public Location searchLocation(String branch_name) {

        Location location = new Location();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM location WHERE `location_name` = '" + branch_name + "'";
            rs = (ResultSet) db.fetch(sql);

            rs.last();

            rs.beforeFirst();
            int x = 0;
            while (rs.next()) {
                location.setId(rs.getInt("id"));
                location.setLocation_name(rs.getString("location_name"));
                location.setLocation_code(rs.getString("location_code"));

                x++;
            }
            rs.close();
            rs = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return location;
    }
      
      
      public int SaveLocation(String location_name) {
        int val = 0;

        try {
            PreparedStatement pst2 = (PreparedStatement) db.psmt("INSERT INTO `location` (`location_name`) "
                    + " VALUES (?);");
            pst2.setString(1, location_name);

            val = pst2.executeUpdate();

            pst2 = null;
            // rsmax = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }
      
      
     
}
