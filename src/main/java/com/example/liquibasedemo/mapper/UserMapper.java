package com.example.liquibasedemo.mapper;

import com.example.liquibasedemo.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from t_users where id = #{id}")
    User getUserById(@Param("id") String id);

    int insert(User user);
}
