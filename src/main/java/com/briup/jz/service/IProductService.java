package com.briup.jz.service;

import com.briup.jz.bean.Product;
import com.briup.jz.bean.ProductExample;
import com.briup.jz.bean.extend.ProductExtend;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void saveOrUpdate(Product product);

    void deleteById(long id);

    List<ProductExtend> findAllWithCategory();
}
