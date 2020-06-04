package com.miluo.bookmanage.controller;

import com.miluo.bookmanage.dao.BookMapper;
import com.miluo.bookmanage.service.BookService;
import com.miluo.bookmanage.service.RecordService;
import com.miluo.bookmanage.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class RecordController {

    @Autowired
    private BookService bookService;

    @Autowired
    private RecordService recordService;

    @Autowired
    private BookMapper bookMapper;

    /**
     * 借阅一本书籍
     * @param bookId
     * @return
     */
    @PostMapping("/book")
    public Result borrowOne(@RequestParam("borrow_book_id") String bookId){
        Integer bookIdInt = Integer.parseInt(bookId);
        return Result.success(recordService.borrowOne(1,bookIdInt));
    }
}
