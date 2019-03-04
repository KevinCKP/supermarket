package com.scau.kevin.supermarket.dao;

import com.scau.kevin.supermarket.entity.Saledetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaledetailDao {
    int deleteByPrimaryKey(Long sdId);

    int insert(Saledetail record);

    int insertSelective(Saledetail record);

    Saledetail selectByPrimaryKey(Long sdId);

    int updateByPrimaryKeySelective(Saledetail record);

    int updateByPrimaryKey(Saledetail record);

    int insertSaledetails(@Param("saledetails") List<Saledetail> saledetails);
}