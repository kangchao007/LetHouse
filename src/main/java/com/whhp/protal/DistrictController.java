package com.whhp.protal;

import com.whhp.entity.District;
import com.whhp.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("DistrictController2")
@RequestMapping("/page/")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @RequestMapping("getDistrict")
    @ResponseBody
    public List<District> getDistrict(){
        for (District o :districtService.getAllDistrict() ) {
            System.out.println("o = " + o.getName());
        }
        return districtService.getAllDistrict();
    }
}
