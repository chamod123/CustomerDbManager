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
public class Catagary {

    private int id;
    private String catagary_code;
    private String catagary_name;

    public Catagary(int id, String catagary_code, String catagary_name) {
        this.id = id;
        this.catagary_code = catagary_code;
        this.catagary_name = catagary_name;
    }

    public Catagary(String catagary_code, String catagary_name) {
        this.catagary_code = catagary_code;
        this.catagary_name = catagary_name;
    }

    public Catagary() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatagary_code() {
        return catagary_code;
    }

    public void setCatagary_code(String catagary_code) {
        this.catagary_code = catagary_code;
    }

    public String getCatagary_name() {
        return catagary_name;
    }

    public void setCatagary_name(String catagary_name) {
        this.catagary_name = catagary_name;
    }

}
