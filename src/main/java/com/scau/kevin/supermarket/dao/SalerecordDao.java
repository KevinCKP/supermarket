package com.scau.kevin.supermarket.dao;

import com.scau.kevin.supermarket.dto.ProfitTotalDto;
import com.scau.kevin.supermarket.dto.QueryDto;
import com.scau.kevin.supermarket.entity.Salerecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalerecordDao {
    int deleteByPrimaryKey(Long srId);

    int insert(Salerecord record);

    int insertSelective(Salerecord record);

    Salerecord selectByPrimaryKey(Long srId);

    int updateByPrimaryKeySelective(Salerecord record);

    int updateByPrimaryKey(Salerecord record);

    List<Salerecord> listByFactors(QueryDto queryDto);

    List<Salerecord> listByFactors_COUNT(QueryDto queryDto);

    List<Salerecord> listSalerecords();

    Long listSalerecords_COUNT();

    List<Salerecord> listSalerecords2();

    List<ProfitTotalDto> countTotalByMonth(@Param("time") String time);

    List<ProfitTotalDto> countTotalByYear(@Param("time") String time);

    List<ProfitTotalDto> countGoodsByYear(@Param("time") String time, @Param("goodsId") Long goodsId);

    List<ProfitTotalDto> countGoodsByMonth(@Param("time") String time,@Param("goodsId") Long goodsId);
}