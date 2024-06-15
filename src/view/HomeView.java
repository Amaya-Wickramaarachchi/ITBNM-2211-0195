package view;

import controller.CategoryController;
import javax.swing.*;
import model.CategoryDAO;
import controller.ProductController;
import controller.OrderController;
import model.OrderDAO;


public class HomeView extends JFrame {
   public String email;
   private OrderView orderView;
   private OrderController orderController; 
          
   public HomeView() {
        initComponents();
    }
    
    public HomeView(String email){
       this.email=email; 
        initComponents();
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        btnLogout = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnCategory = new javax.swing.JButton();
        btnOrder = new javax.swing.JButton();
        btnProduct = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 0, 51));
        setLocation(new java.awt.Point(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 410, 200, 30));

        btnExit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 470, 200, 30));

        btnCategory.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCategory.setText("Manage Category");
        btnCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoryActionPerformed(evt);
            }
        });
        getContentPane().add(btnCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, 200, 30));

        btnOrder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnOrder.setText("Place Order");
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });
        getContentPane().add(btnOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 235, 200, 30));

        btnProduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnProduct.setText("Manage Products");
        btnProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductActionPerformed(evt);
            }
        });
        getContentPane().add(btnProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, 200, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/bg1.png"))); // NOI18N
        jLabel1.setText("\\");
            getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 2000, 780));

            pack();
        }// </editor-fold>//GEN-END:initComponents

     public JButton getBtnLogout() {
        return btnLogout;
    }

    public JButton getBtnExit() {
        return btnExit;
    }

    public JButton getBtnCategory() {
        return btnCategory;
    }

    public JButton getBtnOrder() {
        return btnOrder;
    }

    public JButton getBtnProduct() {
        return btnProduct;
    }

    public String getEmail() {
        return email;
    }
    
   

    private void btnProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductActionPerformed
 ProductView productView = new ProductView();
        new ProductController(productView);
        productView.setVisible(true);
    }//GEN-LAST:event_btnProductActionPerformed

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
    if (orderView == null) {
            OrderDAO orderDAO = new OrderDAO();
            orderView = new OrderView(orderDAO);
            orderController = new OrderController(orderView, orderDAO);
        }
        orderView.setVisible(true);
    }//GEN-LAST:event_btnOrderActionPerformed

    private void btnCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoryActionPerformed
        CategoryDAO categoryDAO = new CategoryDAO();
        CategoryView categoryView = new CategoryView(categoryDAO);
        new CategoryController(categoryView, categoryDAO);
        categoryView.setVisible(true);
    }//GEN-LAST:event_btnCategoryActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
int a =JOptionPane.showConfirmDialog(null, "Do you really want to close?","select",JOptionPane.YES_NO_OPTION);
        if(a == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
    int a = JOptionPane.showConfirmDialog(null,"Do you really want to Loguot?","Select",JOptionPane.YES_NO_OPTION);
      if (a == JOptionPane.YES_OPTION) {
            
            setVisible(false);
            new LoginView().setVisible(true);
      }// TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutActionPerformed
    
    
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new HomeView().setVisible(true);
        });
    }

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCategory;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnProduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu3;
    // End of variables declaration//GEN-END:variables
}
