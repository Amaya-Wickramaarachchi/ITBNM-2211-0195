package model;

public class Order {
    private long id;
    private String customerName;
    private String customerAddress;

    public Order(long id, String customerName, String customerAddress) {
        this.id = id;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
    }

    public long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }
}
