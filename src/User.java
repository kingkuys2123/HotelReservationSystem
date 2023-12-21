/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kyleq
 */
public class User {
    private int user_id;
    private String username;
    private String password;
    private int usertype;
    
    public User(int user_id, String username, String password, int usertype){
        this.user_id=user_id;
        this.username=username;
        this.password=password;
        this.usertype=usertype;
    }
    
    public int getUserID(){
        return this.user_id;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public int getUserType(){
        return this.usertype;
    }
    
    public void setUserID(int user_id){
        this.user_id=user_id;
    }
    
    public void setUsername(String username){
        this.username=username;
    }
    
    public void setPassword(String password){
        this.password=password;
    }
    
    public void setUserType(int usertype){
        this.usertype=usertype;
    }
    
}
