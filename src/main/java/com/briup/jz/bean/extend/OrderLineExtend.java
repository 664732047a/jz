package com.briup.jz.bean.extend;

import com.briup.jz.bean.OrderLine;
import com.briup.jz.bean.Product;

public class OrderLineExtend extends OrderLine {
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
