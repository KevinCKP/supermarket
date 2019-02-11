package com.scau.kevin.supermarket.dao;

import com.scau.kevin.supermarket.entity.Scrap;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ScrapDao {
    int deleteByPrimaryKey(Long scrapId);

    int insert(Scrap record);

    int insertSelective(Scrap record);

    Scrap selectByPrimaryKey(Long scrapId);

    int updateByPrimaryKeySelective(Scrap record);

    int updateByPrimaryKey(Scrap record);

    int changeState(Long scrapId, Byte scrapState);

    List<Scrap> listScrap();

    List<Scrap> listByFactors(Map<String,Object> map);
}