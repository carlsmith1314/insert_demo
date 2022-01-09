package com.example.insert_demo.Operate;


import com.example.insert_demo.Entity.Technical;
import com.example.insert_demo.Service.TechnicalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class searchTest {
    @Autowired
    private TechnicalService technicalService;

    @Test
    public void testSearch(){
        Technical technical = new Technical();
        technical.setTerm_id("01.0001");
        technical.setSubject("计算机系统组成");
        technical.setStandard("计算机");
        technical.setEn_name("computer");
        technical.setDefinition("采用机械等方式");
        technical.setSource("计算机科学技术名词");
        technical.setVersion("第三版");
        technicalService.insert(technical);
        technicalService.searchDefByStandard("计算机");
    }
}
