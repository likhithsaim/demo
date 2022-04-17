package com.example.demo.repository;

import com.example.demo.model.Book;
import com.example.demo.model.BookDto;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    static Connection connection = null;

    BookRepository() {
        connect();
    }

    public static void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUrl = "jdbc:mysql://127.0.0.1:3306/library?autoReconnect=true&useSSL=false";
            connection = DriverManager.getConnection(dbUrl, "root", "12345678");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "select * from Books";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Integer bookId = resultSet.getInt(1);
                Integer departmentId = resultSet.getInt(2);
                String title = resultSet.getString(3);
                String subject = resultSet.getString(4);
                String authorName = resultSet.getString(5);
                String publishedYear = resultSet.getString(6);
                String rackNo = resultSet.getString(7);
                Integer status = resultSet.getInt(8);
                Integer pageCount = resultSet.getInt(9);
                Book book = new Book(bookId, departmentId, title, subject, authorName, publishedYear, rackNo, status, pageCount);
                books.add(book);
            }
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<BookDto> getBooksForUi() {
        List<BookDto> booksForUi = new ArrayList<>();
        String sql = "select b.*, r.Reader_ID from Books b left outer join (select * from Reservation where status = 'Yet to return') r on b.Book_ID = r.Book_ID";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
             for(int i=1;i<resultSet.getMetaData().getColumnCount();i++) {
                 System.out.println(resultSet.getMetaData().getColumnName(i));
             }
            while (resultSet.next()) {
                Integer bookId = resultSet.getInt(1);
                Integer departmentId = resultSet.getInt(2);
                String title = resultSet.getString(3);
                String subject = resultSet.getString(4);
                String authorName = resultSet.getString(5);
                String publishedYear = resultSet.getString(6);
                String rackNo = resultSet.getString(7);
                Integer status = resultSet.getInt(8);
                Integer pageCount = resultSet.getInt(9);
                Integer userId = resultSet.getInt(10);
                BookDto bookDto = new BookDto(bookId, departmentId, title, subject, authorName, publishedYear, rackNo, status, pageCount, userId);
                booksForUi.add(bookDto);
            }
            return booksForUi;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
