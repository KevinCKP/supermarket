package com.scau.kevin.supermarket.serviceimpl;

import com.scau.kevin.supermarket.dao.CategoryDao;
import com.scau.kevin.supermarket.entity.Category;
import com.scau.kevin.supermarket.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: kevin
 * @Date: 2019/3/11 1:11
 * @Version 1.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getTopCategoryList() {
        return categoryDao.getTopCategoryList();
    }

    @Override
    public List<Category> getTypeCategoryList() {
        return null;
    }

    @Override
    public boolean saveCategory(Category category) {
        return false;
    }
}
