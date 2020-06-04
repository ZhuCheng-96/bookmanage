package com.miluo.bookmanage;

import com.miluo.bookmanage.controller.BookController;
import com.miluo.bookmanage.pojo.Book;
import com.miluo.bookmanage.service.BookService;
import com.miluo.bookmanage.utils.Result;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

public class ControllerTest {
    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void myServiceMethod() throws Exception{
        Book book1 = new Book(1,"呐喊","鲁迅",0);
        Book book2 = new Book(2,"彷徨","鲁迅",0);
        Book book3 = new Book(3,"朝花夕拾","鲁迅",0);
        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        Mockito.when(bookService.selectByKeyword(Mockito.anyString())).thenReturn(bookList);
        Assert.assertEquals(Result.success(bookList),bookController.selectByKeyword("qqq"));

    }

}
