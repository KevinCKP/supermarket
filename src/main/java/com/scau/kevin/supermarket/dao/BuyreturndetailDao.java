package com.scau.kevin.supermarket.dao;

import com.scau.kevin.supermarket.entity.Buyreturndetail;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BuyreturndetailDao {
    int deleteByPrimaryKey(Long brdId);

    int insert(Buyreturndetail record);

    int insertSelective(Buyreturndetail record);

    Buyreturndetail selectByPrimaryKey(Long brdId);

    int updateByPrimaryKeySelective(Buyreturndetail record);

    int updateByPrimaryKey(Buyreturndetail record);

    int insertList(List<Buyreturndetail> buyreturndetails);
}