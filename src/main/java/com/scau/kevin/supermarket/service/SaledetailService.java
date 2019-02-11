package com.scau.kevin.supermarket.service;

import com.scau.kevin.supermarket.entity.Saledetail;

import java.util.List;

/**
 * @Author: kevin
 * @Date: 2018/12/30 23:55
 * @Version 1.0
 */
public interface SaledetailService {
    //插入销售详情
    boolean insertSaledetails(List<Saledetail> saledetails);

}
