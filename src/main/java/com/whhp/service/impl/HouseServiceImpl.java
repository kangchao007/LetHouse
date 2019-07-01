package com.whhp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whhp.entity.House;
import com.whhp.entity.HouseCondition;
import com.whhp.mapper.HouseMapper;
import com.whhp.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl  implements HouseService {
    @Autowired
    private HouseMapper houseMapper;

    public int addHouse(House house) {
        return  houseMapper.insertSelective(house);
    }

    //根据用户id查询房屋并分页
    public PageInfo<House> getHouseByPage(Integer page, Integer rows, Integer uid) {
        PageHelper.startPage(page,rows);
        List<House> list = houseMapper.selectHouseByUserId(uid);
        return new PageInfo<House>(list);
    }

    //逻辑删除用户租房
    public int delHouse(String id) {
        House house=new House();
        house.setId(id);
        house.setIsdel(new Integer(1));
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    //查询 已/未审核 的房屋
    public PageInfo<House> getHouseByState(Integer page, Integer pageSize, Integer isPass) {
        PageHelper.startPage(page,pageSize);

        //调用dao层
        List<House> list = houseMapper.getHouseByState(isPass);
        return new PageInfo<House>(list);
    }

    //审核房屋
    public int passHouse(String id) {
        House house=new House();
        house.setId(id);
        house.setIspass(1);
        return houseMapper.updateByPrimaryKeySelective(house);
    }


    //取消审核房屋
    public int cancelPassHouse(String id) {
        House house=new House();
        house.setId(id);
        house.setIspass(0);
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    public PageInfo<House> getHouseByBrowser(HouseCondition condition) {
        PageHelper.startPage(condition.getPage(),condition.getPageSize());
        //调用业务  Example只能实现单表条件搜索查询
        if(condition.getTitle()!=null) {
            condition.setTitle("%" + condition.getTitle() + "%");
        }

        List<House> list=houseMapper.getHouseByBrowser(condition);
        PageInfo<House> pageInfo=new PageInfo<House>(list);
        return pageInfo;
    }


}
