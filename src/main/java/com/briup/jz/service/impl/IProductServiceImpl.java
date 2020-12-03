package com.briup.jz.service.impl;

import com.briup.jz.bean.Product;
import com.briup.jz.bean.ProductExample;
import com.briup.jz.bean.extend.ProductExtend;
import com.briup.jz.dao.ProductMapper;
import com.briup.jz.dao.extend.ProductExtendMapper;
import com.briup.jz.service.IProductService;
import com.briup.jz.utils.CustomerException;
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
    public void saveOrUpdate(Product product)throws CustomerException {
        if(product.getId() != null){
            productMapper.updateByPrimaryKey(product);
        }else {
            productMapper.insert(product);
        }
    }

    @Override
    public void deleteById(long id) throws CustomerException{
        Product product = productMapper.selectByPrimaryKey(id);
        if(product == null){
            throw new CustomerException("删除失败，要删除的数据不存在");
        }
        productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<ProductExtend> findAllWithCategory() {
        return productExtendMapper.selectAllWithCategory();
    }
}
