/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.OrderController;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Category;
import model.CategoryDAO;
import model.Product;
import model.ProductDAO;
import model.OrderDAO;

/**
 *
 * @author DELL
 */
public class OrderView extends javax.swing.JFrame {
private double gTotal = 0.0;
private OrderController controller;
private OrderDAO orderDAO;
   
    public OrderView(OrderDAO orderDAO) {
        initComponents();
        populateCategoryBox();
        setupCartTableListener();
        this.orderDAO=orderDAO;
        controller = new OrderController(this, orderDAO);
          
    
    }

   
      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boxCategory = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProducts = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        spinQuantity = new javax.swing.JSpinner();
        btnCart = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCart = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lblGtotal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnOrder = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boxCategory.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        boxCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxCategoryActionPerformed(evt);
            }
        });
        getContentPane().add(boxCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 168, 300, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Customer Name:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 132, -1, -1));

        txtName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 168, 265, -1));

        txtAddress.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 256, 265, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Address:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 221, -1, -1));

        jScrollPane1.setFocusTraversalPolicyProvider(true);

        tableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Price"
            }
        ));
        jScrollPane1.setViewportView(tableProducts);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 221, 300, 378));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Quantity:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 130, -1, -1));

        spinQuantity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(spinQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 170, 125, -1));

        btnCart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCart.setText("Add to Cart");
        btnCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCartActionPerformed(evt);
            }
        });
        getContentPane().add(btnCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1167, 167, -1, -1));

        jScrollPane2.setFocusTraversalPolicyProvider(true);

        tableCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Price", "Quantity", "Total"
            }
        ));
        jScrollPane2.setViewportView(tableCart);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 221, 400, 378));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Grand Total:");
        jLabel3.setFocusTraversalPolicyProvider(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 650, -1, -1));

        lblGtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblGtotal.setForeground(new java.awt.Color(255, 0, 0));
        lblGtotal.setText("00.00");
        lblGtotal.setFocusTraversalPolicyProvider(true);
        getContentPane().add(lblGtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 650, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Select Category:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 132, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("* Click on the Product to remove from Cart.");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 610, -1, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Order Management");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 66, -1, -1));

        btnOrder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnOrder.setText("Palce Order");
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });
        getContentPane().add(btnOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 660, 132, -1));

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/close.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 0, 30, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/bg2.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    private void populateCategoryBox() {
    CategoryDAO categoryDAO = new CategoryDAO();
    try {
        List<Category> categories = categoryDAO.getAllRecords();
        for (Category category : categories) {
            boxCategory.addItem(category.getName());
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Failed to load categories: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    public JButton getBtnOrder() {
    return btnOrder; // Assuming btnOrder is a JButton instance
}


    public JTextField getTxtName() {
        return txtName;
    }

    public JTextField getTxtAddress() {
        return txtAddress;
    }

    public JTable getTableProducts() {
        return tableProducts;
    }

    public JSpinner getSpinQuantity() {
        return spinQuantity;
    }

    public JButton getBtnCart() {
        return btnCart;
    }
    
    public void setCategories(List<String> categoryNames) {
    boxCategory.removeAllItems(); // Clear existing items
    for (String categoryName : categoryNames) {
        boxCategory.addItem(categoryName); // Add new category names
    }
}

    public JComboBox<String> getCategoryBox() {
        return boxCategory;
    }
    
    public JTable getTableCart() {
        return tableCart;
    }
    
    public void populateTable(List<Product> products) {
        DefaultTableModel model = (DefaultTableModel) tableProducts.getModel();
        model.setRowCount(0); // Clear existing rows
        for (Product product : products) {
            model.addRow(new Object[]{product.getName(), product.getPrice()});
        }
    }

  public void addToCart(String productName, int quantity, double price, double total) {
    DefaultTableModel model = (DefaultTableModel) tableCart.getModel();
    boolean itemExists = false;
    
    for (int i = 0; i < model.getRowCount(); i++) {
        if (model.getValueAt(i, 0).equals(productName)) {
            int existingQuantity = (int) model.getValueAt(i, 2);
            int newQuantity = existingQuantity + quantity;
            double newTotal = price * newQuantity;
            model.setValueAt(newQuantity, i, 2);
            model.setValueAt(newTotal, i, 3);
            itemExists = true;
            break;
        }
    }
    
    if (!itemExists) {
        model.addRow(new Object[]{productName, price, quantity, total});
    }
}


   public void updateGrandTotal(double total) {
        gTotal += total;
        lblGtotal.setText(String.format("%.2f", gTotal));
    }
    
    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void boxCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxCategoryActionPerformed
        String selectedCategory = (String) boxCategory.getSelectedItem();
        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.getProductsByCategory(selectedCategory);
        populateTable(products);
    
    }//GEN-LAST:event_boxCategoryActionPerformed

    private void btnCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCartActionPerformed
     int selectedRow = tableProducts.getSelectedRow();
    if (selectedRow != -1) {
        DefaultTableModel productTableModel = (DefaultTableModel) tableProducts.getModel();
        String productName = (String) productTableModel.getValueAt(selectedRow, 0);
        double price = (double) productTableModel.getValueAt(selectedRow, 1);
        int quantity = (int) spinQuantity.getValue();

        double total = price * quantity;

        // Add to cart and update grand total
        addToCart(productName, quantity, price, total);
        updateGrandTotal(total);
    } else {
        JOptionPane.showMessageDialog(this, "Please select a product to add to cart.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnCartActionPerformed

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
HomeView homeView = new HomeView();
        homeView.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnOrderActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
      System.exit(0);   // TODO add your handling code here:
    }//GEN-LAST:event_btnExitActionPerformed
  
   private void populateTableWithProducts(String category) {
        
        ProductDAO productDAO = new ProductDAO(); 
        List<Product> products = productDAO.getProductsByCategory(category);

        DefaultTableModel model = (DefaultTableModel) tableProducts.getModel();
        model.setRowCount(0); // Clear existing rows

        for (Product product : products) {
            model.addRow(new Object[]{product.getName(), product.getPrice()});
        }
    }

   private void setupCartTableListener() {
    tableCart.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int selectedRow = tableCart.getSelectedRow();
            if (selectedRow != -1) {
                DefaultTableModel model = (DefaultTableModel) tableCart.getModel();
                Double value = (Double) model.getValueAt(selectedRow, 3);
                gTotal -= value;
                lblGtotal.setText(String.valueOf(gTotal));
                model.removeRow(selectedRow);
            }
        }
    });
}


 public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderView(new OrderDAO()).setVisible(true);
            }
        });
    }


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxCategory;
    private javax.swing.JButton btnCart;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblGtotal;
    private javax.swing.JSpinner spinQuantity;
    private javax.swing.JTable tableCart;
    private javax.swing.JTable tableProducts;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

   public void clearView() {
        // Implement the method with the appropriate functionality
        txtName.setText("");
        txtAddress.setText("");
        DefaultTableModel cartModel = (DefaultTableModel) tableCart.getModel();
        cartModel.setRowCount(0);
        lblGtotal.setText("0.0");
   }
}