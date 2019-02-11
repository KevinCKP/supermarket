package com.scau.kevin.supermarket.dao;

import com.scau.kevin.supermarket.entity.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GoodsDao {
    int deleteByPrimaryKey(Long goodsId);

    int insert(Goods goods);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Long goodsId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    int goodsIsExisted(Long goodsId);


    int updateGoodsState(Long goodsId, Byte goodsState);

    List<Goods> listByFactors(Map<String,Object> map);

    List<Goods> listGoods();
}