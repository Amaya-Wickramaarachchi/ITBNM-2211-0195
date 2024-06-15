package model;

public class Product {
    private String id;
    private String name;
    private String category;
    private double price;

    public Product() {
        // Default constructor
    }

    public Product(String id,String name, String category, double price) {
        this.id=id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    Product(String name, String category, double price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
}