package UserLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Database.DBConnect;

public class UserDBUtil {
    
    private static boolean isSuccess;
    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    public static boolean validate(String username, String password) {
        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "SELECT * FROM user WHERE username='" + username + "' AND password='" + password + "'";
            rs = stmt.executeQuery(sql);
            
            if (rs.next()) {
                isSuccess = true;
            } else {
                isSuccess = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return isSuccess;
    }
    
    public static List<User> getUser(String userName) {
        ArrayList<User> user = new ArrayList<>();
        
        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "SELECT * FROM user WHERE username='" + userName + "'";
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String phone = rs.getString(4);
                String username = rs.getString(5);
                String password = rs.getString(6);
                
                User us = new User(id, name, email, phone, username, password);
                user.add(us);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return user;    
    }
    
    public static boolean updateUser(String id, String name, String email, String phone, String username, String password) {
        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "UPDATE user SET name='" + name + "', email='" + email + "', phone='" + phone + "', username='" + username + "', password='" + password + "' WHERE id='" + id + "'";
            int rs = stmt.executeUpdate(sql);
            
            isSuccess = (rs > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return isSuccess;
    }

    public static List<User> getUserDetails(String Id) {
        int convertedID = Integer.parseInt(Id);
        ArrayList<User> us = new ArrayList<>();
        
        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "SELECT * FROM user WHERE id='" + convertedID + "'";
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String phone = rs.getString(4);
                String username = rs.getString(5);
                String password = rs.getString(6);
                
                User c = new User(id, name, email, phone, username, password);
                us.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }    
        return us;    
    }
    
    public static boolean isUsernameTaken(String username) {
        boolean isTaken = false;
        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "SELECT * FROM user WHERE username='" + username + "'";
            rs = stmt.executeQuery(sql);

            isTaken = rs.next(); // Simplified condition check
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isTaken;
    }
    
    public static boolean insertUser(String name, String email, String phone, String username, String password) {
        boolean isSuccess = false;

        if (isUsernameTaken(username)) {
            return false; // Username is already taken
        }

        String sql = "INSERT INTO user (name, email, phone, username, password) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DBConnect.getConnection(); 
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);
            pstmt.setString(4, username);
            pstmt.setString(5, password); // Consider hashing the password

            int rowsAffected = pstmt.executeUpdate();
            isSuccess = rowsAffected > 0; // Returns true if insertion is successful
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception for debugging
        }

        return isSuccess;
    }

    
    public static boolean deleteUser(String id) {
        int convId = Integer.parseInt(id);
        
        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "DELETE FROM user WHERE id='" + convId + "'";
            int r = stmt.executeUpdate(sql);
            
            isSuccess = (r > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return isSuccess;
    }   
}
