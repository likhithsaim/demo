package com.example.demo.model;

import java.sql.Date;

public class Reservation {
    private Integer reservationId;
    private Integer readerId;
    private Integer adminId;
    private Integer bookId;
    private Date reservationDate;
    private Date dueDate;
    private String status;
    private Date returnDate;
    private Double penalty;

    public Reservation(Integer reservationId, Integer readerId, Integer adminId, Integer bookId, Date reservationDate, Date dueDate, String status, Date returnDate, Double penalty) {
        this.reservationId = reservationId;
        this.readerId = readerId;
        this.adminId = adminId;
        this.bookId = bookId;
        this.reservationDate = reservationDate;
        this.dueDate = dueDate;
        this.status = status;
        this.returnDate = returnDate;
        this.penalty = penalty;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Double getPenalty() {
        return penalty;
    }

    public void setPenalty(Double penalty) {
        this.penalty = penalty;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "ReservationId=" + reservationId +
                ", ReaderId=" + readerId +
                ", adminId=" + adminId +
                ", bookId=" + bookId +
                ", reservationDate=" + reservationDate +
                ", dueDate=" + dueDate +
                ", status='" + status + '\'' +
                ", returnDate=" + returnDate +
                ", penalty=" + penalty +
                "}\n";
    }
}
