/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MasterClass;

import DBClass.DBFacade;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author chamod
 */
public class Catagary1Data {

    DBFacade db = new DBFacade();

    public ResultSet GetCatagary1() {
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM catagary";
            rs = (ResultSet) db.fetch(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public int SaveCatagary1(String catagary_name) {
        int val = 0;

        try {
            PreparedStatement pst2 = (PreparedStatement) db.psmt("INSERT INTO `catagary` (`catagary_name`) VALUES (?);");
            pst2.setString(1, catagary_name);
            val = pst2.executeUpdate();

            pst2 = null;
            // rsmax = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }

    public int updateCatagary1(String id, String catagary_name) {
        int val = 0;
        try {
            PreparedStatement pst = (PreparedStatement) db.psmt("UPDATE `catagary` SET `catagary_name` = '" + catagary_name + "'"
                    + " WHERE `id` = '" + id + "'");
            val = pst.executeUpdate();
            System.err.println("update complete");
            val = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }

    public int DeleteCatagary1(String catagary_id) {
        int val = 0;

        try {
            PreparedStatement pst1 = (PreparedStatement) db.psmt("DELETE FROM `catagary`  WHERE `id` = '" + catagary_id + "'");
            val = pst1.executeUpdate();

            pst1 = null;
            // rsmax = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }

}
