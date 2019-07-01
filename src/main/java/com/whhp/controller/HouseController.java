package com.whhp.controller;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.House;
import com.whhp.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller("houseController2")
@RequestMapping("/admin/")
public class HouseController {

    @Autowired
    private HouseService houseService;

    //查询未审核
    @RequestMapping("getHouseByNoPass")
    @ResponseBody
    public Map<String,Object> getHouseByNoPass(Integer page, Integer rows, Model model){
        //调用业务层
        PageInfo<House> pageInfo = houseService.getHouseByState(page, rows, 0);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        model.addAttribute("map",map);
        return map;
    }

    //通过审核
    @RequestMapping("passHouse")
    @ResponseBody
    public Map<String,Object> passHouse(String id){
        int i = houseService.passHouse(id);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("result",i);
        return map;
    }




    //查询已审核
    @RequestMapping("getHouseByYesPass")
    @ResponseBody
    public Map<String,Object> getHouseByYesPass(Integer page, Integer rows, Model model){
        //调用业务层
        PageInfo<House> pageInfo = houseService.getHouseByState(page, rows, 1);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        model.addAttribute("map",map);
        return map;
    }


    //取消审核房屋
    @RequestMapping("cancelPassHouse")
    @ResponseBody
    public Map<String,Object> cancelPassHouse(String id){
        int i = houseService.cancelPassHouse(id);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("result",i);
        return map;
    }
}
