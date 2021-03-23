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
    private String customer_no;
    private String customer_name;
    private String customer_tp;
    private String customer_email;
    private String date;
    private String address;
    private int branch_id;
    private int location_id;

    public Customer(int id, String customer_name, String customer_tp, String customer_email, String date, int branch_id) {
        this.id = id;
        this.customer_name = customer_name;
        this.customer_tp = customer_tp;
        this.customer_email = customer_email;
        this.date = date;
        this.branch_id = branch_id;
    }

    public Customer(String customer_name, String customer_tp, String customer_email, String date, int branch_id) {

        this.customer_name = customer_name;
        this.customer_tp = customer_tp;
        this.customer_email = customer_email;
        this.date = date;
        this.branch_id = branch_id;
    }

    public Customer() {
    }

    public String getCustomer_no() {
        return customer_no;
    }

    public void setCustomer_no(String customer_no) {
        this.customer_no = customer_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
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

}
