package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Book;

import java.util.List;

public interface BookService  {
    Book getById(Integer id);
    List<Book> getBookList();
    boolean saveBook(Book book);
    boolean updateBook(Book book);
    boolean deleteBook(Integer id);
    IPage<Book> getBookPage(long current, long size);
    IPage<Book> getBookPage(long current, long size , Book book);


}
