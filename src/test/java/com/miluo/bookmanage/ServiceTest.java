package com.miluo.bookmanage;

import com.miluo.bookmanage.controller.BookController;
import com.miluo.bookmanage.dao.BookMapper;
import com.miluo.bookmanage.pojo.Book;
import com.miluo.bookmanage.service.BookService;
import com.miluo.bookmanage.service.impl.BookServiceImpl;
import com.miluo.bookmanage.utils.Result;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ServiceTest {
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
        Book book2 = new Book(1,"彷徨","鲁迅",0);
        Book book3 = new Book(1,"朝花夕拾","鲁迅",0);
        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        Mockito.when(bookService.selectByKeyword("鲁迅")).thenReturn(bookList);
        Result result = bookController.selectByKeyword("鲁迅");
        System.out.println(result);

        String keyword = "鲁迅";
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.get("/book?keyword="+keyword))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString(Charset.forName("utf-8"));
        System.out.println(content);
    }
}
