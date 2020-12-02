package com.briup.jz.service.impl;

import com.briup.jz.bean.Product;
import com.briup.jz.bean.ProductExample;
import com.briup.jz.bean.extend.ProductExtend;
import com.briup.jz.dao.ProductMapper;
import com.briup.jz.dao.extend.ProductExtendMapper;
import com.briup.jz.service.IProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IProductServiceImpl implements IProductService {
    @Resource
    private ProductMapper productMapper;

    @Resource
    private ProductExtendMapper productExtendMapper;

    @Override
    public List<Product> findAll() {
        ProductExample example = new ProductExample();
        return productMapper.selectByExample(example);
    }

    @Override
    public void saveOrUpdate(Product product) {
        if(product.getId() != null){
            productMapper.updateByPrimaryKey(product);
        }else {
            productMapper.insert(product);
        }
    }

    @Override
    public void deleteById(long id) {
        productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<ProductExtend> findAllWithCategory() {
        return productExtendMapper.selectAllWithCategory();
    }
}
