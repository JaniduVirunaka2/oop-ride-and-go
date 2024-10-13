package Vehicle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Database.DBConnect;

public class VehicleService {

    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    // Method to get all vehicles from the database
    public static List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "SELECT * FROM vehicles";  // Adjust table name as necessary
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int vehicleID = rs.getInt("vehicleID"); 
                String vehicleBrand = rs.getString("vehicleBrand"); 
                String vehicleModel = rs.getString("vehicleModel"); 
                String color = rs.getString("color"); 
                int seatNo = rs.getInt("seatNo"); 
                int milage = rs.getInt("milage"); 
                String category = rs.getString("category"); 
                String image = rs.getString("image"); 

                Vehicle vehicle = new Vehicle(vehicleID, vehicleBrand, vehicleModel, color, seatNo, milage, category, image);
                vehicles.add(vehicle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources (optional but recommended)
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return vehicles;
    }

    // Additional methods for insert, update, delete, if needed
}
