package com.scau.kevin.supermarket.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scau.kevin.supermarket.dto.ProfitTotalDto;
import com.scau.kevin.supermarket.dto.QueryDto;
import com.scau.kevin.supermarket.entity.Salerecord;
import com.scau.kevin.supermarket.entity.Staff;
import com.scau.kevin.supermarket.result.Result;
import com.scau.kevin.supermarket.service.SalerecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: kevin
 * @Date: 2019/1/7 16:35
 * @Version 1.0
 */
@Controller
// 销售管理模块
@RequestMapping("/sale")
public class SalesController {
    @Autowired
    private SalerecordService salerecordService;

    // 销售
    @RequestMapping("/add")
    @ResponseBody
    public Result<Object> sell(@RequestBody Salerecord salerecord, HttpSession session) {
        Staff operator = (Staff) session.getAttribute("operator");
        salerecordService.sellGoods(salerecord, operator);
        return Result.success(salerecord);
    }

    // 查看销售订单
    @RequestMapping("/to_list")
    @ResponseBody
    public Result<PageInfo> toList(Integer pageNum, Integer pageSize, String orderby) {
        List<Salerecord> salerecords = salerecordService.listSalerecords();
        PageHelper.startPage(pageNum, pageSize, orderby);
        List<Salerecord> salerecords2 = salerecordService.listSalerecords2();
        PageInfo<Salerecord> salerecordPageInfo = new PageInfo<>(salerecords);
        return Result.success(salerecordPageInfo);
    }

    @RequestMapping("to_list2")
    @ResponseBody
    // 按条件查询订单，员工编号、员工姓名、开始时间、结束时间、商品名称
    public Result<PageInfo> toListByFactors(int pageNum, int pageSize, String orderby, QueryDto queryDto) {
        List<Salerecord> salerecords = salerecordService.listSalerecordsByFactor(queryDto);
        PageHelper.startPage(pageNum, pageSize, orderby);
        // 条件查询
        List<Salerecord> salerecords1 = salerecordService.listByFactors_COUNT(queryDto);
        PageInfo<Salerecord> salerecordPageInfo = new PageInfo<>(salerecords);
        return Result.success(salerecordPageInfo);
    }

    // 查看某件商品的月份销售

    // 查看不同类别商品的销售额比较

    // 查看某一年不同月份的销售额、利润、销售单数、销售商品数量的情况
    @RequestMapping("/count/year/{year}")
    @ResponseBody
    public Result<Object> countAll(@PathVariable("year") Integer year) {

        String time = "" + year + "-01-01";
        List<ProfitTotalDto> test2 = salerecordService.countByYear(time);
        return Result.success(test2);
    }

    @RequestMapping("/count/month")
    @ResponseBody
    public Result<Object> countByMonth(Integer year, Integer month,Integer day){
        String time = "" + year + "-" + month + "-01";
        List<ProfitTotalDto> count = salerecordService.countByMonth(time);
        return Result.success(count);
    }

    @RequestMapping("/count")
    @ResponseBody
    public Result<Object> count(Integer year, Integer month){
        List<ProfitTotalDto> count = null;
        String time = null;
        if (year != null && month == null){
            time = "" + year + "-01-01";
            count = salerecordService.countByYear(time);
        } else {
            time = "" + year + "-" + month + "-01";
            count = salerecordService.countByMonth(time);
        }
        return Result.success(count);
    }
    @RequestMapping("/count/goods/{goodsId}")
    @ResponseBody
    public Result<Object> goodsCount(Integer year, Integer month, @PathVariable("goodsId") Long goodsId){
        List<ProfitTotalDto> count = null;
        String time = null;
        if (year != null && month == null){
            time = "" + year + "-01-01";
            count = salerecordService.countGoodsByYear(time,goodsId);
        } else {
            time = "" + year + "-" + month + "-01";
            count = salerecordService.countGoodsByMonth(time,goodsId);
        }
        return Result.success(count);
    }
}



