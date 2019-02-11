package com.scau.kevin.supermarket.service;

import com.scau.kevin.supermarket.entity.Instorage;
import com.scau.kevin.supermarket.entity.Staff;

import java.util.List;

/**
 * @Author: kevin
 * @Date: 2019/2/8 16:11
 * @Version 1.0
 */
public interface InstorageService {
    boolean insertInstorage(Staff staff, Instorage instorage);

    Instorage updateInstorage(Instorage instorage);

    boolean deleteInstorage(Long instorageId);

    List<Instorage> listInstorage();

    List<Instorage> listInstorageByFactors(String operatorName, String goodsName, Long goodsId, String beginTime, String endTime);

}
