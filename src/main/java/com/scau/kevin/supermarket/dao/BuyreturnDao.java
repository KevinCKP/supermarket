package com.scau.kevin.supermarket.dao;

import com.scau.kevin.supermarket.entity.Buyreturn;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BuyreturnDao {
    int deleteByPrimaryKey(Long brId);

    int insert(Buyreturn record);

    int insertSelective(Buyreturn record);

    Buyreturn selectByPrimaryKey(Long brId);

    int updateByPrimaryKeySelective(Buyreturn record);

    int updateByPrimaryKey(Buyreturn record);

    List<Buyreturn> listBuyreturn();

    List<Buyreturn> listBuyreturnByFactors(Map<String,Object> map);
}