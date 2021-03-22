/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MasterClass;

import DBClass.DBFacade;
import Model.Branch;
import Model.Location;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Chamod
 */
public class CustomerMobileData {

    DBFacade db = new DBFacade();
    BranchData branchData = new BranchData();
    LocationData locationData = new LocationData();

    public int SaveCustomerMobileData(String customer_mobile, String branch_name, String location_name, String catagary_name, int catagary_id, String cus_no, String cus_name, String cus_mail, String cus_dob, String cus_address, String cus_gender) {
        int val = 0;
        Branch branch;
        Location location;

        if (branchData.searchBranch(branch_name).getBranch_name() == null) {
            System.out.println("new Branch");
            branchData.SaveBranch(branch_name, "000");
        } else {
            System.out.println("Old Branch");
        }
        branch = branchData.searchBranch(branch_name);

        if (locationData.searchLocation(location_name).getLocation_name() == null) {
            System.out.println("new Block");
            locationData.SaveLocation(location_name);
        } else {
            System.out.println("Old Block");
        }

        location = locationData.searchLocation(location_name);

        try {
            PreparedStatement pst2 = (PreparedStatement) db.psmt("INSERT INTO `customer_mobile_data` (`customer_mobile`,`branch_name`,`branch_id`,`location_name`,`location_id`,`catagary_name`,`catagary_id`,`cus_no`,`cus_name`,`cus_mail`,`cus_dob`,`cus_address`,`cus_gender`) "
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);");
            pst2.setString(1, customer_mobile);
            pst2.setString(2, branch_name);
            pst2.setInt(3, branch.getId());
            pst2.setString(4, location_name);
            pst2.setInt(5, location.getId());
            pst2.setString(6, catagary_name);
            pst2.setInt(7, catagary_id);
            pst2.setString(8, cus_no);
            pst2.setString(9, cus_name);
            pst2.setString(10, cus_mail);
            pst2.setString(11, cus_dob);
            pst2.setString(12, cus_address);
            pst2.setString(13, cus_gender);

            val = pst2.executeUpdate();

            pst2 = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }

    public ResultSet searchCustomerMobile(String customer_tp, String branch_name, List<String> location_names, boolean is_active, String catogary_name) {
        ResultSet rs = null;
        try {
            String sql = "";
            String location_sql = "";

            System.out.println("!location_names.isEmpty() " + !location_names.isEmpty());

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

            if (!"Select".equals(catogary_name.trim())) {
                if ("".equals(sql)) {
                    sql = "SELECT * FROM customer_mobile_data  WHERE `catagary_name` like '%" + catogary_name + "%'";
                } else {
                    sql = sql + " AND `catagary_name` like '%" + catogary_name + "%'";
                }
            }

            if (!location_names.isEmpty()) {
                if ("".equals(sql)) {
                    System.out.println("true");
                    for (int i = 0; location_names.size() > i; i++) {
                        System.out.println("i = " + i);
                        if (i == 0) {
                            sql = "SELECT * FROM customer_mobile_data  WHERE `location_name` like '%" + location_names.get(i) + "%'";
                        } else {
                            sql = sql + "OR `location_name` like '%" + location_names.get(i) + "%' ";
                        }
                    }

                } else {
                    System.out.println("false " + location_names.size());
                    for (int i = 0; location_names.size() > i; i++) {
                        System.out.println("i = " + i);
                        if (i == 0) {
                            sql = "SELECT * FROM (" + sql + ")customer_mobile_data  WHERE `location_name` like '%" + location_names.get(i) + "%'";
                        } else {
                            sql = sql + "OR `location_name` like '%" + location_names.get(i) + "%' ";
                        }
                    }
                }
            }

            if (is_active) {
                sql = sql + " AND `status`  = " + is_active;
            }

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
