package com.whhp.service;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.Users;
import com.whhp.entity.UsersCondition;
import com.whhp.entity.UsersExample;

import java.util.List;

public interface UsersService {

    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UsersExample example);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    List<Users> selectAllUsers();

    PageInfo<Users> selectAllUsersByPage(UsersCondition condition);

    int deleteMoreUser(Integer[] ids);

    //注册功能
    public int addUser(Users users);

    //登录
    public Users login(String username, String password) ;

    //检查用户名是否存在
    public  int checkUname(String username);
}
