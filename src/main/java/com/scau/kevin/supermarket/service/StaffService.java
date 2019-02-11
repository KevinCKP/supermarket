package com.scau.kevin.supermarket.service;

import com.scau.kevin.supermarket.entity.Staff;

import java.util.List;
import java.util.Map;

/**
 * @Author: kevin
 * @Date: 2018/12/29 15:33
 * @Version 1.0
 */
public interface StaffService {
    boolean insertStaff(Staff staff);

    boolean deleteStaff(Long staffId);

    Staff updateStaff(Staff staff);

    List<Staff> selectByFactors(Map<String, Object> map);

    Staff login(String staffId,String password);

    List<Staff> listStaffs();

    List<Staff> listStaffsByFactors(String staffName, String staffType, String beginDate, String endDate);
}
