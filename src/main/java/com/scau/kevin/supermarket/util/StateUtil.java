package com.scau.kevin.supermarket.util;

/**
 * @Author: kevin
 * @Date: 2019/1/14 23:28
 * @Version 1.0
 */
public class StateUtil {
    // 采购订单表的状态信息
    public static class BuyorderState{
        public final Byte UNAUDITED= 0; // 未审核
        public final Byte PASS = 1;  // 审核通过
        public final Byte HALF = 2;  // 有未全部入库商品
        public final Byte ALL = 3;   // 全部商品入库
        public final Byte FINISHED = 4; // 已完成
    }

    // 采购明细表的状态信息
    public static class BuydetailState{

    }

    //

}
