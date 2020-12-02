package com.briup.jz.service;

import com.briup.jz.bean.Category;
import com.briup.jz.bean.extend.CategoryExtend;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void saveOrUpdate(Category category);

    void deleteById(long id);

    List<CategoryExtend> findAllWithChild();
}
