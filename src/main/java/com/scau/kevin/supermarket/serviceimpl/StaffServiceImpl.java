package com.scau.kevin.supermarket.serviceimpl;

import com.scau.kevin.supermarket.dao.StaffDao;
import com.scau.kevin.supermarket.dto.QueryDto;
import com.scau.kevin.supermarket.entity.Staff;
import com.scau.kevin.supermarket.exception.GlobalException;
import com.scau.kevin.supermarket.result.CodeMessage;
import com.scau.kevin.supermarket.service.StaffService;
import com.scau.kevin.supermarket.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: kevin
 * @Date: 2019/1/14 20:09
 * @Version 1.0
 */
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;
    @Override
    public boolean insertStaff(Staff staff) {
        if(staff.getStaffId() == null){
            throw new GlobalException(CodeMessage.ID_EMPTY);
        } else if(staffDao.selectByPrimaryKey(staff.getStaffId()) != null){
            throw new GlobalException(CodeMessage.ID_EXISTS);
        }
        if (staff.getStaffPassword() != null){
            if (staff.getStaffPassword().length() < 6){
                throw new GlobalException(CodeMessage.PASSWORD_LENGTH_SHORT);
            }
            String newPassword = MD5Util.md5(staff.getStaffPassword());
            staff.setStaffPassword(newPassword);
        }
        staff.setStaffCreateTime(new Date(System.currentTimeMillis()));
        staff.setStaffUpdateTime(new Date(System.currentTimeMillis()));
        staffDao.insert(staff);
        return true;
    }

    @Override
    public boolean deleteStaff(Long staffId) {
        return false;
    }

    @Override
    public Staff updateStaff(Staff staff) {
        staffDao.updateByPrimaryKey(staff);
        return staffDao.selectByPrimaryKey(staff.getStaffId());
    }

    @Override
    public List<Staff> selectByFactors(Map<String, Object> map) {
        return null;
    }

    @Override
    public Staff login(String staffId, String password) {
        System.out.println(staffId);
//        if(!staffId.matches("[0-9],{1,}")){
//            throw new GlobalException(CodeMessage.LOGIN_ERROR);
//        }
        // 获得加密后的密码
        String newPassword = MD5Util.md5(password);

        // 查询是否有账号和密码匹配的用户
        Staff staff = staffDao.getByIdAndPassword(Long.valueOf(staffId),newPassword);
        if (staff == null){
            throw new GlobalException(CodeMessage.LOGIN_ERROR);
        } else if (staff.getStaffRole() != null && staff.getStaffRole() == 0) {
            throw new GlobalException(CodeMessage.NO_LOGIN_PERMISSION);
        }
        staff.setStaffPassword(null);
        return staff;
    }

    @Override
    public List<Staff> listStaffs() {
        return staffDao.listStaffs();
    }

    // 条件查询
    @Override
    public List<Staff> listStaffsByFactors(QueryDto queryDto) {
        List<Staff> staffs = staffDao.listStaffsByFactors(queryDto);
        return staffs;
    }
}
