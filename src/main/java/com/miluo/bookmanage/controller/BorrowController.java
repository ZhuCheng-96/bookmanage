package com.miluo.bookmanage.controller;

import com.miluo.bookmanage.dao.BookMapper;
import com.miluo.bookmanage.service.BookService;
import com.miluo.bookmanage.service.BorrowService;
import com.miluo.bookmanage.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class BorrowController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BorrowService borrowService;

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
        return Result.success(borrowService.borrowOne(1,bookIdInt));
    }
}
