package com.scau.kevin.supermarket.service;

import com.scau.kevin.supermarket.entity.Outstorage;
import com.scau.kevin.supermarket.entity.Staff;

import java.util.List;

/**
 * @Author: kevin
 * @Date: 2019/2/8 16:41
 * @Version 1.0
 */
public interface OutstorageService {
    boolean insertOutstorage(Staff staff, Outstorage outstorage);

    Outstorage updateOutstorage(Outstorage outstorage);

    Outstorage deleteOutstorage(Outstorage outstorage);

    List<Outstorage> listOutstorage();

    List<Outstorage> listOutstorageByFactors(String operatorName, Long goodsId, String goodsName, String beginTime, String endTime, String destination);
}
