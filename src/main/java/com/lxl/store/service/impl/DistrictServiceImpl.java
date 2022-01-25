package com.lxl.store.service.impl;

import com.lxl.store.entity.District;
import com.lxl.store.mapper.DistrictMapper;
import com.lxl.store.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiXianLei
 * @time 2022/01/25 11:51
 */
@Service
public class DistrictServiceImpl implements IDistrictService {

    private DistrictMapper districtMapper;

    @Autowired
    public void setDistrictMapper(DistrictMapper districtMapper){
        this.districtMapper = districtMapper;
    }

    @Override
    public List<District> getDistrictByParent(String parent) {
        List<District> list = districtMapper.findDistrictByParent(parent);
        for(District district : list){
            district.setId(null);
            district.setParent(null);
        }
        return list;
    }

    @Override
    public String getNameByCode(String code) {
        return districtMapper.findNameByCode(code);
    }
}
