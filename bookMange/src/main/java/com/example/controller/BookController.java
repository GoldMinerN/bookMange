package com.example.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookService bookService;
    //查询所有
    @RequestMapping(value = "/bookMange",method = RequestMethod.GET)
    public List<Book> getBookList(){
        return bookService.getBookList();
    }
    //单个查询
    @RequestMapping(value = "/bookMange/{id}",method = RequestMethod.GET)
    public Book getById(@PathVariable Integer id){
        return bookService.getById(id);
    }

    /**
     * 插入
     * @param book
     * @return
     */
    @RequestMapping(value = "/bookMange",method = RequestMethod.POST)
    @ResponseBody
    boolean saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    /**
     * 修改
     * @param book
     * @return
     */
    @RequestMapping(value = "/bookMange",method = RequestMethod.PUT)
    boolean updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    /**
     * 使用异步提交发送，它的参数是通过请求体传json数据过去，用@RequestBody请求体参数
     * 而查询单个数据和删除某条数据id的记录，我们一般使用路径变量来传递参数，
     * 格式一般为： http://localhost:8018/books/bookMange/3  这里的3就是id=3的这条数据
     * 因此，需要在@RequestMapping中加上("/bookMange/{id}")
     * 而路径则需要指定 @PathVariable
     */

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/bookMange/{id}",method = RequestMethod.DELETE)
    boolean deleteBook(@PathVariable Integer id){
        return bookService.deleteBook(id);
    }

    /**
     * 分页查询
     * @param current
     * @param size
     * @return
     */
    @RequestMapping("/bookMange/{current}/{size}")
    IPage<Book> getBookPage(@PathVariable long current, @PathVariable long size){
        return bookService.getBookPage(current, size);
    }
}
