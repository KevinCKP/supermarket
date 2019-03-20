package com.scau.kevin.supermarket.dao;

import com.scau.kevin.supermarket.entity.Category;

import java.util.List;

public interface CategoryDao {
    int deleteByPrimaryKey(Long categoryId);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Long categoryId);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> getTopCategoryList();
}