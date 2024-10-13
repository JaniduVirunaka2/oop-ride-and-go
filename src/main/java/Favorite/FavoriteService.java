package Favorite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import Database.DBConnect;
import Vehicle.Vehicle;

public class FavoriteService {
    
    public static boolean addFavorite(int userId, int vehicleId) {
        boolean isAdded = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBConnect.getConnection();
            String sql = "INSERT INTO favorites (userId, vehicleId) VALUES (?, ?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.setInt(2, vehicleId);

            int rowsInserted = pstmt.executeUpdate();
            isAdded = (rowsInserted > 0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return isAdded;
    }

    public static boolean removeFavorite(int userId, int vehicleId) {
        boolean isRemoved = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBConnect.getConnection();
            String sql = "DELETE FROM favorites WHERE userId = ? AND vehicleId = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.setInt(2, vehicleId);

            int rowsDeleted = pstmt.executeUpdate();
            isRemoved = (rowsDeleted > 0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return isRemoved;
    }

    public static List<Vehicle> getFavorites(int userId) {
        List<Vehicle> favorites = new ArrayList<>();
        // Implement logic to fetch favorite vehicles for the user
        // Use JOIN to fetch vehicle details based on vehicleId from the favorites table
        return favorites;
    }
}
