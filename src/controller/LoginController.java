package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.User;
import model.UserDAO;
import view.HomeView;
import view.LoginView;

public class LoginController {

    private LoginView loginView;
    private UserDAO userDAO;

    public LoginController(LoginView loginView, UserDAO userDAO) {
        this.loginView = loginView;
        this.userDAO = userDAO;
        this.loginView.getBtnLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });
    }

    private void handleLogin() {
        String email = loginView.getTxtEmail().getText();
        String password = new String(loginView.getTxtPassword().getPassword());

        // Validate user input
        if (!validateInput(email, password)) {
            return;
        }

        // Authenticate user
        if (authenticateUser(email, password)) {
            JOptionPane.showMessageDialog(loginView, "Login successful", "Success", JOptionPane.INFORMATION_MESSAGE);
            // Proceed to the next step after successful login
            HomeView homeView = new HomeView();
            homeView.setVisible(true);
            loginView.dispose(); // Close the current login window
        } else {
            JOptionPane.showMessageDialog(loginView, "Invalid email or password", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validateInput(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(loginView, "Email and Password cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean authenticateUser(String email, String password) {
        // Use the UserDAO to authenticate the user
        User user = userDAO.authenticateUser(email, password);
        return user != null;
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                UserDAO userDAO = new UserDAO(); // Initialize UserDAO
                LoginView loginView = new LoginView();
                LoginController loginController = new LoginController(loginView, userDAO);
                loginView.setVisible(true);
            }
        });
    }

    public void start() {
        // Perform any necessary startup tasks
    }

}
