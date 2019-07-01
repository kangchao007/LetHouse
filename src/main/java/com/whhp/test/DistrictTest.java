package com.whhp.test;


import com.whhp.service.DistrictService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class DistrictTest {
    @Autowired
    private DistrictService districtService;

    @Test
    public  void deleteTest(){
        int i = districtService.deleteByPrimaryKey(1007);
        System.out.println("i = " + i);
    }
}
