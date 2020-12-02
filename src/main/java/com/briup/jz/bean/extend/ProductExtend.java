package com.briup.jz.bean.extend;

import com.briup.jz.bean.Category;
import com.briup.jz.bean.Product;

public class ProductExtend extends Product {
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
