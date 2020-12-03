package com.briup.jz.service;

import com.briup.jz.bean.Order;
import com.briup.jz.bean.extend.OrderExtend;
import com.briup.jz.utils.CustomerException;
import com.briup.jz.vm.OrderVm;

import java.util.List;

public interface IOrderService {
    void commit(OrderVm orderVm) throws CustomerException;

    List<Order> findAll();

    OrderExtend findById(long id);
}
