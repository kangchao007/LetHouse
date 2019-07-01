package com.whhp.controller;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.Users;
import com.whhp.entity.UsersCondition;
import com.whhp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("selectAllUserByPage")
    public Map<String,Object> selectAllUserByPage(UsersCondition condition){

        PageInfo<Users> usersPageInfo = usersService.selectAllUsersByPage(condition);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total",usersPageInfo.getTotal());
        map.put("rows",usersPageInfo.getList());
        return map;
    }


    @RequestMapping("selectAllUsers")
    public  List<Users> selectAllUsers(){
        List<Users> usersList = usersService.selectAllUsers();
        return  usersList;
    }


    @RequestMapping("insertUser")
    public String insertUser(Users users){
        int temp = usersService.insertSelective(users);
        return "{\"result\":"+temp+"}";
    }

    //删除单条
    @RequestMapping("deleteUser")
    public   String deleteUser(Integer id){
        int temp = usersService.deleteByPrimaryKey(id);
        return "{\"result\":"+temp+"}";
    }

    @RequestMapping("updateUser")
    public String updateUser(Users users){
        int temp = usersService.updateByPrimaryKeySelective(users);
        return "{\"result\":"+temp+"}";
    }

    @RequestMapping("deleteMoreUser")
    @ResponseBody
    public String deleteMoreUser(String ids){
        //将字符串转化为整型数组
        String[] arrys=ids.split(",");

        Integer[] id=new Integer[arrys.length];
        for (int i = 0; i < arrys.length; i++) {
            id[i]=Integer.parseInt(arrys[i]);
        }
        int temp = usersService.deleteMoreUser(id);
        System.out.println("temp = " + temp);
        return "{\"result\":"+temp+"}";
    }





}
