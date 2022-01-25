package com.lxl.store.controller;

import com.lxl.store.entity.District;
import com.lxl.store.service.IDistrictService;
import com.lxl.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LiXianLei
 * @time 2022/01/25 12:01
 */
@RestController
@RequestMapping("districts")
public class DistrictController extends BaseController{

    private final IDistrictService districtService;

    @Autowired
    public DistrictController(IDistrictService districtService){
        this.districtService = districtService;
    }

    @RequestMapping({"/", ""})
    public JsonResult<List<District>> getByParent(String parent){
        List<District> data = districtService.getDistrictByParent(parent);
        return new JsonResult<>(OK, "获取地区成功", data);
    }
}
