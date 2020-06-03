package com.miluo.bookmanage.dao;

import com.miluo.bookmanage.pojo.Borrow;

public interface BorrowMapper {
    int deleteByPrimaryKey(Integer borrowId);

    int insert(Borrow record);

    int insertSelective(Borrow record);

    Borrow selectByPrimaryKey(Integer borrowId);

    int updateByPrimaryKeySelective(Borrow record);

    int updateByPrimaryKey(Borrow record);

    int getBookCountByStudentId(Integer studentId);
}