package com.whhp.service;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.District;
import com.whhp.entity.DistrictExample;

import java.util.List;

public interface DistrictService {
    int deleteByPrimaryKey(Integer id);

    int insert(District record);

    int insertSelective(District record);

    List<District> selectByExample(DistrictExample example);

    District selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);

    PageInfo<District> selectAllDistrictByPage(Integer page,Integer pageSize);

    //删除用数组批量
    int deleteMoreDistrict(Integer[] ids);


    List<District> getAllDistrict();



}
