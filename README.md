# Cafe Management System

## Overview

The **Cafe Management System** is a Java-based application designed to streamline the operations of a cafe. This application follows the Model-View-Controller (MVC) architecture, ensuring a clean separation of concerns and enhancing the maintainability of the code. The system allows users to manage product inventory, categories, and facilitates smooth operations through an intuitive graphical user interface (GUI).

## Features

### Product Management
- **Add New Products:** Easily add new products to the inventory by specifying the product ID, name, category, and price.
- **Update Product Details:** Modify existing product details such as price and category.
- **Delete Products:** Remove products from the inventory with a simple confirmation process.
- **View Products:** Display a comprehensive list of all products, including their ID, name, category, and price.

### Category Management
- **Load Categories:** Automatically load and display all product categories from the database in a dropdown list for easy selection during product addition or update.
- **Manage Categories:** Add new categories and update existing ones to keep the inventory organized.

### User Interface
- **Interactive GUI:** A user-friendly interface built with Java Swing, providing a seamless experience for cafe staff.
- **Form Validation:** Ensures data integrity by validating inputs, such as non-empty product IDs and correctly formatted prices.
- **Confirmation Dialogs:** Provides confirmation prompts for critical actions like deleting products to prevent accidental data loss.

## Technologies Used

- **Java:** The core programming language used for development.
- **Swing:** For creating the graphical user interface.
- **MVC Architecture:** To separate the business logic, data access, and user interface.
- **DAO Pattern:** To handle data access operations, ensuring a clear separation between the application logic and the database.

## Project Structure

### Model
- **Product:** Represents a product entity with attributes such as ID, name, category, and price.
- **Category:** Represents a category entity with attributes like ID and name.
- **ProductDAO:** Handles CRUD operations for products in the database.
- **CategoryDAO:** Handles CRUD operations for categories in the database.

### View
- **ProductView:** The main GUI for the cafe management system, including forms for adding/editing products and a table for displaying product details.

### Controller
- **ProductController:** Manages the interactions between the view and the model. It processes user actions from the view, updates the model, and refreshes the view as necessary.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.
