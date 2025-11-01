📦 Simple Inventory Management System (Core Java & JDBC)

This project is a console-based application designed to manage the stock of products in a small inventory. It serves as a practical demonstration and revision tool for fundamental concepts in Core Java and Java Database Connectivity (JDBC).

✨ Features

The system implements the full CRUD (Create, Read, Update, Delete) functionality for product records:

Add New Product (Create): Insert a new product record (name, quantity, price) into the database.

View All Products (Read): Retrieve and display a list of all products currently in stock.

Update Stock (Update): Modify the quantity of an existing product based on its unique ID.

Remove Product (Delete): Permanently delete a product record from the inventory.

Robust Exception Handling: Implements try-catch-finally for connection management and graceful error reporting for database failures (SQLException).

🛠️ Technology Stack

Technology

Purpose

Language

Core Java (JDK 11+)

Database

MySQL / PostgreSQL (or similar RDBMS)

Connectivity

JDBC (Java Database Connectivity)

Pattern

Data Access Object (DAO) Pattern

📐 Project Structure & Separation of Concerns

The application follows the DAO pattern to ensure code modularity and maintainability:

Product.java: The Model (POJO). Holds product data (id, name, quantity, price).

DBUtil.java: The Utility. Handles all database connection boilerplate (URL, credentials, getConnection(), closeResources()).

ProductDAO.java: The Data Access Object. Contains all the SQL logic (INSERT, SELECT, UPDATE, DELETE) and uses DBUtil to perform operations.

InventoryApp.java: The Main Application. Provides the user interface (menu) and handles user input/output, calling methods in ProductDAO.

⚙️ Setup Instructions

1. Database Setup

You must create the necessary table in your database (e.g., MySQL):

CREATE DATABASE inventory_db;

USE inventory_db;

CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    quantity INT NOT NULL DEFAULT 0,
    price DECIMAL(10, 2) NOT NULL
);



2. Java Configuration

JDBC Driver: Download the appropriate JDBC Connector JAR file for your database (e.g., MySQL Connector/J).

Classpath: Add the JDBC Connector JAR file to the build path/classpath of your Java project.

Update Credentials: Open DBUtil.java and update the following configuration constants to match your database environment:

private static final String DB_URL = "jdbc:mysql://localhost:3306/inventory_db";
private static final String USER = "root";          // <-- YOUR USERNAME
private static final String PASS = "your_password"; // <-- YOUR PASSWORD



🚀 How to Run

Compile all Java files (Product.java, DBUtil.java, ProductDAO.java, InventoryApp.java).

Run the main class: InventoryApp.java.

The console will display the main menu, allowing you to choose operations like adding a product, viewing inventory, or updating stock.

▶️ Video Demonstration

Check out this short video demonstration to see the Inventory Management System in action!

Note: The full source code can be found at: https://github.com/sinharitun/Inventory-Management.git. Please replace the placeholder link above with the actual URL of your video when you create one.
