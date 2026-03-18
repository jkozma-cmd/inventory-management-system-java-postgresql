package inventoryapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO {

    public void addProduct(Product product) {
        String sql = "INSERT INTO products (id, name, price, quantity) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, product.getId());
            pstmt.setString(2, product.getName());
            pstmt.setDouble(3, product.getPrice());
            pstmt.setInt(4, product.getQuantity());

            pstmt.executeUpdate();
            System.out.println("\nProduct added successfully.");

        } catch (SQLException e) {
            System.out.println("\nError adding product: " + e.getMessage());
        }
    }

    public boolean removeProduct(String id) {
        String sql = "DELETE FROM products WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            int rowsAffected = pstmt.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Error removing product: " + e.getMessage());
            return false;
        }
    }
    
    public ResultSet getProducts() {

    	String sql = "SELECT id, name, price, quantity FROM products ORDER BY id";

    	try {
    		Connection conn = DBConnection.getConnection();
    		PreparedStatement pstmt = conn.prepareStatement(sql);
    		return pstmt.executeQuery();

    	} catch (SQLException e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
}