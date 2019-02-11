package com.scau.kevin.supermarket.service;

import com.scau.kevin.supermarket.entity.Goods;
import com.scau.kevin.supermarket.entity.Supplier;

import java.util.List;
import java.util.Map;

/**
 * @Author: kevin
 * @Date: 2018/12/29 15:14
 * @Version 1.0
 */
public interface GoodsService {
    //添加商品信息
    Goods insertGoods(Goods goods);

    //修改商品信息
    Goods updateGoods(Goods goods);

    //删除商品信息
    boolean deleteGoods(Goods goods);

    //查询商品信息

    List<Goods> listByFactors(Map<String,Object> map);

    List<Goods> listGoods();

    List<Goods> listBySupplier(Supplier supplier);

    Goods getById(Long goodsId);

    void updateGoodsState(Long goodsId, Byte goodsState);

    List<Goods> listByFactors(String goodsCategory, Byte goodsState, String goodsName, String beginTime,
                              String endTime);
}
