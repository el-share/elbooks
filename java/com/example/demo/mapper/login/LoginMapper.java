package com.example.demo.mapper.login;



import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.LoginUser;

@Mapper
public interface LoginMapper{

    LoginUser findUser(String user_name);

}
