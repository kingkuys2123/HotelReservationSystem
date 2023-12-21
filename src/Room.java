/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kyleq
 */
public class Room {
    private int room_number;
    private String room_type;
    private int room_capacity;
    private double rate;
    private String status;
    
    public Room(int room_number, String room_type, int room_capacity, double rate, String status){
        this.room_number=room_number;
        this.room_type=room_type;
        this.room_capacity=room_capacity;
        this.rate=rate;
        this.status=status;
    }
    
    public int getRoomNumber(){
        return this.room_number;
    }
    
    public String getRoomType(){
        return this.room_type;
    }
    
    public int getRoomCapacity(){
        return this.room_capacity;
    }
    
    public double getRate(){
        return this.rate;
    }
    
    public String getStatus(){
        return this.status;
    }
    
    public void setRoomNumber(int room_number){
        this.room_number=room_number;
    }
    
    public void setRoomType(String room_type){
        this.room_type=room_type;
    }
    
    public void setRoomCapacity(int room_capacity){
        this.room_capacity=room_capacity;
    }
    
    public void setRate(double rate){
        this.rate=rate;
    }
    
    public void setStatus(String status){
        this.status=status;
    }
    
    
}
