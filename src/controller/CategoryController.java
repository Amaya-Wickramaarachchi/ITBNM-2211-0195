package controller;

import model.Category;
import model.CategoryDAO;
import view.CategoryView;
import view.HomeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CategoryController {
    private CategoryView view;
    private CategoryDAO model;

    public CategoryController(CategoryView view, CategoryDAO model) {
        this.view = view;
        this.model = model;
        this.view.addCategoryListener(new CategoryListener());
        this.view.addDeleteCategoryListener(new DeleteCategoryListener());
        this.view.addClearListener(new ClearListener());
        this.view.addExitListener(new ExitListener());
        this.view.addTableClickListener(new TableClickListener());
        this.view.addCategoryKeyListener(new CategoryKeyListener());
    }

    class CategoryListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String categoryName = view.getCategoryName();
            Category category = new Category();
            category.setName(categoryName);
            model.save(category);
            view.refreshTable();
            view.clearCategoryField();
            view.setSaveButtonEnabled(false);
            JOptionPane.showMessageDialog(view, "Category saved successfully!");
        }
    }
class SaveCategoryListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String categoryName = view.getCategoryName();
            if (!categoryName.isEmpty()) {
                Category category = new Category(0, categoryName); // ID will be auto-incremented
                model.save(category);
                view.clearCategoryField();
                view.refreshTable();
            }
        }
    }
    class DeleteCategoryListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JTable table = view.getTable();
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                int id = (int) table.getValueAt(selectedRow, 0);
                int choice = JOptionPane.showConfirmDialog(view, "Do you really want to delete this category?", "Select", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    model.delete(id);
                    view.refreshTable();
                }
            } else {
                JOptionPane.showMessageDialog(view, "No category selected to delete.");
            }
        }
    }

    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.clearCategoryField();
            view.setSaveButtonEnabled(false);
        }
    }

    class ExitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int choice = JOptionPane.showConfirmDialog(null, "Do you really want to close?", "Select", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                view.dispose(); 
                HomeView homeView = new HomeView(); 
                homeView.setVisible(true);
            }
        }
    }

    class TableClickListener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 1) {
                JTable table = view.getTable();
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    int id = (int) table.getValueAt(selectedRow, 0);
                    int choice = JOptionPane.showConfirmDialog(null, "Do you really want to delete this category?", "Select", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        model.delete(id);
                        view.refreshTable();
                    }
                }
            }
        }
    }

    class CategoryKeyListener extends KeyAdapter {
        public void keyReleased(KeyEvent evt) {
            view.validateField();
        }
    }
}
