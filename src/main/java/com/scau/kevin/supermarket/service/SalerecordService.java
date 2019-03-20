package com.scau.kevin.supermarket.service;

import com.scau.kevin.supermarket.dto.ProfitTotalDto;
import com.scau.kevin.supermarket.dto.QueryDto;
import com.scau.kevin.supermarket.entity.Salerecord;
import com.scau.kevin.supermarket.entity.Staff;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author: kevin
 * @Date: 2018/12/30 23:33
 * @Version 1.0
 */
public interface SalerecordService {

    //查询所有销售订单
    List<Salerecord> listSalerecords();

    //按id查询销售订单
    Salerecord getById(Long id);

    //按日期查询销售订单
    List<Salerecord> listByTime(Timestamp time);

    //查询某段时间内的销售订单
    List<Salerecord> listByTime(Timestamp begin,Timestamp end);

    //查询某个员工销售的销售订单
    List<Salerecord> listByStaff(Staff staff);

    List<Salerecord> listByFactors(Timestamp begin,Timestamp end, String salesman);


    //新增销售订单
    boolean sellGoods(Salerecord salerecord, Staff staff);

    Long listSalerecords_COUNT();

    List<Salerecord> listSalerecords2();

    List<Salerecord> listSalerecordsByFactor(QueryDto queryDto);

    List<Salerecord> listByFactors_COUNT(QueryDto queryDto);

    List<ProfitTotalDto> countByMonth(String time);

    List<ProfitTotalDto> countByYear(String s);

    List<ProfitTotalDto> countGoodsByYear(String time, Long goodsId);

    List<ProfitTotalDto> countGoodsByMonth(String time, Long goodsId);
}
