package com.whhp.service;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.Street;
import com.whhp.entity.StreetExample;

import java.util.List;

public interface StreetService {
    int deleteByPrimaryKey(Integer id);

    int insert(Street record);

    int insertSelective(Street record);

    List<Street> selectByExample(StreetExample example);

    Street selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Street record);

    int updateByPrimaryKey(Street record);

    //删除单条
    int deleteMoreStreet(Integer[] ids);

    PageInfo<Street> selectAllStreetByPage(Integer page, Integer pagesize);

    //删除多条
    int deleteMoreStreetById(Integer[] ids);

    //通过区域查询街道
    public PageInfo<Street> getStreetByDistrict(Integer page, Integer pageSize, Integer districtId) ;


    //联动下拉列表使用
    public List<Street> getStreetByDistrict(Integer did);

}
