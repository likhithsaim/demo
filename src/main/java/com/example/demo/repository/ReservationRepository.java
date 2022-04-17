package com.example.demo.repository;

import com.example.demo.model.Reservation;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservationRepository {
    static Connection connection = null;

    ReservationRepository() {
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

    public List<Reservation> getReservations() {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "select * from Reservation";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Integer reservationId = resultSet.getInt(1);
                Integer readerId = resultSet.getInt(2);
                Integer adminId = resultSet.getInt(3);
                Integer bookId = resultSet.getInt(4);
                Date reservationDate = resultSet.getDate(5);
                Date dueDate = resultSet.getDate(6);
                String status = resultSet.getString(7);
                Date returnDate = resultSet.getDate(8);
                Double penalty = resultSet.getDouble(9);
                Reservation reservation = new Reservation(reservationId, readerId, adminId, bookId, reservationDate, dueDate, status, returnDate, penalty);
                reservations.add(reservation);
            }
            return reservations;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Reservation postReservation(Reservation reservation) {
        String sql = "insert into Reservation (Reader_ID,Admin_ID,Book_ID,Reservation_Date,Due_Date,Status,Return_Date,Penalty) values (" + reservation.getReaderId() + "," + reservation.getAdminId() + "," + reservation.getBookId() + ",DATE_FORMAT('" + reservation.getReservationDate() + "','%Y-%m-%d'),DATE_FORMAT('" + reservation.getDueDate() + "','%Y-%m-%d'),'" + reservation.getStatus() + "'," + reservation.getReturnDate() + "," + reservation.getPenalty() + ")";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            sql = "SELECT * FROM `Reservation` WHERE `Reservation_ID`= LAST_INSERT_ID()";
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            Integer reservationId = resultSet.getInt(1);
            Integer readerId = resultSet.getInt(2);
            Integer adminId = resultSet.getInt(3);
            Integer bookId = resultSet.getInt(4);
            Date reservationDate = resultSet.getDate(5);
            Date dueDate = resultSet.getDate(6);
            String status = resultSet.getString(7);
            Date returnDate = resultSet.getDate(8);
            Double penalty = resultSet.getDouble(9);
            reservation = new Reservation(reservationId, readerId, adminId, bookId, reservationDate, dueDate, status, returnDate, penalty);
            System.out.println(reservation);
            return reservation;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Reservation getReservationWithBookAndUser(Integer rId, Integer bId) {
        String sql = "select * from Reservation where Reader_ID = " + rId + " and Book_ID = " + bId + " and Status = 'Yet to return'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            Integer reservationId = resultSet.getInt(1);
            Integer readerId = resultSet.getInt(2);
            Integer adminId = resultSet.getInt(3);
            Integer bookId = resultSet.getInt(4);
            Date reservationDate = resultSet.getDate(5);
            Date dueDate = resultSet.getDate(6);
            String status = resultSet.getString(7);
            Date returnDate = resultSet.getDate(8);
            Double penalty = resultSet.getDouble(9);
            return new Reservation(reservationId, readerId, adminId, bookId, reservationDate, dueDate, status, returnDate, penalty);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Reservation patchReservation(Integer pen, Integer resId) {
        String sql = "UPDATE Reservation SET Status = 'Returned', Penalty = "+pen+", Return_Date = CURDATE() WHERE Reservation_ID = "+resId;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            sql = "SELECT * FROM Reservation WHERE Reservation_ID= "+resId;
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            Integer reservationId = resultSet.getInt(1);
            Integer readerId = resultSet.getInt(2);
            Integer adminId = resultSet.getInt(3);
            Integer bookId = resultSet.getInt(4);
            Date reservationDate = resultSet.getDate(5);
            Date dueDate = resultSet.getDate(6);
            String status = resultSet.getString(7);
            Date returnDate = resultSet.getDate(8);
            Double penalty = resultSet.getDouble(9);
            return new Reservation(reservationId, readerId, adminId, bookId, reservationDate, dueDate, status, returnDate, penalty);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
