package controller;

import model.Category;
import model.CategoryDAO;
import model.Product;
import model.ProductDAO;
import view.ProductView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ProductController {
    private ProductView view;

    public ProductController(ProductView view) {
        this.view = view;
        this.view.addSaveListener(new SaveButtonListener());
        this.view.addClearListener(new ClearButtonListener());
        this.view.addExitListener(new ExitButtonListener());

        loadCategories();

        // Add the product table click listener
        this.view.addProductTableClickListener(new ProductTableClickListener());
    }

    private void loadCategories() {
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> categories = categoryDAO.getAllRecords();
        List<String> categoryNames = categories.stream()
                .map(Category::getName)
                .collect(Collectors.toList());
        view.setCategories(categoryNames);
    }

    class SaveButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String id = view.getProductId(); // Get the manually entered ID from the view
            String name = view.getProductName();
            String category = view.getCategory();

            // Validate that the ID is not empty
            if (id.isEmpty()) {
                view.showError("ID cannot be empty.");
                return;
            }

            try {
                double price = view.getPrice();
                Product product = new Product(id, name, category, price);
                
// Check if the product with the given ID already exists
                if (ProductDAO.productExists(id)) {
                    // Update the existing product's price
                    ProductDAO.updateProductPrice(id, price);
                    view.showMessage("Product price updated successfully!");
                } else {
                    // Save the new product
                    ProductDAO.save(product);
                    view.showMessage("Product saved successfully!");
                }
                
                view.clearFields();
                // Update the table immediately after saving the product
                view.populateProductTable();
            } catch (NumberFormatException ex) {
                view.showError("Invalid price. Please enter a valid number.");
            }
        }
    }

    class ClearButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.clearFields();
        }
    }

    class ExitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.exit();
        }
    }

    class ProductTableClickListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            int selectedRow = view.getProductTableSelectedRow();
            if (selectedRow != -1) {
                String productId = view.getSelectedProductIdFromTable(selectedRow);
                if (productId != null && !productId.isEmpty()) {
                    // Prompt user for confirmation
                    int option = view.showConfirmationMessage("Are you sure you want to delete this product?");
                    if (option == JOptionPane.YES_OPTION) {
                        // Delete the product from the database
                        ProductDAO.deleteProduct(productId);
                        // Update the table view
                        view.populateProductTable();
                    }
                }
            }
        }
    }
}
