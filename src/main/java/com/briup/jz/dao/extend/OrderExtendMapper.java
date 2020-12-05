package com.briup.jz.dao.extend;

import com.briup.jz.bean.extend.OrderExtend;

import java.util.List;

public interface OrderExtendMapper {

    List<OrderExtend> query(Long id,String status);
}
