package Favorite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import Database.DBConnect;
import Vehicle.Vehicle;

public class FavoriteService {
	public static boolean addFavorite(int userId, int vehicleId) {
		try (Connection con = DBConnect.getConnection();
				PreparedStatement stmt = con
						.prepareStatement("INSERT INTO user_favorites (user_id, vehicle_id) VALUES (?, ?)")) {
			stmt.setInt(1, userId);
			stmt.setInt(2, vehicleId);
			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean removeFavorite(int userId, int vehicleId) {
		try (Connection con = DBConnect.getConnection();
				PreparedStatement stmt = con
						.prepareStatement("DELETE FROM user_favorites WHERE user_id = ? AND vehicle_id = ?")) {
			stmt.setInt(1, userId);
			stmt.setInt(2, vehicleId);
			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static List<Vehicle> getFavorites(int userId) {
		List<Vehicle> favorites = new ArrayList<>();
		// Implement logic to fetch favorite vehicles for the user
		// Use JOIN to fetch vehicle details based on vehicleId from the favorites table
		return favorites;
	}
}
