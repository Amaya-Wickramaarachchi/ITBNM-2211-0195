package model;

public class OrderItem {
    private String productName;
    private int quantity;
    private double price;
    private double total;

    public OrderItem(String productName, int quantity, double price, double total) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;        
        this.total = total;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}