package model;

public class Category {
    private int id;
    private String name;

    // No-argument constructor
    public Category() {
    }

    // Constructor with id and name
    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Constructor with name
    public Category(String name) {
        this.name = name;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
