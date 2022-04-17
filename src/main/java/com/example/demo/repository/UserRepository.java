package com.example.demo.repository;

import com.example.demo.model.AdminUser;
import com.example.demo.model.Reader;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    static Connection connection = null;

    UserRepository() {
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

    public List<Reader> getUsers() {
        List<Reader> readers = new ArrayList<>();
        String sql = "select * from Readers";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Integer readerId = resultSet.getInt(1);
                Integer adminId = resultSet.getInt(2);
                String firstName = resultSet.getString(3);
                String lastName = resultSet.getString(4);
                String gender = resultSet.getString(5);
                String email = resultSet.getString(6);
                String address = resultSet.getString(7);
                Date date = resultSet.getDate(8);
                String password = resultSet.getString(9);
                Reader reader = new Reader(adminId, firstName, lastName, gender, readerId, email, address, date, password);
                readers.add(reader);
            }
            return readers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<AdminUser> getAdmins() {
        List<AdminUser> admins = new ArrayList<>();
        String sql = "select * from Administration";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Integer adminId = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String gender = resultSet.getString(4);
                String password = resultSet.getString(5);
                AdminUser adminUser = new AdminUser(adminId, firstName, lastName, gender, password);
                admins.add(adminUser);
            }
            return admins;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Reader> getUsersOfBook(Integer departmentId, String subject, String title) {
        List<Reader> readers = new ArrayList<>();
        String sql = "select * from readers reader join (select r.reader_id from reservation r join (select b.book_id from books b where b.Department_id='" + departmentId + "' and b.subject='" + subject + "' and b.title='" + title + "') book where r.status='Yet to return' and book.book_id=r.book_id) j where j.reader_id = reader.Reader_id";
        System.out.println(sql);
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Integer readerId = resultSet.getInt(1);
                Integer adminId = resultSet.getInt(2);
                String firstName = resultSet.getString(3);
                String lastName = resultSet.getString(4);
                String gender = resultSet.getString(5);
                String email = resultSet.getString(6);
                String address = resultSet.getString(7);
                Date date = resultSet.getDate(8);
                String password = resultSet.getString(9);
                Reader reader = new Reader(adminId, firstName, lastName, gender, readerId, email, address, date, password);
                readers.add(reader);
            }
            return readers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
