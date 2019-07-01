package com.whhp.protal;

import com.whhp.entity.Street;
import com.whhp.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/page/")
public class StreetController2 {

    @Autowired
    private StreetService streetService;

    @RequestMapping("getStreetByDistrict2")
    @ResponseBody
    public List<Street> getStreetByDistrict2(Integer did){
        System.out.println(did);
        return  streetService.getStreetByDistrict(did);
    }


}
