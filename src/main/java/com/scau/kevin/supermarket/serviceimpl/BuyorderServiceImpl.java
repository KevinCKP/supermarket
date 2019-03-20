package com.scau.kevin.supermarket.serviceimpl;

import com.scau.kevin.supermarket.dao.BuyorderDao;
import com.scau.kevin.supermarket.dto.QueryDto;
import com.scau.kevin.supermarket.entity.Buydetail;
import com.scau.kevin.supermarket.entity.Buyorder;
import com.scau.kevin.supermarket.entity.Staff;
import com.scau.kevin.supermarket.exception.GlobalException;
import com.scau.kevin.supermarket.result.CodeMessage;
import com.scau.kevin.supermarket.service.BuydetailService;
import com.scau.kevin.supermarket.service.BuyorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: kevin
 * @Date: 2018/12/30 12:21
 * @Version 1.0
 */
@Service
public class BuyorderServiceImpl implements BuyorderService {
    @Autowired
    private BuyorderDao buyorderDao;
    @Autowired
    private BuydetailService buydetailService;


    @Override
    public List<Buyorder> listBuyorder() {
        Map<String,Object> map = new HashMap<>();
    //    String beginTime = "2018-12-30 00:00:00";
       // String endTime = "2018-12-31 00:00:00";
      //  map.put("beginTime",beginTime);
      //  map.put("endTime",endTime);
        return buyorderDao.listBuyorder();
    }


    @Override
    public List<Buyorder> listByState(Byte state) {
        return null;
    }

    @Override
    public List<Buyorder> listByTime(Timestamp begin, Timestamp end) {
        return null;
    }


    @Override
    public Buyorder getById(Long id) {
        Buyorder buyorder = buyorderDao.selectByPrimaryKey(id);
        if(buyorder == null){
            throw new GlobalException(CodeMessage.ID_EMPTY);
        }
        return buyorder;
    }


    @Override
    public List<Buyorder> listByStaff(Staff staff) {
        return null;
    }

    @Override
    @Transactional
    public boolean insertBuyorder(Staff staff, Buyorder buyorder) {
        Long boId = System.currentTimeMillis();
        buyorder.setBoId(boId);
        buyorder.setBoBuyer(staff.getStaffId());
        buyorder.setBoBuyername(staff.getStaffName());
        buyorder.setCreateTime(new Date(System.currentTimeMillis()));
        List<Buydetail> buydetails = buyorder.getBuydetails();
        for(Buydetail buydetail : buydetails){
            buydetail.setBoId(boId);
            BigDecimal bdPrice = buydetail.getBdPrice();
            BigDecimal bdNumber = BigDecimal.valueOf(buydetail.getBdNumber());
            BigDecimal bdTotal = bdPrice.multiply(bdNumber);
            buydetail.setBdTotal(bdTotal);
            buydetail.setBdInNumber(0);
            buydetail.setBdState((byte) 0);
        }
        buyorderDao.insert(buyorder);
        buydetailService.insertBuydetail(buydetails);
        return false;
    }

    @Override
    public Buyorder updateBuyorder(Staff staff, Buyorder buyorder) {
        if(staff == null){
            throw new GlobalException(CodeMessage.PERMISSION_DENIED);
        }
        Buyorder oldBuyorder = buyorderDao.selectByPrimaryKey(buyorder.getBoId());
        if(oldBuyorder.getBoIsfinished() == true) {
            throw new GlobalException(CodeMessage.UPDATE_ERROR);
        }
        buyorderDao.updateByPrimaryKey(buyorder);
        buydetailService.updateBuydetails(buyorder.getBuydetails());
        return getById(buyorder.getBoId());
    }

    @Override
    public List<Buyorder> listByFactors(QueryDto queryDto) {
        return buyorderDao.listByFactors(queryDto);
    }

    @Override
    public Boolean asseror(Staff staff, Long buyorderId) {
        return null;
    }

    @Override
    public List<Buyorder> listBuyorder_COUNT() {
        return buyorderDao.listBuyorder_COUNT();
    }

    @Override
    public void updateBuydetail(Buydetail buydetail) {
        buydetailService.updateBuydetail(buydetail);
    }

    @Override
    @Transactional
    public void deleteBuyorder(Staff staff, Long boId) {
        if(staff == null){
            throw new GlobalException(CodeMessage.PERMISSION_DENIED);
        }
        Buyorder oldBuyorder = buyorderDao.selectByPrimaryKey(boId);
        if(oldBuyorder.getBoIsfinished() == true){
            throw new GlobalException(CodeMessage.UPDATE_ERROR);
        }
        for(int i = 0; i < oldBuyorder.getBuydetails().size(); i++){
            if (oldBuyorder.getBuydetails().get(i).getBdState() == 1){
                throw new GlobalException(CodeMessage.UPDATE_ERROR);
            }
        }
        buyorderDao.deleteByPrimaryKey(oldBuyorder.getBoId());
        buydetailService.deleteBuydetail(oldBuyorder.getBuydetails());
    }

    @Override
    public void listByFactors_COUNT(QueryDto queryDto) {
        buyorderDao.listByFactors_COUNT(queryDto);
    }
}
