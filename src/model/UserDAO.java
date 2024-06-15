package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/cafe_management";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "";

    public void save(User user) {
        String sql = "INSERT INTO users (name, email, password, status) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getStatus());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

public User authenticateUser(String email, String password) {
    String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

    try (Connection conn = this.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, email);
        pstmt.setString(2, password);

        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setName(rs.getString("name"));
            return user;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
private boolean verifyPassword(String password, String hashedPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedInput = md.digest(password.getBytes());
            StringBuilder hexHash = new StringBuilder();
            for (byte b : hashedInput) {
                hexHash.append(String.format("%02x", b));
            }
            return hexHash.toString().equals(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }
}