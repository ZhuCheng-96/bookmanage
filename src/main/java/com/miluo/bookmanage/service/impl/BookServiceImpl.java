package com.miluo.bookmanage.service.impl;

import com.miluo.bookmanage.dao.BookMapper;
import com.miluo.bookmanage.pojo.Book;
import com.miluo.bookmanage.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl  implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> selectByKeyword(String keyword) {
        return bookMapper.selectByKeyword(keyword);
    }
}
