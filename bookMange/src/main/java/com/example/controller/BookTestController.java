package com.example.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.controller.utils.Result;
import com.example.entity.Book;
import com.example.service.BookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("books")
public class BookTestController {

    @Autowired
    private BookService bookService;
    //查询所有
    @ApiOperation(value = "所有信息")
    @RequestMapping(value = "/bookMange",method = RequestMethod.GET)
    public Result getBookList(){
        List<Book> list = bookService.getBookList();
        return Result.ok().data("items", list);
    }


    //单个查询
    @RequestMapping(value = "/bookMange/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Result getById(@PathVariable Integer id){
        return Result.ok().data("items",bookService.getById(id));

    }

    /**
     * 插入
     * @param book
     * @return
     */
    @RequestMapping(value = "/bookMange",method = RequestMethod.POST)
    @ResponseBody
    public Result saveBook(@RequestBody Book book) throws IOException {
//        return Result.error();  //添加失败测试
        return Result.ok().data("items",bookService.saveBook(book));

    }


    /**
     * 修改
     * @param book
     * @return
     */
    @RequestMapping(value = "/bookMange",method = RequestMethod.PUT)
    @ResponseBody
    public Result updateBook(@RequestBody Book book){
            return Result.ok().data("items",bookService.updateBook(book));
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/bookMange/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return Result.ok();

    }

    /**
     * 分页查询
     * @param current
     * @param size
     * @return
     */
    @RequestMapping("/bookMange/{current}/{size}")
    @ResponseBody
    public Result getBookPage(@PathVariable long current, @PathVariable long size,Book book){
        //  这是一个显示测试
        //  System.out.println("参数==》"+book);
        IPage<Book> page = bookService.getBookPage(current, size ,book);
        return Result.ok().data("items",page);
    }


}
