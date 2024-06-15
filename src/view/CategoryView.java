/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CategoryController;
import model.Category;
import model.CategoryDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.KeyAdapter;
import java.util.List;



public class CategoryView extends javax.swing.JFrame {
  
    private DefaultTableModel tableModel;
    private CategoryDAO categoryDAO; // Add a field to hold the CategoryDAO instance

    
   public CategoryView(CategoryDAO categoryDAO) { // Pass CategoryDAO instance in constructor
       
        this.categoryDAO = categoryDAO; // Assign the passed CategoryDAO instance
         initComponents();
         btnSave.setEnabled(false);
        refreshTable();
        //new CategoryController(this, categoryDAO);}
   
   }

    public CategoryView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void validateField(){
        String category = txtName.getText();
        btnSave.setEnabled(!category.equals(""));
    }
    public void addCategoryListener(ActionListener listenForSaveButton) {
        btnSave.addActionListener(listenForSaveButton);
    }

     public void addDeleteCategoryListener(ActionListener listenForDeleteButton) {
        btnClear.addActionListener(listenForDeleteButton);
    }

    public void addClearListener(ActionListener listenForClearButton) {
        btnClear.addActionListener(listenForClearButton);
    }

    public void addExitListener(ActionListener listenForExitButton) {
        btnClear.addActionListener(listenForExitButton);
    }

    public void addTableClickListener(MouseAdapter listenForTableClick) {
        jTable.addMouseListener(listenForTableClick);
    }

    public void addCategoryKeyListener(KeyAdapter listenForKeyRelease) {
        txtName.addKeyListener(listenForKeyRelease);
    }

    public String getCategoryName() {
        return txtName.getText();
    }

    public void clearCategoryField() {
        txtName.setText("");
    }

    public void setSaveButtonEnabled(boolean enabled) {
        btnSave.setEnabled(enabled);
    }

    public JTable getTable() {
        return jTable;
    }

     public void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0); // Clear existing rows

        // Call getAllRecords using the categoryDAO instance
        List<Category> categories = categoryDAO.getAllRecords();
        for (Category category : categories) {
            model.addRow(new Object[]{category.getId(), category.getName()});
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(350, 155));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel1.setText("Category Management");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 250, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel2.setText("View Category");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, -1, -1));

        jTable.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Category"
            }
        ));
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 254, 252));

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel3.setText("*Click on row to Delete Category.");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel4.setText("Add New Category");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        txtName.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 157, 257, -1));

        btnSave.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        btnSave.setText("Add Category");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 140, -1));

        btnClear.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        btnClear.setText("Close");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/categorybg.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -7, 740, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
    
    
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
validateField();        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameKeyReleased

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
         
        refreshTable();
    }//GEN-LAST:event_formComponentShown
 
    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
    
    }//GEN-LAST:event_jTableMouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearActionPerformed
public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        CategoryDAO model = new CategoryDAO();
        CategoryView view = new CategoryView(model);
        new CategoryController(view, model);
        view.setVisible(true);
    });
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
