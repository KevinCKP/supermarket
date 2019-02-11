package com.scau.kevin.supermarket.service;

import com.scau.kevin.supermarket.entity.Buyreturndetail;

import java.util.List;

/**
 * @Author: kevin
 * @Date: 2019/1/30 18:04
 * @Version 1.0
 */
public interface BuyreturndetailService {

    //插入订单详情
    boolean insertBuyreturndetail(List<Buyreturndetail> buyreturndetails);
    //修改订单详情
    boolean updateBuyreturndetail(List<Buyreturndetail> buyreturndetails);
    //删除订单详情
    boolean deleteBuyreturndetail(List<Buyreturndetail> buyreturndetails);
}
