package com.example.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Book;
import com.example.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class bookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    void getTestById(){
        System.out.println( bookService.getById(1));
    }

    //查询全部
    @Test
    void getTestList(){
        bookService.getBookList();
    }

    //增
    @Test
    void TestSave(){
        Book book = new Book();
        book.setName("计算机导论");
        book.setType("清华大学出版社");
        book.setDescription("融汇计算机语言的书籍");
        bookService.saveBook(book);

    }

    //改
    @Test
    void TestUpdate(){
        Book book = new Book();
        book.setId(35);
        book.setName("计算机导论");
        book.setType("清华大学出版社");
        book.setDescription("融汇计算机语言的书籍");
        bookService.updateBook(book);
    }

    //删
    @Test
    void TestDelete(){
        bookService.deleteBook(44);
    }

    //分页查询
    @Test
    void TestSelectPage(){
        bookService.getBookPage(1,10);
    }
}
