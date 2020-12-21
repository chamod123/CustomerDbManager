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
public class Location {
     private int id;
    private String location_name;
    private String location_code;

    public Location(int id, String location_name, String location_code) {
        this.id = id;
        this.location_name = location_name;
        this.location_code = location_code;
    }
    
     public Location(String location_name, String location_code) {
        this.location_name = location_name;
        this.location_code = location_code;
    }
     
      public Location() {
          
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public String getLocation_code() {
        return location_code;
    }

    public void setLocation_code(String location_code) {
        this.location_code = location_code;
    }
    
    
    
    
}
