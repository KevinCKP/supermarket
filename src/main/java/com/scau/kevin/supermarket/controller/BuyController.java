package com.scau.kevin.supermarket.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scau.kevin.supermarket.dto.QueryDto;
import com.scau.kevin.supermarket.entity.Buydetail;
import com.scau.kevin.supermarket.entity.Buyorder;
import com.scau.kevin.supermarket.entity.Buyreturn;
import com.scau.kevin.supermarket.entity.Staff;
import com.scau.kevin.supermarket.result.Result;
import com.scau.kevin.supermarket.service.BuyorderService;
import com.scau.kevin.supermarket.service.BuyreturnService;
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
@RequestMapping("/buy")
@ResponseBody
public class BuyController {
    @Autowired
    private BuyorderService buyorderService;

    @Autowired
    private BuyreturnService buyreturnService;

    @RequestMapping("/order/add")
    // 制订采购单
    public Result<Buyorder> makeOrder(HttpSession session,@RequestBody Buyorder buyorder){
        Staff operator = (Staff) session.getAttribute("operator");
        buyorderService.insertBuyorder(operator,buyorder);
        return Result.success(buyorder);
    }

    // 查看采购单
    @RequestMapping("/order/to_list")

    public Result<PageInfo> toList(int pageNum,int pageSize){
        String orderby = "buyorder.create_time";
        List<Buyorder> buyorders = buyorderService.listBuyorder();
        PageHelper.startPage(pageNum,pageSize,orderby);
        List<Buyorder> buyorders1 = buyorderService.listBuyorder_COUNT();
        PageInfo<Buyorder> pageInfo = new PageInfo<>(buyorders);
        return Result.success(pageInfo);
    }

    // 条件查询采购单
    @RequestMapping("/order/to_list2")
    public Result<PageInfo> toListByFactors(int pageNum, int pageSize, String orderby, QueryDto queryDto){
        List<Buyorder> buyorders = buyorderService.listByFactors(queryDto);
        PageHelper.startPage(pageNum,pageSize,orderby);
        buyorderService.listByFactors_COUNT(queryDto);
        PageInfo<Buyorder> buyorderPageInfo = new PageInfo<>(buyorders);
        System.out.println(queryDto.getFactor());
        return Result.success(buyorderPageInfo);
    }

    @RequestMapping("/order/assessor")
    // 审核采购单
    public Result<Object> assessor(Staff staff, Long buyorderId){
        buyorderService.asseror(staff, buyorderId);
        Buyorder buyorder = buyorderService.getById(buyorderId);
        return Result.success(buyorder);
    }
    // 查询采购单
    @RequestMapping("/order/detail/{buyorderId}")
    public Result<Buyorder> detail(@PathVariable("buyorderId") Long buyorderId){
        Buyorder buyorder = buyorderService.getById(buyorderId);
        return Result.success(buyorder);
    }
    @RequestMapping("/order/detail/update")
    public Result<Buydetail> updateDetail(@RequestBody Buydetail buydetail){
        buyorderService.updateBuydetail(buydetail);
        return Result.success(buydetail);
    }

    @RequestMapping("/order/update")
    // 修改采购单
    public Result<Buyorder> updateBuyorder(Staff staff,@RequestBody Buyorder buyorder){
        Buyorder ret = buyorderService.updateBuyorder(staff,buyorder);
        return Result.success(ret);
    }

    @RequestMapping("/order/delete")
    public Result<Boolean> deleteBuyorder(Staff staff,Long boId){
        buyorderService.deleteBuyorder(staff,boId);
        return Result.success(true);
    }


    // 采购退货
    @RequestMapping("/return/add")
    public Object addBuyReturn(Staff staff, Buyreturn buyreturn){
        buyreturnService.insertBuyreturn(staff,buyreturn);

        return null;
    }

    // 修改退货单状态
    @RequestMapping("/return/updateStage")
    public Result<Buyreturn> updateBuyreturnState(Staff staff, Long brId, Byte brState){
        buyreturnService.updateState(brId,brState);
        return null;
    }
    @RequestMapping("/return/update")
    // 修改退货单
    public Result<Buyreturn> updateBuyreturn(String password, Buyreturn buyreturn){
        //修改
        // 返回结果
        return null;
    }


    // 采购退货查询
    @RequestMapping("/return/to_list")
    public Object buyReturnToList(int pageNum, int pageSize, String orderby){
        PageHelper.startPage(pageNum,pageSize,orderby);
        // 查询
        List<Buyreturn> buyreturns = buyreturnService.listBuyreturn();
        PageInfo<Buyreturn> buyReturnPageInfo = new PageInfo<>(buyreturns);
        return buyReturnPageInfo;
    }
    // 采购退货条件查询

    @RequestMapping("/return/to_list2")
    public Object buyreturnToListByFactors(int pageNum, int pageSize, String orderby,String supplierName, String staffName,
                                           String beginTime, String endTime){
        PageHelper.startPage(pageNum,pageSize,orderby);
        // 查询
        List<Buyreturn> buyreturns = buyreturnService.listByFactors(supplierName,staffName,beginTime,endTime);
        PageInfo<Buyreturn> buyreturnPageInfo = new PageInfo<>(buyreturns);
        return Result.success(buyreturnPageInfo);
    }



}
