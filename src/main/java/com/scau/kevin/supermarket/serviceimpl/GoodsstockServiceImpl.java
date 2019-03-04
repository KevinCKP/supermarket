package com.scau.kevin.supermarket.serviceimpl;

import com.scau.kevin.supermarket.dao.GoodsstockDao;
import com.scau.kevin.supermarket.entity.Goodsstock;
import com.scau.kevin.supermarket.exception.GlobalException;
import com.scau.kevin.supermarket.result.CodeMessage;
import com.scau.kevin.supermarket.service.GoodsstockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: kevin
 * @Date: 2019/1/27 16:25
 * @Version 1.0
 */
@Service
public class GoodsstockServiceImpl implements GoodsstockService{

    @Autowired
    private GoodsstockDao goodsstockDao;

    @Override
    public boolean insertGoodsstock(Goodsstock goodsstock) {
        return false;
    }

    @Override
    public Goodsstock setWarnNum(Long goodsId, int warnNumber) {
        return null;
    }

    @Override
    public Goodsstock updateGoodsstock(Goodsstock goodsstock) {
        if(goodsstock.getGoodsId() == null){
            throw new GlobalException(CodeMessage.ID_EMPTY);
        } else if(goodsstock.getGsWarnnumber() < 0){
            throw new GlobalException(CodeMessage.WARNING_NUMBER_ZERO);
        } else{
            goodsstock.setGsUpdateTime(new Date(System.currentTimeMillis()));
            goodsstockDao.updateByPrimaryKeySelective(goodsstock);
        }

        return null;
    }

    @Override
    public boolean initGoodsstock(Long goodsId) {
        Goodsstock goodsstock = new Goodsstock();
        goodsstock.setGoodsId(goodsId);
        goodsstock.setGsNumber(0);
        goodsstock.setGsWarnnumber(Integer.MAX_VALUE);
        goodsstock.setGsUpdateTime(new Date(System.currentTimeMillis()));
        goodsstockDao.insertSelective(goodsstock);
        return true;
    }

    @Override
    public Goodsstock getById(Long goodsId) {
        return goodsstockDao.selectByGoodsId(goodsId);
    }

    @Override
    public List<Goodsstock> listUnderWarning() {
        return goodsstockDao.listUnderWarning();
    }

    @Override
    public List<Goodsstock> listGoodsstock() {
        return goodsstockDao.listGoodsstock();
    }

    @Override
    public List<Goodsstock> listGoodsstockByFactors(String goodsName, Long goodsId, Integer less, Integer most) {
        Map<String,Object> map = new HashMap<>();
        map.put("goodsName",goodsName);
        map.put("goodsId",goodsId);
        map.put("less",less);
        map.put("most",most);
        return goodsstockDao.listGoodsstockByFactors(map);
    }

    @Override
    public List<Goodsstock> listSetWarning() {
        return goodsstockDao.listSetWarning();
    }

    @Override
    public List<Goodsstock> listUponWarning() {
        return goodsstockDao.listUponWarning();
    }

    @Override
    public void updateWarnNumber(Long goodsId, Integer gsWarnNumber) {
        goodsstockDao.updateWarnNumber(goodsId,gsWarnNumber);
    }
}
