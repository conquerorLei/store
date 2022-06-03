package com.lxl.store.service.impl;

import com.lxl.store.entity.Address;
import com.lxl.store.exception.*;
import com.lxl.store.mapper.AddressMapper;
import com.lxl.store.service.IAddressService;
import com.lxl.store.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LiXianLei
 * @time 2022/01/24 17:22
 */
@Service
public class AddressServiceImpl implements IAddressService {
    private AddressMapper addressMapper;
    private IDistrictService districtService;

    @Value("${user.address.max-count}")
    private Integer maxCount;

    @Autowired
    public void setAddressMapper(AddressMapper addressMapper){
        this.addressMapper = addressMapper;
    }

    @Autowired
    public void setDistrictService(IDistrictService districtService){
        this.districtService = districtService;
    }

    @Override
    public void addNewAddress(Integer uid, String username, Address address) {
        Integer count = addressMapper.countByUid(uid);
        if(count >= maxCount){
            throw new AddressCountLimitException("用户地址超过上限:" + maxCount);
        }
        address.setUid(uid);
        address.setIsDefault(count == 0 ? 1 : 0);
        address.setCreatedUser(username);
        address.setCreatedTime(new Date());
        address.setModifiedUser(username);
        address.setModifiedTime(new Date());

        address.setProvinceName(districtService.getNameByCode(address.getProvinceCode()));
        address.setCityName(districtService.getNameByCode(address.getCityCode()));
        address.setAreaName(districtService.getNameByCode(address.getAreaCode()));


        Integer rows = addressMapper.insert(address);
        if(rows != 1){
            throw new InsertException("在地址插入的过程中产生了未知的异常");
        }
    }

    @Override
    public List<Address> getByUid(Integer uid) {
        List<Address> temp = addressMapper.findByUid(uid);
        List<Address> res = new LinkedList<>();
        for(Address address : temp){
            Address newAddress = new Address();
            newAddress.setTag(address.getTag());
            newAddress.setName(address.getName());
            newAddress.setProvinceName(address.getProvinceName());
            newAddress.setCityName(address.getCityName());
            newAddress.setAreaName(address.getAreaName());
            newAddress.setAddress(address.getAddress());
            newAddress.setZip(address.getZip());
            newAddress.setPhone(address.getPhone());
            newAddress.setAid(address.getAid());
            res.add(newAddress);
        }
        return res;
    }

    @Override
    public void setDefault(Integer aid, Integer uid, String username) {
        Address exist = addressMapper.findByAid(aid);
        if(exist == null)throw new AddressNotFoundException("地址不存在");
        Integer makeUnDefault = addressMapper.updateDefaultToNormal(uid);
        if(makeUnDefault != 1)throw new UpdateException("取消默认地址时产生未知的异常");
        Integer makeDefault = addressMapper.updateDefaultByAid(aid, username, new Date());
        if(makeDefault != 1) throw new UpdateException("设置默认地址时产生未知的异常");
    }

    @Override
    public void deleteDefault(Integer aid, Integer uid, String username) {
        Address exist = addressMapper.findByAid(aid);
        if(exist == null)throw new AddressNotFoundException("地址不存在");
        Integer deleteSuccess = addressMapper.deleteByAid(aid);
        if(deleteSuccess != 1)throw new DeleteException("删除地址数据库操作过程中出现异常");
        if(exist.getIsDefault() == 1){
            Address lastModified = addressMapper.findLastModified(uid);
            if(lastModified != null)addressMapper.updateDefaultByAid(lastModified.getAid(), username, new Date());
        }
    }
}
