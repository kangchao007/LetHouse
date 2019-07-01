package com.whhp.mapper;

import com.whhp.entity.House;
import com.whhp.entity.HouseCondition;
import com.whhp.entity.HouseExample;
import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    //根据用户id查询房子信息
    List<House> selectHouseByUserId(Integer uid);


    //逻辑删除用户租房
    public int delHouse(String id);

    //查询 已/未审核 的房屋
    public  List<House> getHouseByState(Integer state);


    //审核房屋
    int passHouse(String id);


    //取消审核房屋
    int  cancelPassHouse(String id);


    //查询浏览的出租房信息
    List<House> getHouseByBrowser(HouseCondition condition);
}