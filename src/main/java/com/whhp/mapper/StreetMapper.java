package com.whhp.mapper;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.Street;
import com.whhp.entity.StreetExample;
import java.util.List;

public interface StreetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Street record);

    int insertSelective(Street record);

    List<Street> selectByExample(StreetExample example);

    Street selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Street record);

    int updateByPrimaryKey(Street record);

    int deleteMoreStreet(Integer[] ids);

    //删除多条
    int deleteMoreStreetById(Integer[] ids);


    //通过区域查询街道
    public PageInfo<Street> getStreetByDistrict(Integer page, Integer pageSize, Integer districtId) ;

}