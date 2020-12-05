package com.briup.jz.service.impl;

import com.briup.jz.bean.Order;
import com.briup.jz.bean.OrderExample;
import com.briup.jz.bean.OrderLine;
import com.briup.jz.bean.User;
import com.briup.jz.bean.extend.OrderExtend;
import com.briup.jz.dao.OrderLineMapper;
import com.briup.jz.dao.OrderMapper;
import com.briup.jz.dao.UserMapper;
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
    private UserMapper userMapper;

    @Resource
    private OrderExtendMapper orderExtendMapper;
    @Override
    public void commit(OrderVm orderVm) throws CustomerException {
        Order order = new Order();
        order.setAddressId(orderVm.getAddressId());
        order.setCustomerId(orderVm.getCustomerId());
        order.setEmployeeId(orderVm.getEmployeeId());
        order.setStatus(OrderExtend.STATUS_DFW);
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
    public List<OrderExtend> query(String status) {
        return orderExtendMapper.query(null,status);
    }


    @Override
    public OrderExtend findById(long id) {
        List<OrderExtend> list = orderExtendMapper.query(id,null);
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public void payOrder(long orderId) throws Exception{
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if(order == null){
           throw  new Exception("该订单不存在");
        }
        order.setStatus(OrderExtend.STATUS_DPD);

        orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public void sendOrder(long orderId, long employee)throws Exception {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if(order == null){
            new Exception("该订单不存在");
        }else if(order.getStatus().equals("待派单")){
            throw  new Exception("订单未支付、订单异常");
        }
        User user = userMapper.selectByPrimaryKey(employee);
        if(user == null){
            throw new Exception("该员工不存在");
        }
        order.setStatus(OrderExtend.STATUS_DFW);
        orderMapper.updateByPrimaryKey(order);

    }

    /*@Override
    public void takeOrder(long orderId)throws Exception {

    }*/

    @Override
    public void rejectOrder(long orderId)throws Exception {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if(order == null){
            throw new Exception("该订单不存在");
        }else if(!order.getStatus().equals("待服务")){
            throw new Exception("订单异常");
        }
        order.setStatus(OrderExtend.STATUS_DQR);
        orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public void confirmOrder(long orderId)throws Exception {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if(order == null){
            throw new Exception("该订单不存在");
        }else if(!order.getStatus().equals("待确认")){
            throw new Exception("订单异常");
        }
        order.setStatus(OrderExtend.STATUS_YWC);
        orderMapper.updateByPrimaryKey(order);
    }
}
