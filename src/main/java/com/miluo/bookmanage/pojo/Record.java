package com.miluo.bookmanage.pojo;

import java.util.Date;

public class Record {
    private Integer recordId;

    private Integer userId;

    private Integer bookId;

    private Date borrowDate;

    private Integer status;//0已还 1已借未还

    private Date returnDate;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Record(Integer recordId, Integer userId, Integer bookId, Integer status) {
        this.recordId = recordId;
        this.userId = userId;
        this.bookId = bookId;
        this.status = status;
    }

    public Record() {
    }
}