/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kyleq
 */

import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class HotelDatabaseManager {
    private String databaseUrl;
    private String username;
    private String password;
    
    public HotelDatabaseManager(String databaseUrl, String username, String password){
        this.databaseUrl = databaseUrl;
        this.username = username;
        this.password = password;
    }
    
    public Connection getDatabaseConnection() throws SQLException{
        return DriverManager.getConnection(databaseUrl, username, password);
    }
    
    public boolean isUsernameExist(String username) {
        int count = 0;

        try (Connection connection = getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS count FROM user WHERE username=?")) {
            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    count = resultSet.getInt("count");
                }
            }

            return count == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean isEmailUsed(String email){
        int count=0;
        
        try(Connection connection = getDatabaseConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS count FROM guest WHERE email=?")){
            preparedStatement.setString(1, email);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                count=resultSet.getInt("count");
            }
            return count==1;
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean registerUser(String first_name, String last_name, String username, String email, String phone_number, String password){
        try (Connection connection = getDatabaseConnection()) {
            // Start a transaction
            connection.setAutoCommit(false);

            try {
                try (PreparedStatement preparedUserStatement = connection.prepareStatement(
                        "INSERT INTO user (username, password) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
                    preparedUserStatement.setString(1, username);
                    preparedUserStatement.setString(2, password);
                    
                    int userRowsInserted = preparedUserStatement.executeUpdate();

                    if (userRowsInserted > 0) {
                        try (ResultSet resultSet = preparedUserStatement.getGeneratedKeys()) {
                            if (resultSet.next()) {
                                int user_id = resultSet.getInt(1);

                                try (PreparedStatement preparedGuestStatement = connection.prepareStatement(
                                        "INSERT INTO guest(guest_id, first_name, last_name, email, phone_no, user_id) VALUES (?, ?, ?, ?, ?, ?)")) {
                                    preparedGuestStatement.setInt(1, user_id);
                                    preparedGuestStatement.setString(2, first_name);
                                    preparedGuestStatement.setString(3, last_name);
                                    preparedGuestStatement.setString(4, email);
                                    preparedGuestStatement.setString(5, phone_number);
                                    preparedGuestStatement.setInt(6, user_id);
                                            
                                    int guestRowsInserted = preparedGuestStatement.executeUpdate();

                                    connection.commit();
                                    return guestRowsInserted>0;
                                }
                            }
                        }
                    }
                }
            } catch(SQLException e) {
                connection.rollback();
                e.printStackTrace();
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    public User retrieveUser(String username) {
        User user = null;

        try (Connection connection = getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE username=?")) {

            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("user_id");
                String pass = resultSet.getString("password");
                int usertype = resultSet.getInt("usertype");

                user = new User(id, username, pass, usertype);
            }

            preparedStatement.close();
            return user;

        } 
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Guest retrieveGuest(int user_id){
        Guest guest = null;
        
        try(Connection connection = getDatabaseConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from guest where user_id=?")){
            
            preparedStatement.setInt(1, user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                int guest_id = resultSet.getInt("guest_id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String phone_no = resultSet.getString("phone_no");
                
                guest = new Guest(guest_id, first_name, last_name, email, phone_no);
            }
            
            preparedStatement.close();
            return guest;
            
        }
        catch(SQLException e){
            System.out.println("Error");
            return null;
        }
    }
    
    public Staff retrieveStaff(int user_id){
        Staff staff = null;
        
        try(Connection connection = getDatabaseConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from staff where user_id=?")){
            
            preparedStatement.setInt(1, user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                int staff_id = resultSet.getInt("staff_id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String phone_no = resultSet.getString("phone_no");
                
                staff = new Staff(staff_id, first_name, last_name, email, phone_no);
            }
            
            preparedStatement.close();
            return staff;
            
        }
        catch(SQLException e){
            System.out.println("Error");
            return null;
        }
    }
    
    public boolean registerFeedback(String feedback, String rate, int guest_id){
        try(Connection connection = getDatabaseConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO feedback (rating, feedback, guest_id, feedback_date) VALUES (?, ?, ?, NOW())")){
    
            preparedStatement.setString(1, rate);
            preparedStatement.setString(2, feedback);
            preparedStatement.setDouble(3, guest_id);
            
            int rowsInserted = preparedStatement.executeUpdate();
            
            return rowsInserted>0;
            
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Unsuccessful in registerFeedback");
            return false;
        }
    }
    
    public boolean hasFeedback(int guest_id) {
        int count = 0;

        try (Connection connection = getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS count FROM feedback WHERE guest_id=?")) {
            preparedStatement.setInt(1, guest_id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    count = resultSet.getInt("count");
                }
            }

            return count == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public String retrieveGuestFeedback(int guest_id){
        String feedback="";
        try (Connection connection = getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM feedback WHERE guest_id=?")) {

            preparedStatement.setInt(1, guest_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                feedback = resultSet.getString("feedback");
            }

            preparedStatement.close();
            return feedback;

        } 
        catch (SQLException e) {
            e.printStackTrace();
            return feedback;
        }
    }
    
    public String retrieveGuestRating(int guest_id){
        String rating="";
        try (Connection connection = getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM feedback WHERE guest_id=?")) {

            preparedStatement.setInt(1, guest_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                rating = resultSet.getString("rating");
            }

            preparedStatement.close();
            return rating;

        } 
        catch (SQLException e) {
            e.printStackTrace();
            return rating;
        }
    }
    
    public boolean updateFeedback(String feedback, String rate, int guest_id){
        try(Connection connection = getDatabaseConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE feedback SET rating = ?, feedback = ?, feedback_date = NOW() WHERE guest_id= ?")){
    
            preparedStatement.setString(1, rate);
            preparedStatement.setString(2, feedback);
            preparedStatement.setDouble(3, guest_id);
            
            int rowsInserted = preparedStatement.executeUpdate();
            
            return rowsInserted>0;
            
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Unsuccessful in updateFeedback");
            return false;
        }
    }
    
    public boolean removeFeedback(int guest_id) {
        try(Connection connection = this.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM feedback where guest_id=?")) {

            preparedStatement.setInt(1, guest_id);

            int rowsUpdated = preparedStatement.executeUpdate();

            return rowsUpdated > 0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public Room retrieveRoom(int room_number){
        Room room = null;
        
        try(Connection connection = getDatabaseConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from room where room_number=?")){
            
            preparedStatement.setInt(1, room_number);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                String room_type = resultSet.getString("room_type");
                int room_capacity = resultSet.getInt("room_capacity");
                double rate = resultSet.getDouble("rate");
                String status = resultSet.getString("status");
                
                room = new Room(room_number, room_type, room_capacity, rate, status);
            }
            
            preparedStatement.close();
            return room;
            
        }
        catch(SQLException e){
            System.out.println("Error");
            return null;
        }
    }
    
    public boolean registerBooking(int room_number, int guest_id, Date checkInDate, Date checkOutDate, double total_amount){
        try(Connection connection = getDatabaseConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO booking (room_number, guest_id, check_in_date, check_out_date, total_amount, booking_date) VALUES (?, ?, ?, ?, ?, NOW())")){
    
            preparedStatement.setInt(1, room_number);
            preparedStatement.setInt(2, guest_id);
            preparedStatement.setDate(3, new java.sql.Date(checkInDate.getTime()));
            preparedStatement.setDate(4, new java.sql.Date(checkOutDate.getTime()));
            preparedStatement.setDouble(5, total_amount);
            
            int rowsInserted = preparedStatement.executeUpdate();
            
            return rowsInserted>0;
            
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Unsuccessful in registerBooking");
            return false;
        }
    }
    
     public boolean isInOutDatesConflicts(int room_number, Date checkInDate, Date checkOutDate) {
        int count = 0;

        try (Connection connection = getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS count FROM booking WHERE (check_in_date < ? AND check_out_date > ?) AND checked_out=0 AND room_number=?")) {
            
            preparedStatement.setDate(1, new java.sql.Date(checkOutDate.getTime()));
            preparedStatement.setDate(2, new java.sql.Date(checkInDate.getTime()));
            preparedStatement.setInt(3, room_number);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    count = resultSet.getInt("count");
                }
            }

            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateRoomStatus(int room_number, String status){
        try(Connection connection = getDatabaseConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE room SET status = ? WHERE room_number = ?")){
    
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, room_number);
            
            int rowsInserted = preparedStatement.executeUpdate();
            
            return rowsInserted>0;
            
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Unsuccessful in updateRoomStatus");
            return false;
        }
    }
     
    public boolean removeBooking(int booking_id) {
        try(Connection connection = this.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM booking where booking_id=?")) {

            preparedStatement.setInt(1, booking_id);

            int rowsUpdated = preparedStatement.executeUpdate();

            return rowsUpdated > 0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateBookingCheckIn(int booking_id){
        try(Connection connection = getDatabaseConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE booking SET checked_in = 1 WHERE booking_id = ?")){
    
            preparedStatement.setInt(1, booking_id);
            
            int rowsInserted = preparedStatement.executeUpdate();
            
            return rowsInserted>0;
            
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Unsuccessful in updateBookingCheckIn");
            return false;
        }
    }
    
    public boolean updateBookingCheckOut(int checkin_id){
        try(Connection connection = getDatabaseConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE booking INNER JOIN check_in ON booking.booking_id = check_in.booking_id SET booking.checked_out = 1 WHERE check_in.checkin_id = ?")){
    
            preparedStatement.setInt(1, checkin_id);
            
            int rowsInserted = preparedStatement.executeUpdate();
            
            return rowsInserted>0;
            
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Unsuccessful in updateBookingCheckIn");
            return false;
        }
    }
    
    public boolean registerCheckIn(String arrival, int booking_id){
        try(Connection connection = getDatabaseConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO check_in (arrival, booking_id) VALUES (?, ?)")){
    
            preparedStatement.setString(1, arrival);
            preparedStatement.setInt(2, booking_id);
            
            int rowsInserted = preparedStatement.executeUpdate();
            
            return rowsInserted>0;
            
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Unsuccessful in registerCheckIn");
            return false;
        }
    }
   
    public boolean registerBill(double amount, int checkin_id){
        try(Connection connection = getDatabaseConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO bill (stay_cost, checkin_id) VALUES (?, ?)")){
    
            preparedStatement.setDouble(1, amount);
            preparedStatement.setInt(2, checkin_id);
            
            int rowsInserted = preparedStatement.executeUpdate();
            
            return rowsInserted>0;
            
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Unsuccessful in registerBill");
            return false;
        }
    }
    
    public int retrieveCheckInID(int booking_id){
        int checkin_id = 0;
        
        try (Connection connection = getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM check_in WHERE booking_id=?")) {

            preparedStatement.setInt(1, booking_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                checkin_id = resultSet.getInt("checkin_id");
            }

            preparedStatement.close();
            return checkin_id;

        } 
        catch (SQLException e) {
            e.printStackTrace();
            return checkin_id;
        }
    } 
    
    public boolean hasCheckedOut(int bill_id) {
        int count = 0;

        try (Connection connection = getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS count FROM bill INNER JOIN check_in ON bill.checkin_id = check_in.checkin_id INNER JOIN booking ON check_in.booking_id = booking.booking_id INNER JOIN guest ON booking.guest_id = guest.guest_id WHERE bill.bill_id = ? AND booking.checked_out = 1;")) {
            preparedStatement.setInt(1, bill_id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    count = resultSet.getInt("count");
                }
            }

            return count == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateBill(int bill_id, String status){
        try(Connection connection = getDatabaseConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE bill SET status = ?, payment_date = NOW() WHERE bill_id = ?")){
    
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, bill_id);
            
            int rowsInserted = preparedStatement.executeUpdate();
            
            return rowsInserted>0;
            
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Unsuccessful in updateBill");
            return false;
        }
    }
    
    public boolean isBillPaid(int bill_id){
        boolean checked=false;
        try (Connection connection = getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM bill WHERE bill_id=?")) {

            preparedStatement.setInt(1, bill_id);
            
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String status = resultSet.getString("status");
                if("Paid".equals(status)){
                    checked=true;
                }
            }

            preparedStatement.close();
            return checked;

        } 
        catch (SQLException e) {
            e.printStackTrace();
            return checked;
        }
    } 
    
    public boolean registerRequestService(int service_id, int checkin_id){
        try(Connection connection = getDatabaseConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO request_service (request_date, checkin_id, service_id) VALUES (NOW(), ?, ?)")){
    
            preparedStatement.setInt(1, checkin_id);
            preparedStatement.setInt(2, service_id);
            
            int rowsInserted = preparedStatement.executeUpdate();
            
            return rowsInserted>0;
            
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Unsuccessful in registerRequestService");
            return false;
        }
    }
    
    public boolean isServiceRequested(int service_id, int checkin_id){
        int count=0;
        try (Connection connection = getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS count FROM request_service WHERE service_id=? and checkin_id=? and status!='Cancelled' and status!='Granted'" )) {

            preparedStatement.setInt(1, service_id);
            preparedStatement.setInt(2, checkin_id);
            
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                count = resultSet.getInt("count");
            }

            preparedStatement.close();
            return count>0;

        } 
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    } 
    
    public boolean updateServiceRequest(int request_id, String status){
        try(Connection connection = getDatabaseConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE request_service SET status = '" + status + "' WHERE request_id = ?")){
    
            preparedStatement.setInt(1, request_id);
            
            int rowsInserted = preparedStatement.executeUpdate();
            
            return rowsInserted>0;
            
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Unsuccessful in cancelServiceRequest");
            return false;
        }
    }
    
    public boolean addServiceCostToBill(int request_id, double cost){
        try(Connection connection = getDatabaseConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE request_service INNER JOIN check_in ON request_service.checkin_id = check_in.checkin_id INNER JOIN bill ON check_in.checkin_id = bill.checkin_id SET bill.services_cost = services_cost+? WHERE request_service.request_id = ?")){
            
            preparedStatement.setDouble(1, cost);
            preparedStatement.setInt(2, request_id);
            
            int rowsInserted = preparedStatement.executeUpdate();
            
            return rowsInserted>0;
            
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Unsuccessful in cancelServiceRequest");
            return false;
        }
    }
    
}
