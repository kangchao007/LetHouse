package com.whhp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whhp.entity.Users;
import com.whhp.entity.UsersCondition;
import com.whhp.entity.UsersExample;
import com.whhp.mapper.UsersMapper;
import com.whhp.service.UsersService;
import com.whhp.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsersServiceImpl implements UsersService {


    @Autowired
    private UsersMapper usersMapper;

    public int deleteByPrimaryKey(Integer id) {
        return usersMapper.deleteByPrimaryKey(id);
    }

    public int insert(Users record) {
        return 0;
    }

    public int insertSelective(Users record) {
        return usersMapper.insertSelective(record);
    }

    public List<Users> selectByExample(UsersExample example) {
        return null;
    }

    public Users selectByPrimaryKey(Integer id) {
        return null;
    }

    public int updateByPrimaryKeySelective(Users record) {
        return usersMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Users record) {
        return 0;
    }

    public List<Users> selectAllUsers() {
        return usersMapper.selectAllUsers();
    }


    //查询分页条件查询于一体
    public PageInfo<Users> selectAllUsersByPage(UsersCondition condition) {
        PageHelper.startPage(condition.getPage(),condition.getRows());
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
       criteria.andIsadminEqualTo(new Integer(1));//表示只查询管理员
        //添加查询条件
        //添加姓名查询
        if (condition.getUserName()!=null){
            criteria.andNameLike("%"+condition.getUserName()+"%");
            System.out.println("condition = " + condition.getUserName());
        }

        //添加查询电话
        if (condition.getTelephone()!=null){
            criteria.andTelephoneLike("%"+condition.getTelephone()+"%");
            System.out.println("condition = " + condition.getTelephone());
        }

        List<Users> usersList = usersMapper.selectByExample(usersExample);

        return new PageInfo(usersList);
    }

    public int deleteMoreUser(Integer[] ids) {
       // System.out.println(usersMapper.deleteMoreUser(ids));
        int i = usersMapper.deleteMoreUser(ids);
        System.out.println("i = " + i);
        return i;
    }

    //注册功能
    public int addUser(Users users) {

        users.setIsadmin(0);
        //md5加密
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));

        return usersMapper.insertSelective(users);
    }

    //登录
    public Users login(String username, String password) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();

        //添加条件
        criteria.andIsadminEqualTo(0);
        criteria.andNameEqualTo(username);
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));

        List<Users> usersList = usersMapper.selectByExample(usersExample);

        if (usersList.size()==1){
            return usersList.get(0);
        }

        return null;
    }


    public int checkUname(String username) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();

        criteria.andNameEqualTo(username);
        criteria.andIsadminEqualTo(0);
        List<Users> usersList = usersMapper.selectByExample(usersExample);
        return usersList.size()==0?0:1;
    }


}
