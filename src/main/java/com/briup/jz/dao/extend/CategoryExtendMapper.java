package com.briup.jz.dao.extend;

import com.briup.jz.bean.extend.CategoryExtend;

import java.util.List;

public interface CategoryExtendMapper {
    List<CategoryExtend> selectAllWithChild();

}
