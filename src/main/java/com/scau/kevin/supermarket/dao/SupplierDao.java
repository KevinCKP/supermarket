package com.scau.kevin.supermarket.dao;

import com.scau.kevin.supermarket.entity.Supplier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SupplierDao {
    int deleteByPrimaryKey(Long supplierId);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    Supplier selectByPrimaryKey(Long supplierId);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);

    List<Supplier> listByFactors(Map<String,Object> map);

    List<Supplier> listSupplier();
}