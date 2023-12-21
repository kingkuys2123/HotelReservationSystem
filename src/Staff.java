/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kyleq
 */
public class Staff {
    private int staff_id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_no;
    
    public Staff(int staff_id, String first_name, String last_name, String email, String phone_no){
        this.staff_id=staff_id;
        this.first_name=first_name;
        this.last_name=last_name;
        this.email=email;
        this.phone_no=phone_no;
    }
    
    public int getStaffID(){
        return this.staff_id;
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
    
    public void setStaffID(int staff_id){
        this.staff_id=staff_id;
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
