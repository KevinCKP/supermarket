package com.scau.kevin.supermarket.serviceimpl;

import com.scau.kevin.supermarket.dao.SupplierDao;
import com.scau.kevin.supermarket.dto.QueryDto;
import com.scau.kevin.supermarket.entity.Staff;
import com.scau.kevin.supermarket.entity.Supplier;
import com.scau.kevin.supermarket.exception.GlobalException;
import com.scau.kevin.supermarket.result.CodeMessage;
import com.scau.kevin.supermarket.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: kevin
 * @Date: 2019/1/4 14:56
 * @Version 1.0
 */
@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierDao supplierDao;
    @Override
    public Supplier insertSupplier(Supplier supplier) {
        if(supplier.getSupplierId() != null){
            if(supplierDao.selectByPrimaryKey(supplier.getSupplierId()) != null){
                throw new GlobalException(CodeMessage.ID_EXISTS);
            }
        }
        supplier.setSupplierCreateTime(new Date(System.currentTimeMillis()));
        supplier.setSupplierUpdateTime(new Date(System.currentTimeMillis()));
        try {
            supplierDao.insert(supplier);
        }catch (Exception e){
            throw new GlobalException(CodeMessage.ID_EXISTS);
        }

        return supplier;
    }

    @Override
    public Supplier updateSupplier(Supplier supplier) {
        supplierDao.updateByPrimaryKeySelective(supplier);
        return supplier;
    }

    @Override
    public Supplier deleteSupplier(Staff staff, Long supplierId) {
        supplierDao.deleteByPrimaryKey(supplierId);
        return null;
    }

    @Override
    public List<Supplier> listSupplier() {
       return supplierDao.listSupplier();
    }

    @Override
    public Supplier getById(Long supplierId) {
        return supplierDao.selectByPrimaryKey(supplierId);
    }

    @Override
    public List<Supplier> listSupplierByFactors(String supplierName, String supplierLinkman,
                                                String beginTime, String endTime) {
        Map<String,Object> map = new HashMap<>();
        map.put("supplierName",supplierName);
        map.put("supplierLinkman",supplierLinkman);
        map.put("beginTime",beginTime);
        map.put("endTime", endTime);
        List<Supplier> suppliers = supplierDao.listByFactors(map);
        return suppliers;
    }

    @Override
    public List<Supplier> listSupplierByFactor(QueryDto queryDto) {
        return supplierDao.listByFactor(queryDto);
    }
}
