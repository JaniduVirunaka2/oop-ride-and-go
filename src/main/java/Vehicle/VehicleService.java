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
			String sql = "SELECT * FROM vehicle"; // Make sure the table name is correct
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int vehicleID = rs.getInt("vehicleID"); // Adjust field names as per your database
				String vehicleBrand = rs.getString("vehicleBrand");
				String vehicleModel = rs.getString("vehicleModel");
				String color = rs.getString("color");
				int seatNo = rs.getInt("seatNo");
				int milage = rs.getInt("milage");
				String category = rs.getString("category");
				String image = rs.getString("image");

				Vehicle vehicle = new Vehicle(vehicleID, vehicleBrand, vehicleModel, color, seatNo, milage, category,
						image);
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
				PreparedStatement stmt = con.prepareStatement("SELECT * FROM vehicle WHERE category = ?")) {

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

				Vehicle vehicle = new Vehicle(vehicleID, vehicleBrand, vehicleModel, color, seatNo, milage, cat, image);
				vehicles.add(vehicle);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehicles;
	}
}
