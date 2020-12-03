package com.briup.jz.dao.extend;

import com.briup.jz.bean.Order;
import com.briup.jz.bean.OrderLine;
import com.briup.jz.bean.extend.OrderLineExtend;

import java.util.List;

public interface OrderLineExtendMapper {
    List<OrderLine> selectByOrderId(long id);
}
