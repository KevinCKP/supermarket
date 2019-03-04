package com.scau.kevin.supermarket.dao;

import com.scau.kevin.supermarket.dto.QueryDto;
import com.scau.kevin.supermarket.entity.Goods;
import org.apache.ibatis.annotations.Param;
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

    Integer goodsIsExisted(Long goodsId);


    int updateGoodsState(@Param("goodsId") Long goodsId,@Param("goodsState") Byte goodsState);

    List<Goods> listByFactors(Map<String,Object> map);

    List<Goods> listGoods();

    List<Goods> listByFactor(QueryDto queryDto);
}