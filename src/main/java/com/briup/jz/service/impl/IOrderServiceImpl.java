package com.briup.jz.service.impl;

import com.briup.jz.bean.Order;
import com.briup.jz.bean.OrderExample;
import com.briup.jz.bean.OrderLine;
import com.briup.jz.bean.extend.OrderExtend;
import com.briup.jz.dao.OrderLineMapper;
import com.briup.jz.dao.OrderMapper;
import com.briup.jz.dao.extend.OrderExtendMapper;
import com.briup.jz.service.IOrderService;
import com.briup.jz.utils.CustomerException;
import com.briup.jz.vm.OrderVm;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class IOrderServiceImpl implements IOrderService {
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderLineMapper orderLineMapper;

    @Resource
    private OrderExtendMapper orderExtendMapper;
    @Override
    public void commit(OrderVm orderVm) throws CustomerException {
        Order order = new Order();
        order.setAddressId(orderVm.getAddressId());
        order.setCustomerId(orderVm.getCustomerId());
        order.setEmployeeId(orderVm.getEmployeeId());
        order.setStatus(OrderExtend.STATUS_WFH);
        order.setOrderTime(new Date().getTime());
        order.setTotal(orderVm.getTotal());

        List<OrderLine> orderLines = orderVm.getOrderLines();

        orderMapper.insert(order);

        for(OrderLine orderLine : orderLines){
            orderLine.setOrderId(order.getId());
            orderLineMapper.insert(orderLine);
        }
    }

    @Override
    public List<Order> findAll() {
        return orderMapper.selectByExample(new OrderExample());
    }

    @Override
    public OrderExtend findById(long id) {
        return orderExtendMapper.selectById(id);
    }

}
