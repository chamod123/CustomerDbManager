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
public class Branch {

    private int id;
    private String branch_code;
    private String branch_name;

    public Branch(int id, String branch_code, String branch_name) {
        this.id = id;
        this.branch_code = branch_code;
        this.branch_name = branch_name;
    }

    public Branch(String branch_code, String branch_name) {

        this.branch_code = branch_code;
        this.branch_name = branch_name;
    }

    public Branch() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBranch_code() {
        return branch_code;
    }

    public void setBranch_code(String branch_code) {
        this.branch_code = branch_code;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

}
