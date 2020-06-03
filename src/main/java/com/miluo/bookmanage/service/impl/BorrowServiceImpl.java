package com.miluo.bookmanage.service.impl;

import com.miluo.bookmanage.dao.BookMapper;
import com.miluo.bookmanage.dao.BorrowMapper;
import com.miluo.bookmanage.pojo.Book;
import com.miluo.bookmanage.pojo.Borrow;
import com.miluo.bookmanage.service.BorrowService;
import com.miluo.bookmanage.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowMapper borrowMapper;

    @Autowired
    private BookMapper bookMapper;

    @Override
    @Transactional
    public Integer borrowOne(Integer userId, Integer bookId) {
        //查询当前用户已借未归还的书籍数量，大于等于5则无法继续借阅

        Integer borrowCount = borrowMapper.getBookCountByStudentId(userId);
        if (borrowCount>=5){
            return 1;
        }
        //在进行借书动作前再次检查该本书的状态是否为可借
        Integer bookStatus = bookMapper.selectByPrimaryKey(bookId).getStatus();
        if (bookStatus!=0){
            return 2;
        }
        Borrow borrow = new Borrow();
        borrow.setStudentId(userId);
        borrow.setBookId(bookId);
        borrow.setStatus(0);

        Book book = new Book();
        book.setBookId(bookId);
        book.setStatus(1);

        borrowMapper.insert(borrow);
        return bookMapper.updateByPrimaryKeySelective(book);
    }
}
