package com.scau.kevin.supermarket.serviceimpl;

import com.scau.kevin.supermarket.dao.InstorageDao;
import com.scau.kevin.supermarket.entity.Goodsstock;
import com.scau.kevin.supermarket.entity.Instorage;
import com.scau.kevin.supermarket.entity.Staff;
import com.scau.kevin.supermarket.service.GoodsstockService;
import com.scau.kevin.supermarket.service.InstorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: kevin
 * @Date: 2019/2/8 16:13
 * @Version 1.0
 */
@Service
public class InstorageServiceImpl implements InstorageService {
    @Autowired
    private InstorageDao instorageDao;
    @Autowired
    private GoodsstockService goodsstockService;
    @Override
    public boolean insertInstorage(Staff staff, Instorage instorage) {
        instorage.setIsOperatorId(staff.getStaffId());
        instorage.setIsOperatorName(staff.getStaffName());
        instorage.setIsTime(new Date(System.currentTimeMillis()));
        Goodsstock goodsstock = goodsstockService.getById(instorage.getGoodsId());
        int stockNumber = goodsstock.getGsNumber();
        instorage.setIsAfternumber(stockNumber + instorage.getIsNumber());
        goodsstock.setGsNumber(instorage.getIsAfternumber());
        BigDecimal price = instorage.getIsGoodsPrice();
        BigDecimal number = new BigDecimal(instorage.getIsNumber());
        instorage.setIsGoodsTotal(price.multiply(number));
        instorageDao.insertSelective(instorage);
        goodsstockService.updateGoodsstock(goodsstock);
        return true;
    }

    @Override
    public Instorage updateInstorage(Instorage instorage) {
        return null;
    }

    @Override
    public boolean deleteInstorage(Long instorageId) {
        return false;
    }

    @Override
    public List<Instorage> listInstorage() {
        return instorageDao.listInstorage();
    }

    @Override
    public List<Instorage> listInstorageByFactors(String operatorName, String goodsName, Long goodsId, String beginTime, String endTime) {
        Map<String,Object> map = new HashMap<>();
        map.put("operatorName",operatorName);
        map.put("goodsId",goodsId);
        map.put("goodsName",goodsName);
        map.put("beginTime",beginTime);
        map.put("endTime",endTime);
        return instorageDao.listInstorageByFactors(map);
    }
}
