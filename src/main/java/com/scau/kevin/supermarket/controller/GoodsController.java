package com.scau.kevin.supermarket.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scau.kevin.supermarket.dto.QueryDto;
import com.scau.kevin.supermarket.entity.Buyorder;
import com.scau.kevin.supermarket.entity.Goods;
import com.scau.kevin.supermarket.entity.Staff;
import com.scau.kevin.supermarket.result.Result;
import com.scau.kevin.supermarket.service.BuyorderService;
import com.scau.kevin.supermarket.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: kevin
 * @Date: 2018/12/29 15:13
 * @Version 1.0
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private BuyorderService buyorderService;
    @Autowired
    private GoodsService goodsService;
    @RequestMapping("/test")
    public Object test(){
        PageHelper.startPage(1, 5);
      //  Buyorder buyorder = buyorderService.queryBuyorderById(1);
        List<Buyorder> buyorders = buyorderService.listBuyorder();
        PageInfo<Buyorder> pageInfo = new PageInfo<>(buyorders);
        return Result.success(pageInfo);
    }

    // 添加商品信息
    @RequestMapping("/add")
    @ResponseBody
    public Result<Goods> insertGoods(HttpSession session,Goods goods){
        Staff staff = (Staff) session.getAttribute("operator");
        System.out.println(staff.getStaffName());
        goodsService.insertGoods(goods);
        return Result.success(goods);
    }

    // 修改商品信息、如修改价格之类的
    @RequestMapping("/update")
    @ResponseBody
    public Result<Goods> updateGoods(Goods goods){
        goodsService.updateGoods(goods);
        return Result.success(goods);
    }

    /**
     *  查询商品信息
     *  传入参数： 查询条件、排序条件、当前页数、每页显示条数
     * @return
     */
    @RequestMapping("/to_list")
    @ResponseBody
    public Result<PageInfo> to_list(HttpSession session,Model model, Integer pageNum, int pageSize, String orderby){
        Staff operator = (Staff) session.getAttribute("operator");
        PageHelper.startPage(pageNum,pageSize,orderby);
        List<Goods> goodss = goodsService.listGoods();
        PageInfo<Goods> pageInfo = new PageInfo<>(goodss);
        model.addAttribute("goodss",goodss);
        return Result.success(pageInfo);
    }

    //查询单件商品
    @RequestMapping("/detail/{goodsId}")
    @ResponseBody
    public Result<Goods> getGoods(@PathVariable("goodsId") Long goodsId){
        Goods goods = goodsService.getById(goodsId);
        return Result.success(goods);

    }

    @RequestMapping("/to_list2")
    @ResponseBody
    public Result<PageInfo> queryByFactor(Integer pageNum, Integer pageSize, String orderby, QueryDto queryDto){
        PageHelper.startPage(pageNum,pageSize,orderby);
        List<Goods> goodsList = goodsService.listByFactor(queryDto);
        PageInfo<Goods> goodsPageInfo = new PageInfo<>(goodsList);
        return Result.success(goodsPageInfo);
    }
    // 按条件查询商品信息
    public Result<Object> queryByFactors(Integer pageNum, Integer pageSize,String orderby,
                                         String goodsCategory, Byte goodsState, String goodsName,
                                         String beginTime, String endTime){
        PageHelper.startPage(pageNum,pageSize,orderby);
        List<Goods> goodsList = goodsService.listByFactors(goodsCategory,goodsState,goodsName,beginTime,endTime);
        PageInfo<Goods> goodsPageInfo = new PageInfo<>(goodsList);
        return Result.success(goodsPageInfo);
    }

    // 下架或者上架商品
    @RequestMapping("/changeState/{goodsId}")
    @ResponseBody
    public Result<Object> updateGoodsState(@PathVariable("goodsId") Long goodsId, Byte goodsState){
        goodsService.updateGoodsState(goodsId,goodsState);
        return Result.success(true);
    }

}
