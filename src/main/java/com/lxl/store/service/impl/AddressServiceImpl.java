package com.lxl.store.service.impl;

import com.lxl.store.entity.Address;
import com.lxl.store.exception.AddressCountLimitException;
import com.lxl.store.exception.InsertException;
import com.lxl.store.mapper.AddressMapper;
import com.lxl.store.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author LiXianLei
 * @time 2022/01/24 17:22
 */
@Service
public class AddressServiceImpl implements IAddressService {
    private AddressMapper addressMapper;

    @Value("${user.address.max-count}")
    private Integer maxCount;

    @Autowired
    public void setAddressMapper(AddressMapper addressMapper){
        this.addressMapper = addressMapper;
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

        Integer rows = addressMapper.insert(address);
        if(rows != 1){
            throw new InsertException("在地址插入的过程中产生了未知的异常");
        }
    }
}
