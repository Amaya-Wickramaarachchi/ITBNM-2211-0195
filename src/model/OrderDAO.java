package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class OrderDAO {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/cafe_management";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "";

    public void saveOrder(String customerName, String customerAddress, List<OrderItem> orderItems) {
        String insertOrderQuery = "INSERT INTO orders (customer_name, customer_address, total_amount, order_date) VALUES (?, ?, ?, ?)";
        String insertOrderItemQuery = "INSERT INTO order_item (name, price, quantity, total) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement orderStatement = null;
        PreparedStatement orderItemStatement = null;

        try {
            conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            conn.setAutoCommit(false);

            // Calculate total amount
            double totalAmount = orderItems.stream().mapToDouble(OrderItem::getTotal).sum();
            LocalDate orderDate = LocalDate.now();

            orderStatement = conn.prepareStatement(insertOrderQuery, Statement.RETURN_GENERATED_KEYS);
            orderStatement.setString(1, customerName);
            orderStatement.setString(2, customerAddress);
            orderStatement.setDouble(3, totalAmount);
            orderStatement.setDate(4, java.sql.Date.valueOf(orderDate));
            orderStatement.executeUpdate();

            ResultSet generatedKeys = orderStatement.getGeneratedKeys();
            int orderId = -1;
            if (generatedKeys.next()) {
                orderId = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Creating order failed, no ID obtained.");
            }

            orderItemStatement = conn.prepareStatement(insertOrderItemQuery);
            for (OrderItem item : orderItems) {
                orderItemStatement.setString(1, item.getProductName());
                orderItemStatement.setDouble(2, item.getPrice());
                orderItemStatement.setInt(3, item.getQuantity());
                orderItemStatement.setDouble(4, item.getTotal());
                orderItemStatement.addBatch();
            }

            orderItemStatement.executeBatch();
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            closeResources(conn, orderStatement, orderItemStatement);
        }
    }

    private boolean isValidProductId(Connection conn, String productId) throws SQLException {
        String query = "SELECT COUNT(*) FROM product WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, productId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    private void closeResources(Connection conn, PreparedStatement... statements) {
        for (PreparedStatement stmt : statements) {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Product> getProductsByCategory(String category) {
        List<Product> products = new ArrayList<>();
        String query = "SELECT id, name, price FROM product WHERE category = ?";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, category);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getString("id")); // Assuming the product ID column is named "id"
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getDouble("price"));
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
