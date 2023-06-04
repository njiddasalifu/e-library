package com.books;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class books {
    // Different attributes of a book
    int bookID;
    String ISBN;
    String title;
    String author;
    Connection connection;

    public books() {
        // Create a connection to the database
        try {
            String url = "jdbc:mysql://localhost:3306/books";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create() {
        try {
            String query = "INSERT INTO books (ISBN, Title, Author) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, ISBN);
            statement.setString(2, title);
            statement.setString(3, author);
            statement.executeUpdate();
            System.out.println("Book created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getByID(int bookID) {
        try {
            String query = "SELECT * FROM books WHERE bookID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, bookID);
            ResultSet resultSet = statement.executeQuery();

            // Process the result set and display the book information
            while (resultSet.next()) {
                int id = resultSet.getInt("bookID");
                String isbn = resultSet.getString("ISBN");
                String title = resultSet.getString("Title");
                String author = resultSet.getString("Author");

                System.out.println("Book ID: " + id);
                System.out.println("ISBN: " + isbn);
                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getByTitle(String title) {
        try {
            String query = "SELECT * FROM books WHERE Title LIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + title + "%");
            ResultSet resultSet = statement.executeQuery();

            // Process the result set and display the book information
            while (resultSet.next()) {
                int id = resultSet.getInt("bookID");
                String isbn = resultSet.getString("ISBN");
                String Title = resultSet.getString("Title");
                String author = resultSet.getString("Author");

                System.out.println("Book ID: " + id);
                System.out.println("ISBN: " + isbn);
                System.out.println("Title: " + Title);
                System.out.println("Author: " + author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getByAuthor(String author) {
        try {
            String query = "SELECT * FROM books WHERE Author LIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + author + "%");
            ResultSet resultSet = statement.executeQuery();

            // Process the result set and display the book information
            while (resultSet.next()) {
                int id = resultSet.getInt("bookID");
                String isbn = resultSet.getString("ISBN");
                String title = resultSet.getString("Title");
                String Author = resultSet.getString("Author");

                System.out.println("Book ID: " + id);
                System.out.println("ISBN: " + isbn);
                System.out.println("Title: " + title);
                System.out.println("Author: " + Author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
