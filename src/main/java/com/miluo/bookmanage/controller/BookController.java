package com.miluo.bookmanage.controller;

import com.miluo.bookmanage.service.BookService;
import com.miluo.bookmanage.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 通过书名或作者名查找书籍
     * @param keyword
     * @return
     */
    @GetMapping("/book")
    public Result selectByKeyword(@RequestParam("keyword") String keyword){
        return Result.success(bookService.selectByKeyword(keyword));
    }

}
