package com.whhp.controller;


import com.github.pagehelper.PageInfo;
import com.whhp.entity.Street;
import com.whhp.entity.StreetExample;
import com.whhp.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/")
public class StreetController {

    @Autowired
    private StreetService streetService;

    @RequestMapping("selectAllStreet")
    public Map<String,Object> selectAllStreet(Integer page,Integer rows){
        PageInfo pageInfo = streetService.selectAllStreetByPage(page, rows);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @RequestMapping("insertStreet")
    public  String insertStreet(Street street){
        int temp = streetService.insertSelective(street);
        return " {\"result\":"+temp+"}";
    }


    @RequestMapping("updateStreet")
    public String updateStreet(Street street){
        int temp = streetService.updateByPrimaryKeySelective(street);
        return "{\"result\":"+temp+"}";
    }

    //删除单条
    @RequestMapping("deleteStreet")
    public  String deleteStreet(Integer id){
        int temp = streetService.deleteByPrimaryKey(id);
        return "{\"result\":"+temp+"}";
    }


    //删除多条
    @RequestMapping("deleteMoreStreetById")
    public  String deleteMoreStreetById(Integer[] ids){
        int temp = streetService.deleteMoreStreetById(ids);
        System.out.println("temp = " + temp);
        return "{\"result\":"+temp+"}";
    }


    @RequestMapping("selectStreetByDid")
    public  Map<String,Object> selectStreetByDid(Integer page,Integer rows,Integer districtId){
        //调用service
        PageInfo<Street> pageInfo = streetService.getStreetByDistrict(page, rows, districtId);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        System.out.println("map = " + map.toString());
        return map;
    }
}
