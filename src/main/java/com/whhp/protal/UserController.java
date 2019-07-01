package com.whhp.protal;

import com.whhp.entity.Users;
import com.whhp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/page/")
public class UserController {

    @Autowired
    private UsersService usersService;

    //注册
    @RequestMapping("regUser")
    public  String regUser(Users users){
        int temp = usersService.addUser(users);
        if (temp>0){
            return "login";
        }
        return "error";
    }

    //检查用户名是否存在
    @RequestMapping("checkUname")
    @ResponseBody
    public String checkUname(String username){
        int temp = usersService.checkUname(username);
        return "{\"result\":"+temp+"}";
    }


    //登录
    @RequestMapping("login")
    public  String  loginUser(String username, String password, Model model, HttpSession session){
        //调用业务
        Users user = usersService.login(username, password);
        System.out.println("user = " + user);
        if (user!=null){

            session.setAttribute("user",user);

            session.setMaxInactiveInterval(3000);
            //System.out.println("name="+user.getName());
            return "guanli";
        }
        else {

            model.addAttribute("info","密码错误，请重新输入");
            return "login";
        }

    }


}
