package com.example.demo.model;

public class BookDto extends Book{
    private Integer userId;

    public BookDto(Integer id, Integer departmentId, String title, String subject, String authorName, String publishedYear, String rackNumber, Integer status, Integer pageCount, Integer userID) {
        super(id, departmentId, title, subject, authorName, publishedYear, rackNumber, status, pageCount);
        this.userId = userID;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "userId=" + userId +
                '}';
    }
}
