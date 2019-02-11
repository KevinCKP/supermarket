package com.scau.kevin.supermarket.service;

import com.scau.kevin.supermarket.entity.Buyreturn;
import com.scau.kevin.supermarket.entity.Staff;

import java.util.List;

/**
 * @Author: kevin
 * @Date: 2019/1/30 17:06
 * @Version 1.0
 */
public interface BuyreturnService {

    // 插入采购退货单
    boolean insertBuyreturn(Staff staff, Buyreturn buyreturn);

    // 修改采购订货单
    boolean updateBuyreturn(Buyreturn buyreturn);

    // 删除采购订单货
    boolean deleteBuyreturn(Long buyreturnId);


    // 条件查询采购订货单
    List<Buyreturn> listByFactors(String supplierName, String staffName, String beginTime, String endTime);

    // 查询所有采购退货详情
    List<Buyreturn> listBuyreturn();

    void updateState(Long brId, Byte brState);
}
