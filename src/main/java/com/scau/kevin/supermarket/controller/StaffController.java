package com.scau.kevin.supermarket.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scau.kevin.supermarket.entity.Staff;
import com.scau.kevin.supermarket.result.Result;
import com.scau.kevin.supermarket.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: kevin
 * @Date: 2019/1/18 23:04
 * @Version 1.0
 */
@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    // 添加
    @RequestMapping("/add")
    @ResponseBody
    public Result<Staff> add(Staff staff){
        staffService.insertStaff(staff);
        return Result.success(staff);
    }

    // 修改员工信息
    @RequestMapping("/update")
    @ResponseBody
    public Result<Staff> update(Staff staff){
        Staff staff1 = staffService.updateStaff(staff);
        return Result.success(staff1);
    }

    // 查看员工信息
    @RequestMapping("/to_list")
    @ResponseBody
    public Result<PageInfo> toList(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Staff> staffs = staffService.listStaffs();
        PageInfo<Staff> staffPageInfo = new PageInfo<>(staffs);
        return Result.success(staffPageInfo);
    }
    @RequestMapping("/to_list2")
    @ResponseBody
    public Result<PageInfo> toListByFactors(int pageNum, int pageSize, String orderby, String staffName,
                                            String staffType, String beginDate, String endDate){
        PageHelper.startPage(pageNum,pageSize,orderby);
        List<Staff> staffs = staffService.listStaffsByFactors(staffName,staffType,beginDate,endDate);
        PageInfo<Staff> staffPageInfo = new PageInfo<>(staffs);
        return Result.success(staffPageInfo);
    }
}
