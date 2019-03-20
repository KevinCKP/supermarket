package com.scau.kevin.supermarket.service;

import com.scau.kevin.supermarket.entity.Buydetail;

import java.util.List;

/**
 * @Author: kevin
 * @Date: 2018/12/30 16:59
 * @Version 1.0
 */
public interface BuydetailService {
    //插入订单详情
    boolean insertBuydetail(List<Buydetail> buydetails);
    //修改订单详情
    boolean updateBuydetails(List<Buydetail> buydetails);
    //删除订单详情
    boolean deleteBuydetail(List<Buydetail> buydetails);

    int updateBuydetail(Buydetail buydetail);
}
