package com.scau.kevin.supermarket.service;

import com.scau.kevin.supermarket.dto.QueryDto;
import com.scau.kevin.supermarket.entity.Staff;
import com.scau.kevin.supermarket.entity.Supplier;

import java.util.List;

/**
 * @Author: kevin
 * @Date: 2018/12/29 15:27
 * @Version 1.0
 */
public interface SupplierService {
    //添加供应商信息
    Supplier insertSupplier(Supplier supplier);

    //修改供应商信息
    Supplier updateSupplier(Supplier supplier);

    //删除供应商信息
    Supplier deleteSupplier(Staff staff, Long supplierId);

    //查询供应商信息
    List<Supplier> listSupplier();

    Supplier getById(Long supplierId);

    List<Supplier> listSupplierByFactors(String supplierName, String supplierLinkman, String beginTime, String endTime);

    List<Supplier> listSupplierByFactor(QueryDto queryDto);
}
