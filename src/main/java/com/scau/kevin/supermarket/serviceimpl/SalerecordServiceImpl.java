package com.scau.kevin.supermarket.serviceimpl;

import com.scau.kevin.supermarket.dao.SalerecordDao;
import com.scau.kevin.supermarket.entity.Salerecord;
import com.scau.kevin.supermarket.entity.Staff;
import com.scau.kevin.supermarket.service.SaledetailService;
import com.scau.kevin.supermarket.service.SalerecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: kevin
 * @Date: 2019/1/1 16:40
 * @Version 1.0
 */
@Service
public class SalerecordServiceImpl implements SalerecordService {
    @Autowired
    private SalerecordDao salerecordDao;
    @Autowired
    private SaledetailService saledetailService;

    @Override
    public List<Salerecord> listSalerecords() {
        return salerecordDao.listSalerecords();
    }

    @Override
    public Salerecord getById(Long id) {
        return salerecordDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Salerecord> listByTime(Timestamp time) {
        return null;
    }

    @Override
    public List<Salerecord> listByTime(Timestamp begin, Timestamp end) {
        return null;
    }

    @Override
    public List<Salerecord> listByStaff(Staff staff) {
        return null;
    }

    @Override
    public List<Salerecord> listByFactors(Timestamp begin, Timestamp end, String salesman) {
        Map<String,Object> map = new HashMap<>();
        map.put("beginTime",begin);
        map.put("endTime",end);
        map.put("salesman",salesman);
        return salerecordDao.listByFactors(map);
    }


    //新增销售单
    @Override
    @Transactional
    public boolean sellGoods(Salerecord salerecord, Staff staff) {
        salerecord.setSrDate(new Date(System.currentTimeMillis()));
        salerecord.setStaffId(staff.getStaffId());
        salerecord.setSrSalesman(staff.getStaffName());
        // 减数据库库存，写个触发器

        // 在redis缓存中添加今日销售额和利润

        // 插入销售单到数据库
        salerecordDao.insertSelective(salerecord);
        saledetailService.insertSaledetails(salerecord.getSaledetails());
        return false;
    }
}
