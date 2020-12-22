/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MasterClass;

import DBClass.DBFacade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Chamod
 */
public class CustomerMobileData {

    DBFacade db = new DBFacade();

    public int SaveCustomerMobileData(String customer_mobile, String branch_name, int branch_id, String location_name, int location_id) {
        int val = 0;

        try {
            PreparedStatement pst2 = (PreparedStatement) db.psmt("INSERT INTO `customer_mobile_data` (`customer_mobile`,`branch_name`,`branch_id`,`location_name`,`location_id`) "
                    + " VALUES (?,?,?,?,?);");
            pst2.setString(1, customer_mobile);
            pst2.setString(2, branch_name);
            pst2.setInt(3, branch_id);
            pst2.setString(4, location_name);
            pst2.setInt(5, location_id);

            val = pst2.executeUpdate();

            pst2 = null;
            // rsmax = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }
    
    
     
      public ResultSet searchCustomerMobile(String customer_tp, String branch_name, String location_name, boolean is_active) {
        ResultSet rs = null;
        try {
            String sql = "";

        
            if (!"".equals(customer_tp.trim())) {
                System.out.println("awaaaaa");
                if ("".equals(sql)) {
                    sql = "SELECT * FROM customer_mobile_data  WHERE `customer_mobile` like '%" + customer_tp + "%'";
                } else {
                    sql = sql + " AND `customer_mobile` like '%" + customer_tp + "%'";
                }
            }

            if (!"Select".equals(branch_name.trim())) {
                if ("".equals(sql)) {
                    sql = "SELECT * FROM customer_mobile_data  WHERE `branch_name` like '%" + branch_name + "%'";
                } else {
                    sql = sql + " AND `branch_name` like '%" + branch_name + "%'";
                }
            }

            if (!"Select".equals(location_name.trim())) {
                if ("".equals(sql)) {
                    sql = "SELECT * FROM customer_mobile_data  WHERE `location_name` like '%" + location_name + "%'";
                } else {
                    sql = sql + " AND `location_name` like '%" + location_name + "%'";
                }
            }
            
            if (is_active) {
                  sql = sql + " AND `status`  = " + is_active;
            }
            
            

//            sql = "SELECT * FROM customer  WHERE `customer_name` like '%" + customer_name + "%' AND `customer_tp` like '%" + customer_tp + "%'";
//            , `branch` like '%" + branch + "%', `block` = '%" + block + "%'
            rs = (ResultSet) db.fetch(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public int updateMobileStatus(String id, int status) {
        int val = 0;
        try {
            PreparedStatement pst = (PreparedStatement) db.psmt("UPDATE `customer_mobile_data` SET `status` = '" + status + "'  WHERE `id` = '" + id + "'");
            val = pst.executeUpdate();
            System.err.println("update complete");
            val = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }

}
