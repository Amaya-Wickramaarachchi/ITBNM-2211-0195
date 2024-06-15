package controller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.CategoryView;
import view.HomeView;
import view.LoginView;
import view.ProductView;
import view.OrderView;

public class HomeController {
    private HomeView view;

    public HomeController(HomeView view) {
        this.view = view;
        this.view.getBtnExit().addActionListener(e -> System.exit(0));
        this.view.getBtnProduct().addActionListener(e -> openProductView());
        this.view.getBtnOrder().addActionListener(e -> {
            try {
                openOrderView();
            } catch (SQLException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.view.getBtnCategory().addActionListener(e -> openCategoryView());
        this.view.getBtnLogout().addActionListener(e -> logout());
    }

    private void openProductView() {
        new ProductView().setVisible(true);
    }

    private void openOrderView() throws SQLException {
        
        String email = view.getEmail();
     
    }

    private void openCategoryView() {
        new CategoryView().setVisible(true);
    }

    private void logout() {
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to Logout?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            view.setVisible(false);
            new LoginView().setVisible(true);
        }
    }

    public void start() {
        view.setVisible(true);
    }
}
