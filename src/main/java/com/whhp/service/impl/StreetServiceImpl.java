package com.whhp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whhp.entity.Street;
import com.whhp.entity.StreetExample;
import com.whhp.mapper.StreetMapper;
import com.whhp.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {

    @Autowired
    private StreetMapper streetMapper;

    public int deleteByPrimaryKey(Integer id) {
        return streetMapper.deleteByPrimaryKey(id);
    }

    public int insert(Street record) {
        return 0;
    }

    public int insertSelective(Street record) {
        return streetMapper.insertSelective(record);
    }

    public List<Street> selectByExample(StreetExample example) {
        return streetMapper.selectByExample(example);
    }

    public Street selectByPrimaryKey(Integer id) {
        return null;
    }

    public int updateByPrimaryKeySelective(Street record) {
        return streetMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Street record) {
        return 0;
    }

    public int deleteMoreStreet(Integer[] ids) {
        return 0;
    }

    public PageInfo<Street> selectAllStreetByPage(Integer page, Integer pagesize) {

        PageHelper.startPage(page,pagesize);
        StreetExample streetExample=new StreetExample();


        List<Street> streets = streetMapper.selectByExample(streetExample);
        PageInfo<Street> pageInfo=new PageInfo(streets);
        return pageInfo;
    }

    public int deleteMoreStreetById(Integer[] ids) {

        for (Integer id : ids) {
            System.out.println("id = " + id);
        }
        return streetMapper.deleteMoreStreetById(ids);
    }


    public PageInfo<Street> getStreetByDistrict(Integer page, Integer pageSize, Integer districtId) {
        PageHelper.startPage(page,pageSize);
        StreetExample streetExample=new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        //传条件
        criteria.andDistrictIdEqualTo(districtId);
        List<Street> streetList = streetMapper.selectByExample(streetExample);

        PageInfo<Street> pageInfo=new PageInfo<Street>(streetList);

        return pageInfo;
    }

    public List<Street> getStreetByDistrict(Integer did) {
        StreetExample streetExample=new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        criteria.andDistrictIdEqualTo(did);
        List<Street> streets = streetMapper.selectByExample(streetExample);
        return streets;
    }


}
