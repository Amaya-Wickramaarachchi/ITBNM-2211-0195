package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.Category;
import model.CategoryDAO;
import model.OrderDAO;
import model.OrderItem;
import model.Product;
import view.OrderView;


public class OrderController {

    private OrderView orderView;
    private OrderDAO orderDAO;

    public OrderController(OrderView view, OrderDAO orderDAO) {
        this.orderView = view;
        this.orderDAO = orderDAO; // Use the provided OrderDAO instance

        loadCategories();

        this.orderView.getCategoryBox().addActionListener(e -> {
            String selectedCategory = (String) orderView.getCategoryBox().getSelectedItem();
            if (selectedCategory != null) {
                populateTableWithProducts(selectedCategory);
            }
        });

        this.orderView.getBtnCart().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToCart();
            }
        });

        this.orderView.getTableCart().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = orderView.getTableCart().getSelectedRow();
                    if (selectedRow != -1) {
                        removeFromCart(selectedRow);
                    }
                }
            }
        });
      
        this.orderView.getBtnOrder().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placeOrder();
            }
        });
    }

    private void placeOrder() {
    // Gather necessary information from the view
    String customerName = orderView.getTxtName().getText().trim();
    String customerAddress = orderView.getTxtAddress().getText().trim();
    List<OrderItem> orderItems = getOrderItemsFromView();

    // Validate if all required fields are filled
    if (customerName.isEmpty() || customerAddress.isEmpty() || orderItems.isEmpty()) {
        JOptionPane.showMessageDialog(orderView, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Use OrderDAO methods to insert order and order details into the database
    orderDAO.saveOrder(customerName, customerAddress, orderItems);

    // Display a success message if the order is placed successfully
    JOptionPane.showMessageDialog(orderView, "Order placed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

    // Clear the view after successful order placement
    orderView.clearView();
}

   
   private List<OrderItem> getOrderItemsFromView() {
    List<OrderItem> orderItems = new ArrayList<>();
    DefaultTableModel cartModel = (DefaultTableModel) orderView.getTableCart().getModel();
    for (int i = 0; i < cartModel.getRowCount(); i++) {
        String productName = (String) cartModel.getValueAt(i, 0);
        double price = (double) cartModel.getValueAt(i, 1);
        int quantity = (int) cartModel.getValueAt(i, 2);
        double total = (double) cartModel.getValueAt(i, 3);
        OrderItem orderItem = new OrderItem(productName, quantity, price, total);
        orderItems.add(orderItem);
    }
    return orderItems;
}


    private void loadCategories() {
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> categories = categoryDAO.getAllRecords();
        List<String> categoryNames = categories.stream()
                .map(Category::getName)
                .collect(Collectors.toList());
        orderView.setCategories(categoryNames);
    }

    private void populateTableWithProducts(String category) {
        List<Product> products = orderDAO.getProductsByCategory(category);
        orderView.populateTable(products);
    }

   private void addToCart() {
        int selectedRow = orderView.getTableProducts().getSelectedRow();
        if (selectedRow != -1) {
            String productName = (String) orderView.getTableProducts().getValueAt(selectedRow, 0);

            // Convert price to double
            Object priceObj = orderView.getTableProducts().getValueAt(selectedRow, 1);
            double price = 0.0;
            if (priceObj instanceof Double) {
                price = (Double) priceObj;
            } else if (priceObj instanceof String) {
                try {
                    price = Double.parseDouble((String) priceObj);
                } catch (NumberFormatException e) {
                    // Handle error: Invalid price format
                    System.err.println("Invalid price format: " + priceObj);
                    return;
                }
            }

            int quantity = (int) orderView.getSpinQuantity().getValue();
            double total = price * quantity;

            // Check if the item is already in the cart
            DefaultTableModel cartModel = (DefaultTableModel) orderView.getTableCart().getModel();
            for (int i = 0; i < cartModel.getRowCount(); i++) {
                if (productName.equals(cartModel.getValueAt(i, 0))) {
                    int existingQuantity = (int) cartModel.getValueAt(i, 1);
                    cartModel.setValueAt(existingQuantity + quantity, i, 1);
                    cartModel.setValueAt(price * (existingQuantity + quantity), i, 3);
                    orderView.updateGrandTotal(total);
                    return;
                }
            }

            // If item is not in the cart, add a new row
            orderView.addToCart(productName, quantity, price, total);
            orderView.updateGrandTotal(total);
        }
    }

    private void removeFromCart(int selectedRow) {
        DefaultTableModel cartModel = (DefaultTableModel) orderView.getTableCart().getModel();
        double total = (double) cartModel.getValueAt(selectedRow, 3);
        cartModel.removeRow(selectedRow);
        orderView.updateGrandTotal(-total);
    }
}
