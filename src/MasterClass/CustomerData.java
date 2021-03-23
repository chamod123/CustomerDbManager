/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MasterClass;

import DBClass.DBFacade;
import Model.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Chamod
 */
public class CustomerData {

    DBFacade db = new DBFacade();

    public int SaveCustomer(String customer_no, String customer_name, String customer_tp, String customer_email, String date, String address, int branch_id, int location_id) {
        int val = 0;

        try {
            PreparedStatement pst2 = (PreparedStatement) db.psmt("INSERT INTO `customer` (`customer_no`,`customer_name`,`customer_tp`,`customer_email`,`date`,`address`,`branch_id`,`location_id`) "
                    + " VALUES (?,?,?,?,?,?,?,?);");
            pst2.setString(1, customer_no);
            pst2.setString(2, customer_name);
            pst2.setString(3, customer_tp);
            pst2.setString(4, customer_email);
            pst2.setString(5, date);
            pst2.setString(6, address);
            pst2.setInt(7, branch_id);
            pst2.setInt(8, location_id);

            val = pst2.executeUpdate();

            pst2 = null;
            // rsmax = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }

    public ResultSet searchCustomers(String customer_name, String customer_tp, String branch, String block) {
        ResultSet rs = null;
        try {
            String sql = "";

            System.out.println("cus name : " + customer_name.trim());
            if (!"".equals(customer_name.trim())) {
                sql = "SELECT * FROM customer  WHERE `customer_name` like '%" + customer_name + "%'";
            }

            System.out.println("customer_tp  : " + !"".equals(customer_tp.trim()));
            if (!"".equals(customer_tp.trim())) {
                System.out.println("awaaaaa");
                if ("".equals(sql)) {
                    sql = "SELECT * FROM customer  WHERE `customer_tp` like '%" + customer_tp + "%'";
                } else {
                    sql = sql + " AND `customer_tp` like '%" + customer_tp + "%'";
                }
            }

            if (!"Select".equals(branch.trim())) {
                if ("".equals(sql)) {
                    sql = "SELECT * FROM customer  WHERE `branch` like '%" + branch + "%'";
                } else {
                    sql = sql + " AND `branch` like '%" + branch + "%'";
                }
            }

            if (!"Select".equals(block.trim())) {
                if ("".equals(sql)) {
                    sql = "SELECT * FROM customer  WHERE `block_no` like '%" + block + "%'";
                } else {
                    sql = sql + " AND `block_no` like '%" + block + "%'";
                }
            }

//            sql = "SELECT * FROM customer  WHERE `customer_name` like '%" + customer_name + "%' AND `customer_tp` like '%" + customer_tp + "%'";
//            , `branch` like '%" + branch + "%', `block` = '%" + block + "%'
            rs = (ResultSet) db.fetch(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public Customer searchCustomerData(String id) {

        Customer customer = new Customer();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM customer WHERE `id` = '" + id + "'";
            rs = (ResultSet) db.fetch(sql);

            rs.last();

            rs.beforeFirst();
            int x = 0;
            while (rs.next()) {
                customer.setId(rs.getInt("id"));
                customer.setCustomer_name(rs.getString("customer_name"));
                customer.setCustomer_tp(rs.getString("customer_tp"));
                customer.setCustomer_email(rs.getString("customer_email"));
                customer.setDate(rs.getString("date"));
                customer.setBranch_id(rs.getInt("branch_id"));
                x++;
            }
            rs.close();
            rs = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    public int DeleteCustomer(String customer_id) {
        int val = 0;

        try {
            PreparedStatement pst1 = (PreparedStatement) db.psmt("DELETE FROM `customer`  WHERE `id` = '" + customer_id + "'");
            val = pst1.executeUpdate();

            pst1 = null;
            // rsmax = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }

    public int updateCustomer(String id, String customer_name, String customer_tp, String customer_email, String date, String branch, String block_no) {
        int val = 0;
        try {
            PreparedStatement pst = (PreparedStatement) db.psmt("UPDATE `customer` SET `customer_name` = '" + customer_name + "' , `customer_tp` = '" + customer_tp + "' , "
                    + "  `customer_email` = '" + customer_email + "' ,  `date` = '" + date + "',  `branch` = '" + branch + "',  `block_no` = '" + block_no + "'  WHERE `id` = '" + id + "'");
            val = pst.executeUpdate();
            System.err.println("update complete");
            val = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }
}