package com.briup.jz.service.impl;

import com.briup.jz.bean.Category;
import com.briup.jz.bean.CategoryExample;
import com.briup.jz.bean.extend.CategoryExtend;
import com.briup.jz.dao.CategoryMapper;
import com.briup.jz.dao.extend.CategoryExtendMapper;
import com.briup.jz.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ICategoryServiceImpl implements ICategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private CategoryExtendMapper categoryExtendMapper;

    @Override
    public List<Category> findAll() {
        return categoryMapper.selectByExample(new CategoryExample());
    }

    @Override
    public void saveOrUpdate(Category category) {
        if(category.getId() != null){
            categoryMapper.updateByPrimaryKey(category);
        }else {
            categoryMapper.insert(category);
        }
    }

    @Override
    public void deleteById(long id) {
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<CategoryExtend> findAllWithChild() {
        return categoryExtendMapper.selectAllWithChild();
    }
}
