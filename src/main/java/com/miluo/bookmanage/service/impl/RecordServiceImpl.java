package com.miluo.bookmanage.service.impl;

import com.miluo.bookmanage.dao.BookMapper;
import com.miluo.bookmanage.dao.RecordMapper;
import com.miluo.bookmanage.exception.BusinessException;
import com.miluo.bookmanage.pojo.Book;
import com.miluo.bookmanage.pojo.Record;
import com.miluo.bookmanage.service.RecordService;
import com.miluo.bookmanage.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Autowired
    private BookMapper bookMapper;

    /**
     * 借一本书service
     * @param userId
     * @param bookId
     * @return
     */
    @Override
    @Transactional
    public Integer borrowOne(Integer userId, Integer bookId){
        //查询当前用户已借未归还的书籍数量，大于等于5则无法继续借阅
        Integer borrowCount = recordMapper.getBookCountByUserId(userId);
        if (borrowCount>=5){
            throw new BusinessException("Over borrowed!");
        }

        Book book = bookMapper.selectByPrimaryKey(bookId);
        //查询书籍是否存在
        if (book==null){
            throw new BusinessException("Book not exist!");
        }

        //在进行借书动作前再次检查该本书的状态是否为可借
        Integer bookStatus = book.getStatus();
        if (bookStatus!=0){
            throw new BusinessException("Book not available for borrowing!");
        }
        Record record = new Record();
        record.setUserId(userId);
        record.setBookId(bookId);
        record.setStatus(0);

        book = new Book();
        book.setBookId(bookId);
        book.setStatus(1);

        recordMapper.insert(record);
        int result = bookMapper.updateByPrimaryKeySelective(book);
        return 1;
    }

    /**
     * 还一本书service
     * @param userId
     * @param bookId
     * @return
     */
    @Override
    @Transactional
    public Integer returnOne(Integer userId, Integer bookId) {
        Book book = bookMapper.selectByPrimaryKey(bookId);
        //查询书籍是否存在,是否处于正常可还状态
        if (book==null){
            throw new BusinessException("Book not exist!");
        }
        if (book.getStatus()!=0){
            throw new BusinessException("Book not available for borrowing!");
        }

        return null;
    }


}
