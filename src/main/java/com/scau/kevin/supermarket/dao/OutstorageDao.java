package com.scau.kevin.supermarket.dao;

import com.scau.kevin.supermarket.entity.Outstorage;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OutstorageDao {
    int deleteByPrimaryKey(Long osId);

    int insert(Outstorage record);

    int insertSelective(Outstorage record);

    Outstorage selectByPrimaryKey(Long osId);

    int updateByPrimaryKeySelective(Outstorage record);

    int updateByPrimaryKey(Outstorage record);

    List<Outstorage> listOutstorage();

    List<Outstorage> listOutstorageByFactors(Map<String,Object> map);
}