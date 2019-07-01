package com.whhp.service;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.House;
import com.whhp.entity.HouseCondition;

import java.util.List;
import java.util.concurrent.locks.Condition;

public interface HouseService {

    public int addHouse(House house);


    //根据用户id查询房子信息
    PageInfo<House> getHouseByPage(Integer page,Integer rows,Integer uid);

    //逻辑删除用户租房
    public int delHouse(String id);


    //查询 已/未审核 的房屋
    public  PageInfo<House> getHouseByState(Integer page,Integer pageSize,Integer isPass);


    //审核房屋
    int passHouse(String id);

    //取消审核房屋
    int  cancelPassHouse(String id);

    //查询浏览的出租房信息
    PageInfo<House> getHouseByBrowser(HouseCondition condition);
}
