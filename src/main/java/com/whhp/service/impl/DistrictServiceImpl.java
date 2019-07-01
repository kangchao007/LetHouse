package com.whhp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whhp.entity.District;
import com.whhp.entity.DistrictExample;
import com.whhp.mapper.DistrictMapper;
import com.whhp.mapper.StreetMapper;
import com.whhp.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private StreetMapper streetMapper;

    @Transactional
    public int deleteByPrimaryKey(Integer id) {
        try {
            //删除街道   通过区域删除街道
            streetMapper.deleteByPrimaryKey(id);
            //删除区域
            districtMapper.deleteByPrimaryKey(id);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int insert(District record) {
        return 0;
    }

    public int insertSelective(District record) {
        return districtMapper.insertSelective(record);
    }

    public List<District> selectByExample(DistrictExample example) {
        return null;
    }

    public District selectByPrimaryKey(Integer id) {
        return null;
    }

    public int updateByPrimaryKeySelective(District record) {
        return districtMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(District record) {
        return 0;
    }

    //查询全部加分页
    public PageInfo<District> selectAllDistrictByPage(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        DistrictExample districtExample = new DistrictExample();
        List<District> districts = districtMapper.selectByExample(districtExample);
        PageInfo pageInfo=new PageInfo(districts);
        return pageInfo;
    }


    /*public int deleteMoreDistrict(Integer[] ids) {
        return districtMapper.deleteMoreDistrict(ids);
    }*/

    public int deleteMoreDistrict(Integer[] ids) {
        try {
            //删除街道   通过区域删除街道
            streetMapper.deleteMoreStreet(ids);
            //删除区域
            districtMapper.deleteMoreDistrict(ids);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public List<District> getAllDistrict() {
        return districtMapper.selectByExample(new DistrictExample());
    }
}
