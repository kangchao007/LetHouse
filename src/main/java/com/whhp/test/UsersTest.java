package com.whhp.test;

import com.whhp.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class UsersTest {
    @Autowired
    private UsersService usersService;
    @Test
    public void test(){
        System.out.println(usersService.selectAllUsers());
    }

    @Test
    public void testdelete(){
        int i = usersService.deleteByPrimaryKey(1010);
        System.out.println(i>0?"删除成功":"删除失败");
    }
}
