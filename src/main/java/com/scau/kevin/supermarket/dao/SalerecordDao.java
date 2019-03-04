package com.scau.kevin.supermarket.dao;

import com.scau.kevin.supermarket.entity.Salerecord;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SalerecordDao {
    int deleteByPrimaryKey(Long srId);

    int insert(Salerecord record);

    int insertSelective(Salerecord record);

    Salerecord selectByPrimaryKey(Long srId);

    int updateByPrimaryKeySelective(Salerecord record);

    int updateByPrimaryKey(Salerecord record);

    List<Salerecord> listByFactors(Map<String,Object> map);

    List<Salerecord> listSalerecords();

    Long listSalerecords_COUNT();

    List<Salerecord> listSalerecords2();
}