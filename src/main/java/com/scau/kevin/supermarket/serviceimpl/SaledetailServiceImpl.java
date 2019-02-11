package com.scau.kevin.supermarket.serviceimpl;

import com.scau.kevin.supermarket.dao.SaledetailDao;
import com.scau.kevin.supermarket.entity.Saledetail;
import com.scau.kevin.supermarket.service.SaledetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: kevin
 * @Date: 2019/1/1 17:00
 * @Version 1.0
 */
@Service
public class SaledetailServiceImpl implements SaledetailService {
    @Autowired
    private SaledetailDao saledetailDao;
    @Override
    @Transactional
    public boolean insertSaledetails(List<Saledetail> saledetails) {
        return saledetailDao.insertSaledetails(saledetails) > 0;
    }
}
