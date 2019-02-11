package com.scau.kevin.supermarket.serviceimpl;

import com.scau.kevin.supermarket.dao.GoodsDao;
import com.scau.kevin.supermarket.entity.Goods;
import com.scau.kevin.supermarket.entity.Supplier;
import com.scau.kevin.supermarket.exception.GlobalException;
import com.scau.kevin.supermarket.result.CodeMessage;
import com.scau.kevin.supermarket.service.GoodsService;
import com.scau.kevin.supermarket.service.GoodsstockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: kevin
 * @Date: 2018/12/29 15:14
 * @Version 1.0
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private GoodsstockService goodsstockService;
    //添加商品信息
    @Override
    public Goods insertGoods(Goods goods) {
        // 商品编号为空
        if(goods.getGoodsId() == null){
            throw new GlobalException(CodeMessage.ID_EMPTY);
        } else if(goodsDao.goodsIsExisted(goods.getGoodsId()) > 0){
            //编号已存在，抛出异常
            throw new GlobalException(CodeMessage.ID_EXISTS);
        } else{
            // 添加商品信息
            goodsDao.insertSelective(goods);
            // 商品添加后，初始化商品库存信息
            goodsstockService.initGoodsstock(goods.getGoodsId());
        }
        return goods;
    }
    //修改商品信息

    @Override
    public Goods updateGoods(Goods goods) {
        goods.setGoodsUpdateTime(new Date());
        goodsDao.updateByPrimaryKeySelective(goods);
        return goodsDao.selectByPrimaryKey(goods.getGoodsId());
    }
    //删除商品信息

    @Override
    public boolean deleteGoods(Goods goods) {
        return false;
    }

    @Override
    public List<Goods> listByFactors(Map<String, Object> map) {
        return null;
    }
    //查询商品信息

    @Override
    public List<Goods> listGoods() {
        List<Goods> goodsList = goodsDao.listGoods();
        return goodsList;
    }

    //查询某个供应商供应的商品
    @Override
    public List<Goods> listBySupplier(Supplier supplier) {
        return null;
    }

    @Override
    public Goods getById(Long goodsId) {
        Goods goods =  goodsDao.selectByPrimaryKey(goodsId);
        if(goods == null){
            throw new GlobalException(CodeMessage.ID_EMPTY);
        }
        return goods;
    }

    @Override
    public void updateGoodsState(Long goodsId, Byte goodsState) {
        goodsDao.updateGoodsState(goodsId,goodsState);
    }

    @Override
    public List<Goods> listByFactors(String goodsCategory, Byte goodsState, String goodsName, String beginTime,
                                     String endTime) {
        Map<String,Object> map = new HashMap<>();
        map.put("goodsCategory", goodsCategory);
        map.put("goodsState",goodsState);
        map.put("goodsName", goodsName);
        map.put("beginTime",beginTime);
        map.put("endTime",endTime);
        List<Goods> goodsList = goodsDao.listByFactors(map);
        return goodsList;
    }


}
