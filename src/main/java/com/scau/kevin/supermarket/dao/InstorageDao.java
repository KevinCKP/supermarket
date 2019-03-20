package com.scau.kevin.supermarket.dao;

import com.scau.kevin.supermarket.entity.Instorage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface InstorageDao {
    int deleteByPrimaryKey(Long isId);

    int insert(Instorage record);

    int insertSelective(Instorage record);

    Instorage selectByPrimaryKey(Long isId);

    int updateByPrimaryKeySelective(Instorage record);

    int updateByPrimaryKey(Instorage record);

    List<Instorage> listInstorage();

    List<Instorage> listInstorageByFactors(Map<String,Object> map);

    Instorage updateNote(@Param("isId") Long isId, @Param("isNote") String isNote);
}