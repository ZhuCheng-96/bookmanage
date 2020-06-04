package com.miluo.bookmanage;

import com.miluo.bookmanage.dao.BookMapper;
import com.miluo.bookmanage.dao.RecordMapper;
import com.miluo.bookmanage.exception.BusinessException;
import com.miluo.bookmanage.pojo.Book;
import com.miluo.bookmanage.service.impl.RecordServiceImpl;
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

import static org.hamcrest.core.Is.is;

public class ServiceTest {
    @InjectMocks
    private RecordServiceImpl recordService;

    @Mock
    private RecordMapper recordMapper;

    @Mock
    private BookMapper bookMapper;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(recordService).build();
    }

    /**
     * 用户2可借阅，书籍4可借阅
     */
    @Test
    public void recordServiceTest1(){
        Book book = new Book(4,"呐喊","鲁迅",0);
        Mockito.when(bookMapper.selectByPrimaryKey(4)).thenReturn(book);
        Mockito.when(bookMapper.updateByPrimaryKeySelective(Mockito.any(Book.class))).thenReturn(1);
        Assert.assertEquals(new Integer(1),recordService.borrowOne(2,4));
    }

    /**
     * 用户1已借5本书，无法继续借阅
     */
    @Test
    public void recordServiceTest2(){
        try {
            Mockito.when(recordMapper.getBookCountByUserId(1)).thenReturn(5);
            recordService.borrowOne(1,1);
        } catch (BusinessException e) {
            Assert.assertThat(e.getMessage(),is("Over borrowed!"));
        }
    }

    /**
     * 用户2可借阅，书籍不存在
     */
    @Test
    public void recordServiceTest3(){
        try {
            Mockito.when(recordMapper.getBookCountByUserId(2)).thenReturn(3);
            Mockito.when(bookMapper.selectByPrimaryKey(2)).thenReturn(null);
            recordService.borrowOne(2,2);
        } catch (BusinessException e) {
            Assert.assertThat(e.getMessage(),is("Book not exist!"));
        }
    }

    /**
     * 用户2可借阅，书籍状态异常无法借阅
     */
    @Test
    public void recordServiceTest4(){
        try {
            Book book = new Book(3,"朝花夕拾","鲁迅",1);
            Mockito.when(recordMapper.getBookCountByUserId(2)).thenReturn(3);
            Mockito.when(bookMapper.selectByPrimaryKey(3)).thenReturn(book);
            recordService.borrowOne(2,3);
        } catch (BusinessException e) {
            Assert.assertThat(e.getMessage(),is("Book not available for borrowing!"));
        }
    }

}
