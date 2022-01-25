package com.lxl.store.service;

import com.lxl.store.entity.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author LiXianLei
 * @time 2022/01/25 11:57
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DistrictServiceTests {

    private IDistrictService districtService;

    @Autowired
    public void setDistrictService(IDistrictService districtService){
        this.districtService = districtService;
    }

    @Test
    public void getDistrictByParent(){
        List<District> districts = districtService.getDistrictByParent("130600");
        districts.forEach(System.out::println);
    }

}
