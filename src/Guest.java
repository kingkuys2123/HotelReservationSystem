/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kyleq
 */
public class Guest {
    private int guest_id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_no;
    
    public Guest(int guest_id, String first_name, String last_name, String email, String phone_no){
        this.guest_id=guest_id;
        this.first_name=first_name;
        this.last_name=last_name;
        this.email=email;
        this.phone_no=phone_no;
    }
    
    public int getGuestID(){
        return this.guest_id;
    }
    
    public String getFirstName(){
        return this.first_name;
    }
    
    public String getLastName(){
        return this.last_name;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getPhoneNo(){
        return this.phone_no;
    }
    
    public void setGuestID(int guest_id){
        this.guest_id=guest_id;
    }
    
    public void setFirstName(String first_name){
        this.first_name=first_name;
    }
    
    public void setLastName(String last_name){
        this.last_name=last_name;
    }
    
    public void setEmail(String email){
        this.email=email;
    }
    
    public void setPhoneNo(String phone_no){
        this.phone_no=phone_no;
    }
    
}
