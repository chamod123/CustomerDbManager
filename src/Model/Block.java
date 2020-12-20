/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Chamod
 */
public class Block {

    private int id;
    private String block_no;

    public Block(int id, String block_no) {
        this.id = id;
        this.block_no = block_no;
    }
    
    public Block(String block_no) {
        this.block_no = block_no;
    }
    
    public Block() {
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlock_no() {
        return block_no;
    }

    public void setBlock_no(String block_no) {
        this.block_no = block_no;
    }
    
}
