package com.example.Repository;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookRepository extends BaseMapper<Book> {
//    @Select("select * from tbl_book where id = #{id}")
//    Book getById(Integer id);
}
