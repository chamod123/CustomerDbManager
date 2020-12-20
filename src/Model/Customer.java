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
public class Customer {

    private int id;
    private String customer_name;
    private String customer_tp;
    private String customer_email;
    private String date;
    private String branch;
    private String block_no;

    public Customer(int id, String customer_name, String customer_tp, String customer_email, String date, String branch, String block_no) {
        this.id = id;
        this.customer_name = customer_name;
        this.customer_tp = customer_tp;
        this.customer_email = customer_email;
        this.date = date;
        this.branch = branch;
        this.block_no = block_no;
    }

    public Customer(String customer_name, String customer_tp, String customer_email, String date, String branch, String block_no) {

        this.customer_name = customer_name;
        this.customer_tp = customer_tp;
        this.customer_email = customer_email;
        this.date = date;
        this.branch = branch;
        this.block_no = block_no;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_tp() {
        return customer_tp;
    }

    public void setCustomer_tp(String customer_tp) {
        this.customer_tp = customer_tp;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBlock_no() {
        return block_no;
    }

    public void setBlock_no(String block_no) {
        this.block_no = block_no;
    }

}
