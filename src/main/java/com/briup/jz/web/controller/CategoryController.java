package com.briup.jz.web.controller;

import com.briup.jz.bean.Category;
import com.briup.jz.bean.extend.CategoryExtend;
import com.briup.jz.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("findAll")
    public List<Category> findAll(){
        return categoryService.findAll();
    };

    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(Category category){
        categoryService.saveOrUpdate(category);
        return "保存成功";
    }

    @GetMapping("deleteById")
    public String deleteById(long id){
        categoryService.deleteById(id);
        return "删除成功";
    }

    @GetMapping("findAllWithChild")
    public List<CategoryExtend> findAllWithChild(){
        return categoryService.findAllWithChild();
    }
}
