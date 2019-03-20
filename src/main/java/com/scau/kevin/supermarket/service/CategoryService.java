package com.scau.kevin.supermarket.service;

import com.scau.kevin.supermarket.entity.Category;

import java.util.List;

/**
 * @Author: kevin
 * @Date: 2019/3/11 1:10
 * @Version 1.0
 */
public interface CategoryService {
    List<Category> getTopCategoryList();

    List<Category> getTypeCategoryList();

    boolean saveCategory(Category category);

}
