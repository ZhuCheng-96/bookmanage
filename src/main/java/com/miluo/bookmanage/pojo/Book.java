package com.miluo.bookmanage.pojo;

public class Book {
    private Integer bookId;

    private String bookName;

    private String authorName;

    private Integer status;//0表示可借，1表示不可借

    public Book(Integer bookId, String bookName, String authorName, Integer status) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.status = status;
    }

    public Book(){}

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", status=" + status +
                '}';
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? null : authorName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}