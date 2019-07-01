package com.whhp.protal;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.*;
import com.whhp.service.DistrictService;
import com.whhp.service.HouseService;
import com.whhp.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/page/")
public class HouseController {

    @Autowired
    private DistrictService districtService;

    @Autowired
    private TypeService typeService;
    @Autowired
    private HouseService houseService;


    @RequestMapping("goFaBu")
    public String goFaBu(Model model){
        List<Type> typeList = typeService.getAllType();
        List<District> allDistrict = districtService.getAllDistrict();
       // System.out.println("allDistrict = " + allDistrict.toString());
        model.addAttribute("typeList",typeList);
        model.addAttribute("allDistrict",allDistrict);
        return "fabu";
    }


    @RequestMapping("addHouse")
    public String addHouse(House house,@RequestParam(value = "pfile",required = false) CommonsMultipartFile pfile, HttpSession session) throws Exception {
        //将文件保存到服务器  D:\A课工厂文档、软件\images
        String fname = pfile.getOriginalFilename();
        String expName = fname.substring(fname.lastIndexOf("."));
        String saveName = System.currentTimeMillis() + expName;
        File file = new File("D:\\images\\" + saveName);
        pfile.transferTo(file);//保存
        //houseService.addHouse(house);

        //保存数据库的记录  house已经接收部分表单数据
        //设置编号
        house.setId(System.currentTimeMillis() + "");
        //设置用户编号
        Users user = (Users) session.getAttribute("user");
        house.setUserId(user.getId());
        //设置审核状态 0  如果表中有默认值 可不设
        house.setIspass(0);
        //设置是否删除  0
        house.setIsdel(0);
        //设置图片路径
        house.setPath(saveName);

        if (houseService.addHouse(house) > 0) { //保存数据
            //调用业务
            //houseService.addHouse(house); //添加信息到数据库
            return "redirect:goFaBu";  //跳转页面
        } else {
            //成功上传的图片删除
            file.delete();
            return "redirect:goFaBu";
        }

    }


    //查询出租房屋信息  用户id在session域中
    @RequestMapping("getUserHouse")
    public String getUserHouse(Integer page,HttpSession session,Model model) throws Exception{
        //调用业务层
        Users user = (Users)session.getAttribute("user");
        PageInfo<House> pageInfo = houseService.getHouseByPage(page==null?1:page,10,user.getId());
        model.addAttribute("pageInfo",pageInfo);

        return "guanli";
    }


    //逻辑删除用户租房
    @RequestMapping("delHouse")
    @ResponseBody
    public String delHouse(String id){
        int temp = houseService.delHouse(id);
        return "{\"result\":"+temp+"}";
    }


    //查询所有浏览出租房信息
    @RequestMapping("goList")
    public String goList(HouseCondition condition, Model model){  //传页码
        //调用业务获取出租房
        PageInfo<House> pageInfo=houseService.getHouseByBrowser(condition);
        //将分页信息设置到作用域中
        model.addAttribute("pageInfo",pageInfo);

        if(condition.getTitle()!=null)
            condition.setTitle(condition.getTitle().replaceAll("%",""));
        model.addAttribute("condition",condition);  //回显查询条
        return "list";
    }

}
