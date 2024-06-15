package view;

import controller.ProductController;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.Category;
import model.CategoryDAO;
import model.Product;
import model.ProductDAO;

public class ProductView extends javax.swing.JFrame {
    //private JTable productTable;
    private DefaultTableModel productTableModel;
    public String getProductId;
    
    
    public ProductView() {
        initComponents();
        populateProductTable();
        populateCategoryComboBox();
        //new ProductController(this);
        
        // Add the list selection listener here
   /* productTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent event) {
            if (!event.getValueIsAdjusting()) {
                int selectedRow = productTable.getSelectedRow();
                if (selectedRow != -1) {
                    // Retrieve the product ID from the selected row
                    String productId = productTable.getValueAt(selectedRow, 0).toString(); // Assuming ID is in the first column

                    // Prompt the user for confirmation
                    int option = JOptionPane.showConfirmDialog(ProductView.this, "Are you sure you want to delete this product?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        // Delete the product from the database
                        deleteProduct(productId);

                        // Update the table after deletion
                        populateProductTable();
                    }
                }
            }
        }
    });*/
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblCategory = new javax.swing.JLabel();
        boxCategory = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPID = new javax.swing.JTextField();
        scrollPane = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Product Management");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, -1, -1));

        lblName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblName.setText("Name:");
        getContentPane().add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, -1));

        txtName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 290, -1));

        lblCategory.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCategory.setText("Category:");
        getContentPane().add(lblCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, -1, -1));

        boxCategory.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        boxCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxCategoryActionPerformed(evt);
            }
        });
        getContentPane().add(boxCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 290, -1));

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, -1, -1));

        btnClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 360, -1, -1));

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/close.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 0, 30, -1));

        lblPrice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPrice.setText("Price:");
        getContentPane().add(lblPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 60, -1));

        txtPrice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });
        getContentPane().add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 290, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Product ID:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, -1, -1));

        txtPID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtPID, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 290, -1));

        productTable.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        productTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Name", "Category", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scrollPane.setViewportView(productTable);

        getContentPane().add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(794, 129, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("*Click on row to delete products.");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 570, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/bg2.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2000, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void populateProductTable() {
    ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.getAllRecords();
        DefaultTableModel productTableModel = (DefaultTableModel) productTable.getModel();
        productTableModel.setRowCount(0);
        for (Product product : products) {
            Object[] rowData = {product.getId(), product.getName(), product.getCategory(), product.getPrice()};
            productTableModel.addRow(rowData);
        }
}

    private void populateCategoryComboBox() {
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> categories = categoryDAO.getAllRecords();

        for (Category category : categories) {
            boxCategory.addItem(category.getName());
        }
    }
    
    
 public String getProductId() {
        return txtPID.getText();
    }

public String getProductName() {
        return txtName.getText();
    }

public String getCategory() {
        return (String) boxCategory.getSelectedItem();
    }

public double getPrice() throws NumberFormatException {
        String priceText = txtPrice.getText();
        if (priceText.isEmpty()) {
            throw new NumberFormatException("Price field is empty");
        }
        try {
            return Double.parseDouble(priceText);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid price format");
        }
    }

public void setPrice(double price) {
        txtPrice.setText(String.format("%.2f", price));
    }

    public void clearFields()
    {
        txtPID.setText("");
        txtName.setText("");
        txtPrice.setText("");
        boxCategory.setSelectedIndex(0);
    }
public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
public void exit() {
        int a = JOptionPane.showConfirmDialog(this, "Do you really want to close?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            new HomeView().setVisible(true);
        }
    }

   public void addSaveListener(ActionListener listener) {
        btnSave.addActionListener(listener);
    }

    public void addClearListener(ActionListener listener) {
        btnClear.addActionListener(listener);
    }

    public void addExitListener(ActionListener listener) {
        btnExit.addActionListener(listener);
    }

    public void setCategories(List<String> categories) {
        boxCategory.removeAllItems();
        for (String category : categories) {
            boxCategory.addItem(category);
        }
    }
    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
 
// Inside your ProductView class constructor or initialization method


// Method to delete the product from the database
// Method to delete the product from the database
private void deleteProduct(String productId) {
    // Create an instance of ProductDAO
    ProductDAO productDAO = new ProductDAO();
    
    // Call the deleteProduct method on the instance
    productDAO.deleteProduct(productId);
}


public int getProductTableSelectedRow() {
    return productTable.getSelectedRow();
}

public String getSelectedProductIdFromTable(int selectedRow) {
    if (selectedRow != -1) {
        return productTable.getValueAt(selectedRow, 0).toString(); // Assuming ID is in the first column
    }
    return null;
}

public int showConfirmationMessage(String message) {
    return JOptionPane.showConfirmDialog(this, message, "Confirm Deletion", JOptionPane.YES_NO_OPTION);
}

public void addProductTableClickListener(ListSelectionListener listener) {
        productTable.getSelectionModel().addListSelectionListener(listener);
    }

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
      clearFields();// TODO add your handling code here:
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
       
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
       
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
   exit();// TODO add your handling code here:
    }//GEN-LAST:event_btnExitActionPerformed

    private void boxCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxCategoryActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed
 public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ProductView().setVisible(true); // Ensure visibility of the view
            }
        });
    } //</editor-fold>

        /* Create and display the form */

   
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxCategory;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JTable productTable;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPID;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables

    

}
