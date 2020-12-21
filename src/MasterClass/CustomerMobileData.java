/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MasterClass;

import DBClass.DBFacade;
import java.sql.PreparedStatement;

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

}
