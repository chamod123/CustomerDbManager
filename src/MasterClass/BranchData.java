/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MasterClass;

import DBClass.DBFacade;
import Model.Branch;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Chamod
 */
public class BranchData {

    DBFacade db = new DBFacade();

    public ResultSet getBranch() {
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM branch ";
            rs = (ResultSet) db.fetch(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public Branch searchBranch(String branch_name) {

        Branch branch = new Branch();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM branch WHERE `branch_name` = '" + branch_name + "'";
            rs = (ResultSet) db.fetch(sql);

            rs.last();

            rs.beforeFirst();
            int x = 0;
            while (rs.next()) {
                branch.setId(rs.getInt("id"));
                branch.setBranch_name(rs.getString("branch_name"));
                branch.setBranch_code(rs.getString("branch_code"));

                x++;
            }
            rs.close();
            rs = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return branch;
    }

    public int SaveBranch(String branch_name, String branch_code) {
        int val = 0;

        try {
            PreparedStatement pst2 = (PreparedStatement) db.psmt("INSERT INTO `branch` (`branch_code`,`branch_name`) "
                    + " VALUES (?,?);");
            pst2.setString(1, branch_code);
            pst2.setString(2, branch_name);

            val = pst2.executeUpdate();

            pst2 = null;
            // rsmax = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }

}
