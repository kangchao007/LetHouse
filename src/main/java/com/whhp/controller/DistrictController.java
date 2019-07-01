package com.whhp.controller;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.District;
import com.whhp.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @RequestMapping("selectAllDistrictByPage")

    public Map<String,Object> selectAllDistrictByPage(Integer page,Integer rows){
        PageInfo<District> pageInfo = districtService.selectAllDistrictByPage(page, rows);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @RequestMapping("insertDistrict")
    public String insertDistrict(District district){
        int temp = districtService.insertSelective(district);
        return "{\"result\":"+temp+"}";
    }

    @RequestMapping("updateDistrict")

    public String updateDistrict(District district){
        int temp = districtService.updateByPrimaryKeySelective(district);
        return "{\"result\":"+temp+"}";
    }

    /*//批量删除方法1
    @RequestMapping("deleteDistrict")
    @ResponseBody
    @Transactional
    public String deleteDistrict(@RequestBody String JsonString){
        System.out.println("JsonString = " + JsonString);
        String s = JsonString.substring(JsonString.indexOf("=") + 1);
        String[] arr = s.split("%2C");
        int[] arr2=new int[arr.length];
        int count=0;
        for (int i = 0; i < arr.length; i++) {
           arr2[i]=Integer.parseInt(arr[i]);
           count+= districtService.deleteByPrimaryKey(arr2[i]);
        }
        return "{\"DeleteCounts\":"+count+"}";
    }*/

    //批量删除方法2
    @RequestMapping("deleteMoreDistrict")
    @Transactional
    public String deleteMoreDistrict(Integer[] ids){
        int temp = districtService.deleteMoreDistrict(ids);
        return "{\"result\":"+temp+"}";
    }


    //删除
    @RequestMapping("/deleteDistrict")

    public String deleteDistrict(Integer id){
        int temp = districtService.deleteByPrimaryKey(id);
        return "{\"result\":"+temp+"}";
    }

}
