package com.scau.kevin.supermarket.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scau.kevin.supermarket.entity.Staff;
import com.scau.kevin.supermarket.entity.Supplier;
import com.scau.kevin.supermarket.result.Result;
import com.scau.kevin.supermarket.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: kevin
 * @Date: 2019/1/7 16:34
 * @Version 1.0
 */
@Controller
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    // 添加供应商信息
    @RequestMapping("/add")
    @ResponseBody
    public Result<Supplier> insertSupplier(Supplier supplier){
        System.out.println(supplier.getSupplierAddress());
        System.out.println(supplier.getSupplierLinkman());
        supplierService.insertSupplier(supplier);
        return Result.success(supplier);
    }

    //修改供应商信息
    @RequestMapping("/update")
    @ResponseBody
    public Result<Supplier> updateSupplier(Supplier supplier){
        Supplier ret = supplierService.updateSupplier(supplier);
        return Result.success(ret);
    }

    //删除供应商信息
    @RequestMapping("/delete/{supplierId}")
    @ResponseBody
    public Result<Boolean> deleteSupplier(Staff staff, Long supplierId){
        supplierService.deleteSupplier(staff,supplierId);
        return Result.success(true);
    }


    //查询供应商信息
    @RequestMapping("/detail/{supplierId}")
    @ResponseBody
    public Result<Supplier> getById(Long supplierId){
        Supplier supplier = supplierService.getById(supplierId);
        return Result.success(supplier);
    }
    // 查询供应商信息
    @RequestMapping("/to_list")
    @ResponseBody
    public Result<PageInfo> supplierToList(int pageNum, int pageSize, String orderby){
        PageHelper.startPage(pageNum,pageSize,orderby);
        List<Supplier> suppliers = supplierService.listSupplier();
        PageInfo<Supplier> supplierPageInfo = new PageInfo<>(suppliers);
        return Result.success(supplierPageInfo);
    }
    // 按条件查询供应商信息
    @RequestMapping("/to_list2")
    public Result<PageInfo> toListByFactors(int pageNum, int pageSize, String orderby,
                                            String supplierName, String supplierLinkman,String beginTime,
                                            String endTime){
        PageHelper.startPage(pageNum,pageSize,orderby);
        List<Supplier> suppliers = supplierService.listSupplierByFactors(supplierName,supplierLinkman,beginTime,endTime);
        PageInfo<Supplier> supplierPageInfo = new PageInfo<>(suppliers);
        return Result.success(supplierPageInfo);
    }


}
