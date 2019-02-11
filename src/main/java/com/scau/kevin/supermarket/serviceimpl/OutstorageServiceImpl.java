package com.scau.kevin.supermarket.serviceimpl;

import com.scau.kevin.supermarket.dao.OutstorageDao;
import com.scau.kevin.supermarket.entity.Goodsstock;
import com.scau.kevin.supermarket.entity.Outstorage;
import com.scau.kevin.supermarket.entity.Staff;
import com.scau.kevin.supermarket.service.GoodsstockService;
import com.scau.kevin.supermarket.service.OutstorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: kevin
 * @Date: 2019/2/8 16:43
 * @Version 1.0
 */
@Service
public class OutstorageServiceImpl implements OutstorageService {
    @Autowired
    private GoodsstockService goodsstockService;

    @Autowired
    private OutstorageDao outstorageDao;

    @Override
    public boolean insertOutstorage(Staff staff, Outstorage outstorage) {
        outstorage.setOsOperatorName(staff.getStaffName());
        outstorage.setOsOperatorId(staff.getStaffId());
        outstorage.setOsDate(new Date(System.currentTimeMillis()));
        Goodsstock goodsstock = goodsstockService.getById(outstorage.getGoodsId());
        int stockNumber = goodsstock.getGsNumber();
        outstorage.setOsLeftnumber(stockNumber - outstorage.getOsNumber());
        outstorageDao.insertSelective(outstorage);
        return true;
    }

    @Override
    public Outstorage updateOutstorage(Outstorage outstorage) {
        return null;
    }

    @Override
    public Outstorage deleteOutstorage(Outstorage outstorage) {
        return null;
    }

    @Override
    public List<Outstorage> listOutstorage() {
        return null;
    }

    @Override
    public List<Outstorage> listOutstorageByFactors(String operatorName, Long goodsId, String goodsName, String beginTime, String endTime, String destination) {
        Map<String, Object> map = new HashMap<>();
        map.put("operatorName",operatorName);
        map.put("goodsId",goodsId);
        map.put("goodsName",goodsName);
        map.put("beginTime",beginTime);
        map.put("endTime",endTime);
        map.put("destination",destination);
        return outstorageDao.listOutstorageByFactors(map);
    }
}
