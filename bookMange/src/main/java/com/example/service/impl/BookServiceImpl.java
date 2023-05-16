package com.example.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.Repository.BookRepository;
import com.example.entity.Book;
import com.example.service.BookService;
import com.sun.org.apache.xpath.internal.operations.String;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book getById(Integer id) {
        return bookRepository.selectById(id);
    }

    @Override
    public List<Book> getBookList() {
        return bookRepository.selectList(null);
    }

    @Override
    public boolean saveBook(Book book) {
        return bookRepository.insert(book) > 0;
    }

    @Override
    public boolean updateBook(Book book) {
        return bookRepository.updateById(book) > 0;
    }

    @Override
    public boolean deleteBook(Integer id) {
        return bookRepository.deleteById(id) > 0;
    }

    /**
     * 分页查询
     * @param current
     * @param size
     * @return
     */
    @Override
    public IPage<Book> getBookPage(long current, long size) {
        IPage<Book> page = new Page<Book>(current,size);
        //如果当前页码值current > 最大页数的页码值pages，使用最大页码值为当前页码值
            bookRepository.selectPage(page,null);
        return page;
    }

    /**
     * 条件查询
     * @param current
     * @param size
     * @param book
     * @return
     */
    @Override
    public IPage<Book> getBookPage(long current, long size, Book book) {
        LambdaQueryWrapper<Book> lqw =  new LambdaQueryWrapper<Book>();
        //如果条件为真，则执行Book::getType,book.getType()
        lqw.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());
        IPage<Book> page = new Page<Book>(current,size);
        bookRepository.selectPage(page,lqw);
        return page;
    }
}
