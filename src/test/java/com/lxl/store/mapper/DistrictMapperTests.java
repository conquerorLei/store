package com.lxl.store.mapper;

import com.lxl.store.entity.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

/**
 * @author LiXianLei
 * @time 2022/01/25 11:33
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DistrictMapperTests {

    private DistrictMapper districtMapper;

    @Autowired
    public void setDistrictMapper(DistrictMapper districtMapper){
        this.districtMapper = districtMapper;
    }

    @Test
    public void findByParent(){
        List<District> list = districtMapper.findDistrictByParent("130600");
        list.forEach(System.out::println);
    }

    @Test
    public void findNameByCode(){
        System.out.println(districtMapper.findNameByCode("130600"));
    }
}
