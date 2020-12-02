package com.briup.jz.web.controller;

import com.briup.jz.bean.Product;
import com.briup.jz.bean.extend.ProductExtend;
import com.briup.jz.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("findAll")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("deleteById")
    public String deleteById(long id){
        productService.deleteById(id);
        return "删除成功";
    }

    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(Product product){
        productService.saveOrUpdate(product);
        return "保存成功";
    }

    @GetMapping("findAllWithCategory")
    public List<ProductExtend> findAllWithCategory(){
        return productService.findAllWithCategory();
    }
}
