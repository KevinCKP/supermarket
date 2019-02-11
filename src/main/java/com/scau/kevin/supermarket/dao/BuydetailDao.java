package com.scau.kevin.supermarket.dao;

import com.scau.kevin.supermarket.entity.Buydetail;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface BuydetailDao {
    int deleteByPrimaryKey(Long bdId);

    int insert(Buydetail record);

    int insertSelective(Buydetail record);

    Buydetail selectByPrimaryKey(Long bdId);

    int updateByPrimaryKeySelective(Buydetail record);

    int updateByPrimaryKey(Buydetail record);

    int insertAllBuydetails(ArrayList<Buydetail> buydetails);
}