package Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Database.DBConnect;

public class VehicleService {

	public static List<Vehicle> getAllVehicles() {
		List<Vehicle> vehicles = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM vehicle WHERE isAvailable = true"; 
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
				boolean isAvailable = rs.getBoolean("isAvailable");

				Vehicle vehicle = new Vehicle(vehicleID, vehicleBrand, vehicleModel, color, seatNo, milage, category,
						image, isAvailable);
				vehicles.add(vehicle);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close resources
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}

		return vehicles;
	}

	public static List<Vehicle> getVehiclesByCategory(String category) {
		List<Vehicle> vehicles = new ArrayList<>();

		try (Connection con = DBConnect.getConnection();
				PreparedStatement stmt = con
						.prepareStatement("SELECT * FROM vehicle WHERE category = ? AND isAvailable = true")) {

			stmt.setString(1, category);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int vehicleID = rs.getInt("vehicleID");
				String vehicleBrand = rs.getString("vehicleBrand");
				String vehicleModel = rs.getString("vehicleModel");
				String color = rs.getString("color");
				int seatNo = rs.getInt("seatNo");
				int milage = rs.getInt("milage");
				String cat = rs.getString("category");
				String image = rs.getString("image");
				boolean isAvailable = rs.getBoolean("isAvailable");

				Vehicle vehicle = new Vehicle(vehicleID, vehicleBrand, vehicleModel, color, seatNo, milage, category,
						image, isAvailable);
				vehicles.add(vehicle);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehicles;
	}

	public static boolean rentVehicle(int vehicleId) {
		boolean isAvailable = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBConnect.getConnection();
			String sql = "UPDATE vehicle SET isAvailable = false WHERE vehicleID = ?"; // Adjust your SQL query as needed
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vehicleId);

			int rowsUpdated = pstmt.executeUpdate();
			if (rowsUpdated > 0) {
				isAvailable = true; // Rental was successful
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close resources
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return isAvailable;
	}
}
