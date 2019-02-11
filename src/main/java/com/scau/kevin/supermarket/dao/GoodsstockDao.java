package com.scau.kevin.supermarket.dao;

import com.scau.kevin.supermarket.entity.Goodsstock;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GoodsstockDao {
    int deleteByPrimaryKey(Long gsId);

    int insert(Goodsstock record);

    int insertSelective(Goodsstock record);

    Goodsstock selectByPrimaryKey(Long gsId);

    int updateByPrimaryKeySelective(Goodsstock record);

    int updateByPrimaryKey(Goodsstock record);

    List<Goodsstock> listUnderWarning();

    List<Goodsstock> listGoodsstock();

    List<Goodsstock> listGoodsstockByFactors(Map<String, Object> map);
}