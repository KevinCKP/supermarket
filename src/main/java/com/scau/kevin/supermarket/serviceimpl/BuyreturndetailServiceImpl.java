package com.scau.kevin.supermarket.serviceimpl;

import com.scau.kevin.supermarket.dao.BuyreturndetailDao;
import com.scau.kevin.supermarket.entity.Buyreturndetail;
import com.scau.kevin.supermarket.service.BuyreturndetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: kevin
 * @Date: 2019/1/30 18:14
 * @Version 1.0
 */
@Service
public class BuyreturndetailServiceImpl implements BuyreturndetailService {
    @Autowired
    private BuyreturndetailDao buyreturndetailDao;


    @Override
    public boolean insertBuyreturndetail(List<Buyreturndetail> buyreturndetails) {
        return false;
    }

    @Override
    public boolean updateBuyreturndetail(List<Buyreturndetail> buyreturndetails) {
        return false;
    }

    @Override
    public boolean deleteBuyreturndetail(List<Buyreturndetail> buyreturndetails) {
        return false;
    }
}
