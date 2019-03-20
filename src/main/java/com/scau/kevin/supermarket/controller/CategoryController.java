package com.scau.kevin.supermarket.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scau.kevin.supermarket.entity.Category;
import com.scau.kevin.supermarket.result.Result;
import com.scau.kevin.supermarket.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: kevin
 * @Date: 2019/3/11 1:07
 * @Version 1.0
 */
@Controller
@ResponseBody
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/topCategory/to_list")
    public Result<PageInfo> topCategoryToList(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Category> categories = categoryService.getTopCategoryList();
        PageInfo<Category> categoryPageInfo = new PageInfo<>(categories);
        return Result.success(categoryPageInfo);
    }
}
