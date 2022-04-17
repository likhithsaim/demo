package com.example.demo.model;

public class Book {
    private Integer id;
    private Integer departmentId;
    private String title;
    private String subject;
    private String authorName;
    private String publishedYear;
    private String rackNumber;
    private Integer status;
    private Integer pageCount;

    public Book(Integer id, Integer departmentId, String title, String subject, String authorName, String publishedYear, String rackNumber, Integer status, Integer pageCount) {
        this.id = id;
        this.departmentId = departmentId;
        this.title = title;
        this.subject = subject;
        this.authorName = authorName;
        this.publishedYear = publishedYear;
        this.rackNumber = rackNumber;
        this.status = status;
        this.pageCount = pageCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(String publishedYear) {
        this.publishedYear = publishedYear;
    }

    public String getRackNumber() {
        return rackNumber;
    }

    public void setRackNumber(String rackNumber) {
        this.rackNumber = rackNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", departmentId=" + departmentId +
                ", title='" + title + '\'' +
                ", subject='" + subject + '\'' +
                ", authorName='" + authorName + '\'' +
                ", publishedYear='" + publishedYear + '\'' +
                ", rackNumber='" + rackNumber + '\'' +
                ", status=" + status +
                ", pageCount=" + pageCount +
                '}';
    }
}
