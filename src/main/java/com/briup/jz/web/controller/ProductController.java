package com.briup.jz.web.controller;

import com.briup.jz.bean.Product;
import com.briup.jz.bean.extend.ProductExtend;
import com.briup.jz.service.IProductService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
@Api(description = "产品管理接口")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("findAll")
    public Message findAll() {
        List<Product> productList = productService.findAll();
        return MessageUtil.success(productList);
    }

    @ApiOperation(value = "通过id删除产品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "唯一编号",required = true,paramType = "query")
    }
    )
    @GetMapping("deleteById")
    public Message deleteById(long id){
        productService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Product product){
        productService.saveOrUpdate(product);
        return MessageUtil.success("保存成功");
    }

    @GetMapping("findAllWithCategory")
    public Message findAllWithCategory(){
        List<ProductExtend> list = productService.findAllWithCategory();
        return MessageUtil.success(list);
    }
}
