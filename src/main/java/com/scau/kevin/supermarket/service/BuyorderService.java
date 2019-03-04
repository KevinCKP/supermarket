package com.scau.kevin.supermarket.service;

import com.scau.kevin.supermarket.entity.Buyorder;
import com.scau.kevin.supermarket.entity.Staff;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @Author: kevin
 * @Date: 2018/12/30 0:44
 * @Version 1.0
 */
public interface BuyorderService {
    //查询所有订单
    List<Buyorder> listBuyorder();
    //查询未审核或已审核订单
    List<Buyorder> listByState(Byte state);

    //查询某一段时间内的订单
    List<Buyorder> listByTime(Timestamp begin,Timestamp end);

    //按id查询订单
    Buyorder getById(Long id);

    //查询某个员工的订单
    List<Buyorder> listByStaff(Staff staff);

    //生成订单
    boolean insertBuyorder(Staff staff, Buyorder buyorder);

    //修改订单
    Buyorder updateBuyorder(Staff staff, Buyorder buyorder);

    List<Buyorder> listByFactors(Map<String,Object> map);

    Boolean asseror(Staff staff, Long buyorderId);

    List<Buyorder> listBuyorder_COUNT();
}
