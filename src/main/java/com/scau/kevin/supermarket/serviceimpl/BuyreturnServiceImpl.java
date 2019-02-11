package com.scau.kevin.supermarket.serviceimpl;

import com.scau.kevin.supermarket.dao.BuyreturnDao;
import com.scau.kevin.supermarket.entity.Buyreturn;
import com.scau.kevin.supermarket.entity.Staff;
import com.scau.kevin.supermarket.service.BuyreturnService;
import com.scau.kevin.supermarket.service.BuyreturndetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: kevin
 * @Date: 2019/1/30 18:13
 * @Version 1.0
 */
@Service
public class BuyreturnServiceImpl implements BuyreturnService {

    @Autowired
    private BuyreturndetailService buyreturndetailService;

    @Autowired
    private BuyreturnDao buyreturnDao;

    @Override
    public boolean insertBuyreturn(Staff staff, Buyreturn buyreturn) {
        buyreturn.setBrCreateTime(new Date(System.currentTimeMillis()));
        buyreturn.setBrOperatorId(staff.getStaffId());
        buyreturn.setBrOperatorName(staff.getStaffName());
        buyreturnDao.insert(buyreturn);
        buyreturndetailService.insertBuyreturndetail(buyreturn.getBuyreturndetails());
        return true;
    }

    @Override
    public boolean updateBuyreturn(Buyreturn buyreturn) {
        return false;
    }

    @Override
    public boolean deleteBuyreturn(Long buyreturnId) {
        return false;
    }

    @Override
    public List<Buyreturn> listByFactors(String supplierName, String staffName, String beginTime, String endTime) {
        Map<String,Object> map = new HashMap<>();
        map.put("supplierName",supplierName);
        map.put("staffName",staffName);
        map.put("beginTime",beginTime);
        map.put("endTime",endTime);
        return buyreturnDao.listBuyreturnByFactors(map);
    }

    @Override
    public List<Buyreturn> listBuyreturn() {
        return buyreturnDao.listBuyreturn();
    }

    @Override
    public void updateState(Long brId, Byte brState) {

    }

}
