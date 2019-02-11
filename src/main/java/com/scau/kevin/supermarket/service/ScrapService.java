package com.scau.kevin.supermarket.service;

import com.scau.kevin.supermarket.entity.Scrap;

import java.util.List;

/**
 * @Author: kevin
 * @Date: 2019/1/19 19:57
 * @Version 1.0
 */
public interface ScrapService {

    boolean insertScrap(Scrap scrap);

    Scrap changeState(Long ScrapId, Byte scrapState);

    Scrap updateScrap(Scrap scrap);

    List<Scrap> listScrap();

    List<Scrap> listScrapByFactors(String staffName, String beginTime, String endTime, Long goodsId, String goodsName);


}
