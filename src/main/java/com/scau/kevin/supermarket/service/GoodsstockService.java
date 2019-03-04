package com.scau.kevin.supermarket.service;

import com.scau.kevin.supermarket.entity.Goodsstock;

import java.util.List;

/**
 * @Author: kevin
 * @Date: 2019/1/12 19:14
 * @Version 1.0
 */
public interface GoodsstockService {
    boolean insertGoodsstock(Goodsstock goodsstock);

    Goodsstock setWarnNum(Long goodsId, int warnNumber);

    Goodsstock updateGoodsstock(Goodsstock goodsstock);

    boolean initGoodsstock(Long goodsId);

    Goodsstock getById(Long goodsId);

    List<Goodsstock> listUnderWarning();

    List<Goodsstock> listGoodsstock();

    List<Goodsstock> listGoodsstockByFactors(String goodsName, Long goodsId, Integer less, Integer most);

    List<Goodsstock> listSetWarning();

    List<Goodsstock> listUponWarning();

    void updateWarnNumber(Long goodsId, Integer gsWarnNumber);
}
