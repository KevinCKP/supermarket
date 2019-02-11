package com.scau.kevin.supermarket.serviceimpl;

import com.scau.kevin.supermarket.dao.BuydetailDao;
import com.scau.kevin.supermarket.entity.Buydetail;
import com.scau.kevin.supermarket.service.BuydetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: kevin
 * @Date: 2018/12/30 17:01
 * @Version 1.0
 */
@Service
public class BuydetailServiceImpl implements BuydetailService {
    @Autowired
    private BuydetailDao buydetailDao;

    @Override
    @Transactional
    public boolean insertBuydetail(List<Buydetail> buydetails) {
        buydetailDao.insertAllBuydetails((ArrayList<Buydetail>) buydetails);

        return false;
    }

    @Override
    public boolean updateBuydetail(List<Buydetail> buydetails) {
        return false;
    }

    @Override
    public boolean deleteBuydetail(List<Buydetail> buydetails) {
        return false;
    }
}
