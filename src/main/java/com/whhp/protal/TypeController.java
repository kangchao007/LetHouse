package com.whhp.protal;

import com.whhp.entity.Type;
import com.whhp.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/page/")
public class TypeController {

    @Autowired
    private TypeService typeService;


    //发送请求获取类型的异步数据
    @RequestMapping("getType")
    @ResponseBody
    public List<Type> getType(){
        return  typeService.getAllType();
    }


}
