package com.scau.kevin.supermarket.dao;

import com.scau.kevin.supermarket.dto.QueryDto;
import com.scau.kevin.supermarket.entity.Buyorder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyorderDao {
    int deleteByPrimaryKey(Long boId);

    int insert(Buyorder record);

    int insertSelective(Buyorder record);

    Buyorder selectByPrimaryKey(Long boId);

    int updateByPrimaryKeySelective(Buyorder record);

    int updateByPrimaryKey(Buyorder record);

    List<Buyorder> listByFactors(QueryDto queryDto);

    List<Buyorder> listByFactors_COUNT(QueryDto queryDto);

    List<Buyorder> listBuyorder();

    List<Buyorder> listBuyorder_COUNT();
}