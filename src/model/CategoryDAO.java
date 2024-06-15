package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/cafe_management";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private Connection connection;

    public CategoryDAO() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Category category) {
        String query = "INSERT INTO category (name) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, category.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Category> getAllRecords() {
        List<Category> categoryList = new ArrayList<>();
        String query = "SELECT * FROM category";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Category category = new Category(id, name);
                categoryList.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    public List<Product> getRecordsByCategory(String categoryName) {
    List<Product> productList = new ArrayList<>();
    String query = "SELECT * FROM products WHERE category = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, categoryName);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                // You need to provide a default category here or fetch it from the database
                Product product = new Product(name, "", price);
                productList.add(product);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return productList;
}


    public void delete(int id) {
        String query = "DELETE FROM category WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
