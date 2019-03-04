package com.scau.kevin.supermarket.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scau.kevin.supermarket.entity.*;
import com.scau.kevin.supermarket.result.Result;
import com.scau.kevin.supermarket.service.GoodsstockService;
import com.scau.kevin.supermarket.service.InstorageService;
import com.scau.kevin.supermarket.service.OutstorageService;
import com.scau.kevin.supermarket.service.ScrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: kevin
 * @Date: 2019/1/7 16:35
 * @Version 1.0
 */
@Controller
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private ScrapService scrapService;

    @Autowired
    private GoodsstockService goodsstockService;

    @Autowired
    private InstorageService instorageService;

    @Autowired
    private OutstorageService outstorageService;
    // 查询商品库存
    @RequestMapping("/to_list")
    @ResponseBody
    public Result<PageInfo> queryGoodsStock(int pageNum, int pageSize, String orderby){
        PageHelper.startPage(pageNum,pageSize,orderby);
        List<Goodsstock> goodsstockList = goodsstockService.listGoodsstock();
        PageInfo<Goodsstock> goodsstockPageInfo = new PageInfo<>(goodsstockList);
        return Result.success(goodsstockPageInfo);
    }

    @RequestMapping("/to_list2")
    @ResponseBody
    public Result<PageInfo> goodsstockToListByFactors(int pageNum, int pageSize, String orderby,
                                                      String goodsName, Long goodsId, Integer less, Integer most){
        PageHelper.startPage(pageNum,pageSize,orderby);
        List<Goodsstock> goodsstockList = goodsstockService.listGoodsstockByFactors(goodsName,goodsId,less,most);
        PageInfo<Goodsstock> goodsstockPageInfo = new PageInfo<>(goodsstockList);
        return Result.success(goodsstockPageInfo);
    }

    // 编辑库存信息
    @RequestMapping("/update")
    public Object updateGoodsstock(Goodsstock goodsstock){
        goodsstockService.updateGoodsstock(goodsstock);
        return null;
    }

    // 库存预警设置
    @RequestMapping("/setWarning/{goodsId}")
    @ResponseBody
    public Object setWarning(@PathVariable("goodsId")Long goodsId, Integer warningNumber){
        goodsstockService.setWarnNum(goodsId,warningNumber);
        return goodsstockService.getById(goodsId);
    }

    // 查看库存预警商品
    @RequestMapping("/warning/to_list")
    @ResponseBody
    public Result<PageInfo> queryWarningGoods(int pageNum, int pageSize, String orderby){
        PageHelper.startPage(pageNum,pageSize,orderby);
        List<Goodsstock> goodsstockList = goodsstockService.listSetWarning();
        PageInfo<Goodsstock> goodsstockPageInfo = new PageInfo<>(goodsstockList);
        return Result.success(goodsstockPageInfo);
    }

    // 查看处于预警下的商品
    @RequestMapping("/underwarning/to_list")
    @ResponseBody
    public Result<PageInfo> queryUnderWarningGoods(int pageNum, int pageSize, String orderby){
        PageHelper.startPage(pageNum,pageSize,orderby);
        List<Goodsstock> goodsstockList = goodsstockService.listUnderWarning();
        PageInfo<Goodsstock> goodsstockPageInfo = new PageInfo<>(goodsstockList);
        return Result.success(goodsstockPageInfo);
    }

    @RequestMapping("/uponwarning/to_list")
    @ResponseBody
    public Result<PageInfo> queryUponWarningGoods(int pageNum, int pageSize, String orderby){
        PageHelper.startPage(pageNum,pageSize,orderby);
        List<Goodsstock> goodsstockList = goodsstockService.listUponWarning();
        PageInfo<Goodsstock> goodsstockPageInfo = new PageInfo<>(goodsstockList);
        return Result.success(goodsstockPageInfo);
    }
    // 入库
    @RequestMapping("/inStock/add")
    @ResponseBody
    public Result<Boolean> inStock(Staff staff, Instorage instorage){
        instorageService.insertInstorage(staff,instorage);
        return Result.success(true);
    }

    // 入库纪录查询
    @RequestMapping("/inStock/to_list")
    @ResponseBody
    public Result<PageInfo> inStockToList(int pageNum, int pageSize, String orderby){
        PageHelper.startPage(pageNum,pageSize,orderby);
        List<Instorage> instorages = instorageService.listInstorage();
        PageInfo<Instorage> instoragePageInfo = new PageInfo<>(instorages);
        return Result.success(instoragePageInfo);
    }

    @RequestMapping("/inStock/to_list2")
    @ResponseBody
    public Result<PageInfo> inStockToListByFactors(int pageNum, int pageSize, String orderby,
                                                   String operatorName, Long goodsId,
                                                   String goodsName, String beginTime, String endTime){

        PageHelper.startPage(pageNum,pageSize,orderby);
        List<Instorage> instorages = instorageService.listInstorageByFactors(operatorName,goodsName,goodsId,beginTime,endTime);
        PageInfo<Instorage> instoragePageInfo = new PageInfo<>(instorages);
        return Result.success(instoragePageInfo);
    }


    // 出库
    @RequestMapping("/outStock/add")
    @ResponseBody
    public Result<Boolean> outStock(Staff staff, Outstorage outstorage){
        outstorageService.insertOutstorage(staff,outstorage);
        return Result.success(true);
    }

    // 出库纪录查询
    @RequestMapping("/outStock/to_list")
    @ResponseBody
    public Result<PageInfo> outStockToList(int pageNum, int pageSize, String orderby){
        PageHelper.startPage(pageNum,pageSize,orderby);
        List<Outstorage> outstorages = outstorageService.listOutstorage();
        PageInfo<Outstorage> outstoragePageInfo = new PageInfo<>(outstorages);
        return Result.success(outstoragePageInfo);
    }

    /**
     * 出库纪录条件查询
     * @param pageNum
     * @param pageSize
     * @param orderby
     * @param operatorName
     * @param goodsId
     * @param goodsName
     * @param beginTime
     * @param endTime
     * @param destination
     * @return
     */
    @RequestMapping("/outStock/to_list2")
    @ResponseBody
    public Result<PageInfo> outStockToListByFactors(int pageNum, int pageSize, String orderby, String operatorName,
                                                    Long goodsId, String goodsName, String beginTime,
                                                    String endTime, String destination){
        PageHelper.startPage(pageNum,pageSize,orderby);
        List<Outstorage> outstorages = outstorageService.listOutstorageByFactors(operatorName,goodsId,goodsName,
                                                                                 beginTime,endTime,destination);
        PageInfo<Outstorage> outstoragePageInfo = new PageInfo<>(outstorages);
        return Result.success(outstoragePageInfo);
    }



    // 商品报损
    @RequestMapping("/scrap/add")
    @ResponseBody
    public Result<Object> scrapGoods(Scrap scrap){
        scrapService.insertScrap(scrap);
        return null;
    }

    // 查看报损情况
    @RequestMapping("/scrap/to_list")
    @ResponseBody
    public Result<PageInfo> scrapToList(Integer pageNum, Integer pageSize, String orderby){
        PageHelper.startPage(pageNum,pageSize,orderby);
        List<Scrap> scraps = scrapService.listScrap();
        PageInfo<Scrap> scrapPageInfo = new PageInfo<>(scraps);
        return Result.success(scrapPageInfo);
    }

    /**
     * 查看报损情况  条件查询
     * @param pageNum
     * @param pageSize
     * @param orderby
     * @param staffName
     * @param goodsId
     * @param goodsName
     * @param beginTime
     * @param endTime
     * @return
     */
    @RequestMapping("/scrap/to_list2")
    @ResponseBody
    public Result<PageInfo> scrapToListByFactors(int pageNum, int pageSize, String orderby, String staffName,
                                                 Long goodsId, String goodsName, String beginTime,
                                                 String endTime){
        PageHelper.startPage(pageNum,pageSize,orderby);
        List<Scrap> scraps = scrapService.listScrapByFactors(staffName,beginTime,endTime,goodsId,goodsName);
        PageInfo<Scrap> scrapPageInfo = new PageInfo<>(scraps);
        return Result.success(scrapPageInfo);
    }

    // 修改报损情况
    @RequestMapping("/scrap/update")
    @ResponseBody
    public Result<Scrap> update(Scrap scrap){
        scrapService.updateScrap(scrap);
        return null;
    }

    @RequestMapping("/warn/update")
    @ResponseBody
    public boolean updateWarn(Long goodsId, Integer gsWarnNumber){
        System.out.println(goodsId);
        System.out.println(gsWarnNumber);
        goodsstockService.updateWarnNumber(goodsId,gsWarnNumber);
        return true;
    }
}
