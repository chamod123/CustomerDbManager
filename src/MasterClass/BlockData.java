/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MasterClass;

import DBClass.DBFacade;
import Model.Block;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Chamod
 */
public class BlockData {
      DBFacade db = new DBFacade();

    public ResultSet getBlock() {
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM block ";
            rs = (ResultSet) db.fetch(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public Block searchBlock(String block_no) {

        Block block = new Block();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM block WHERE `block_no` = '" + block_no + "'";
            rs = (ResultSet) db.fetch(sql);

            rs.last();

            rs.beforeFirst();
            int x = 0;
            while (rs.next()) {
                block.setId(rs.getInt("id"));
                block.setBlock_no(rs.getString("block_no"));

                x++;
            }
            rs.close();
            rs = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return block;
    }
    
    public int SaveBlock(String block_no) {
        int val = 0;

        try {
            PreparedStatement pst2 = (PreparedStatement) db.psmt("INSERT INTO `block` (`block_no`) "
                    + " VALUES (?);");
            pst2.setString(1, block_no);

            val = pst2.executeUpdate();

            pst2 = null;
            // rsmax = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }
}
