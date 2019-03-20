package com.scau.kevin.supermarket.dao;

import com.scau.kevin.supermarket.dto.QueryDto;
import com.scau.kevin.supermarket.entity.Staff;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffDao {
    int deleteByPrimaryKey(Long staffId);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Long staffId);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);

    Staff getByIdAndPassword(@Param("staffId") Long staffId, @Param("password") String password);

    List<Staff> listStaffs();

    List<Staff> listStaffsByFactors(QueryDto queryDto);
}