package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/cafe_management";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void save(Product product) {
        String sql = "INSERT INTO product (id, name, category, price) VALUES (?,?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, product.getId());
            pstmt.setString(2, product.getName());
            pstmt.setString(3, product.getCategory());
            pstmt.setDouble(4, product.getPrice());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Method to delete the product from the database

    // Other methods...

    public static boolean productExists(String productId) {
        String sql = "SELECT COUNT(*) FROM product WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, productId);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void updateProductPrice(String productId, double newPrice) {
        String sql = "UPDATE product SET price = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, newPrice);
            pstmt.setString(2, productId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Product> getProductsByCategory(String selectedCategory) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE category = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, selectedCategory);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String id= rs.getString("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String category = rs.getString("category");
                Product product = new Product(id, name, category, price);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
public static void deleteProduct(String productId) {
        String sql = "DELETE FROM product WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, productId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Product> searchProducts(String keyword) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE name LIKE ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + keyword + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String category = rs.getString("category");
                Product product = new Product(id,name, category, price);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<Product> getAllRecords() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {                
                String id = rs.getString("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String category = rs.getString("category");
                Product product = new Product(id,name, category, price);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    
    public static String getProductIdByName(String productName) {
    String sql = "SELECT id FROM product WHERE name = ?";
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, productName);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getString("id");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

}
