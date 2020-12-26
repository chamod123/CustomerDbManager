/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MasterClass;

import DBClass.DBFacade;
import Model.Catagary;
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

    public Catagary searchCatogary(String catagary_name) {

        Catagary catogary = new Catagary();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM catagary WHERE `catagary_name` = '" + catagary_name + "'";
            rs = (ResultSet) db.fetch(sql);

            rs.last();

            rs.beforeFirst();
            int x = 0;
            while (rs.next()) {
                catogary.setId(rs.getInt("id"));
                catogary.setCatagary_name(rs.getString("catagary_name"));
                catogary.setCatagary_code(rs.getString("catagary_code"));

                x++;
            }
            rs.close();
            rs = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return catogary;
    }

}
