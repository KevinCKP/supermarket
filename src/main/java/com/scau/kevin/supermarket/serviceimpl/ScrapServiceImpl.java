package com.scau.kevin.supermarket.serviceimpl;

import com.scau.kevin.supermarket.dao.ScrapDao;
import com.scau.kevin.supermarket.entity.Scrap;
import com.scau.kevin.supermarket.service.ScrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: kevin
 * @Date: 2019/1/19 20:34
 * @Version 1.0
 */
@Service
public class ScrapServiceImpl implements ScrapService {

    @Autowired
    private ScrapDao scrapDao;

    // 插入报销信息
    @Override
    public boolean insertScrap(Scrap scrap) {

        // 减掉库存

        // 出库表添加信息

        // 插入报销表
        scrapDao.insertSelective(scrap);
        return true;
    }

    // 修改状态
    @Override
    public Scrap changeState(Long ScrapId, Byte scrapState) {
        scrapDao.changeState(ScrapId,scrapState);
        return scrapDao.selectByPrimaryKey(ScrapId);
    }

    // 修改报销信息
    @Override
    public Scrap updateScrap(Scrap scrap) {
        scrapDao.updateByPrimaryKeySelective(scrap);
        return scrapDao.selectByPrimaryKey(scrap.getScrapId());
    }


    @Override
    public List<Scrap> listScrap() {
        return scrapDao.listScrap();
    }

    @Override
    public List<Scrap> listScrapByFactors(String staffName, String beginTime, String endTime, Long goodsId, String goodsName) {
        Map<String,Object> map = new HashMap<>();
        map.put("staffName",staffName);
        map.put("beginTime",beginTime);
        map.put("endTime",endTime);
        map.put("goodsId",goodsId);
        map.put("goodsName",goodsName);
        return scrapDao.listByFactors(map);
    }


}
