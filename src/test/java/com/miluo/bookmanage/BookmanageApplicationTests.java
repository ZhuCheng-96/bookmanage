package com.miluo.bookmanage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookmanageApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext webApplicationContext;

    @BeforeEach
    public void before(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void selectByKeywordTest() throws Exception{
        String keyword = "鲁迅";
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.get("/book?keyword="+keyword))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString(Charset.forName("utf-8"));
        System.out.println(content);
    }

    @Test
    @Transactional
    @Rollback
    public void borrowOneTest() throws Exception {
        String bookId = "4";
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.post("/book?borrow_book_id="+bookId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString(Charset.forName("utf-8"));
        System.out.println(content);
    }

}
