package com.briup.jz.web.controller;

import com.briup.jz.bean.Category;
import com.briup.jz.bean.extend.CategoryExtend;
import com.briup.jz.service.ICategoryService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;
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
    public Message findAll(){
        return MessageUtil.success(categoryService.findAll());
    };

    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Category category){
        categoryService.saveOrUpdate(category);
        return MessageUtil.success("保存成功");
    }

    @GetMapping("deleteById")
    public Message deleteById(long id){
        categoryService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @GetMapping("findAllWithChild")
    public Message findAllWithChild(){
        return MessageUtil.success(categoryService.findAllWithChild());
    }
}
