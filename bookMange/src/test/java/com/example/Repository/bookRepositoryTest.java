package com.example.Repository;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Book;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class bookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;


    //查询单个
    @Test
    void getTestById(){
        bookRepository.selectById(1);
    }

    //查询全部
    @Test
    void getTestList(){
      bookRepository.selectList(null);
    }

    //增
    @Test
    void TestSave(){
        Book book = new Book();
        book.setName("计算机导论");
        book.setType("清华大学出版社");
        book.setDescription("融汇计算机语言的书籍");
        bookRepository.insert(book);

    }

    //改
    @Test
    void TestUpdate(){
        Book book = new Book();
        book.setId(50);
        book.setName("计算机导论");
        book.setType("清华大学出版社");
        book.setDescription("融汇计算机语言的书籍");
        bookRepository.updateById(book);
    }

    //删
    @Test
    void TestDelete(){
        bookRepository.deleteById(1001);
    }

    //分页查询
    @Test
    void TestSelectPage(){
        IPage page = new Page(1,10);
        bookRepository.selectPage(page,null);
    }
    //条件查询

    /**
     * 这种查询需要自己手动输入查询的字段名，可能会有输入错误的风险
     * 用第二种升级版的方法，在查询之前进行判断
     * 如果为空则不显示like之后的查询条件
     * 如果不为空则显示查询结果
     */
    @Test
    void TestGetBy(){
        QueryWrapper<Book> qw = new QueryWrapper<Book>();
        qw.like("name","物流");
        bookRepository.selectList(qw);
    }

    //条件查询（升级版）
    @Test
    void TestGetByPlus(){
        String name = "";
        LambdaQueryWrapper<Book> qwp = new LambdaQueryWrapper<Book>();
        // if (name != null) qwp.like(Book::getName,name);
        /**
         * 使用spring工具类判断是否为空 为 false ，则不连接
         * 如果为 true ，则连接
         */
        qwp.like(Strings.isNotEmpty(name),Book::getName,name);
        bookRepository.selectList(qwp);
    }

}
