package com.miluo.bookmanage.service.impl;

import com.miluo.bookmanage.dao.BookMapper;
import com.miluo.bookmanage.dao.RecordMapper;
import com.miluo.bookmanage.pojo.Book;
import com.miluo.bookmanage.pojo.Record;
import com.miluo.bookmanage.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Autowired
    private BookMapper bookMapper;

    @Override
    @Transactional
    public Integer borrowOne(Integer userId, Integer bookId) {
        //查询当前用户已借未归还的书籍数量，大于等于5则无法继续借阅

        Integer borrowCount = recordMapper.getBookCountByUserId(userId);
        if (borrowCount>=5){
            return 1;
        }
        //在进行借书动作前再次检查该本书的状态是否为可借
        Integer bookStatus = bookMapper.selectByPrimaryKey(bookId).getStatus();
        if (bookStatus!=0){
            return 2;
        }
        Record record = new Record();
        record.setUserId(userId);
        record.setBookId(bookId);
        record.setStatus(0);

        Book book = new Book();
        book.setBookId(bookId);
        book.setStatus(1);

        recordMapper.insert(record);
        return bookMapper.updateByPrimaryKeySelective(book);
    }
}
