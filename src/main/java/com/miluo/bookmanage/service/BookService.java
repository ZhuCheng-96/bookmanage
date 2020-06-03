package com.miluo.bookmanage.service;

import com.miluo.bookmanage.pojo.Book;

import java.util.List;

public interface BookService {

    List<Book> selectByKeyword(String keyword);
}
