package com.briup.jz.service;

import com.briup.jz.bean.Order;
import com.briup.jz.bean.extend.OrderExtend;
import com.briup.jz.utils.CustomerException;
import com.briup.jz.vm.OrderVm;

import java.util.List;

public interface IOrderService {
    /**
     * 新建订单
     * @param orderVm
     * @throws CustomerException
     */
    void commit(OrderVm orderVm) throws CustomerException;

    /**
     * 查询全部订单
     *
     * @return
     */
    List<Order> findAll();

    /**
     * 根据状态查询订单
     *
     * @param status
     * @return
     */
    List<OrderExtend> query(String status);

    /**
     * 根据订单id查询订单详情(顾客、地址、订单项等内容)
     * @param id
     * @return
     */
    OrderExtend findById(long id);

    /**
     * 支付订单(订单进入待派单状态)
     * @param orderId
     */
    void payOrder(long orderId) throws Exception;

    /**
     * 派单(进入待接单状态)-->进入待服务状态
     * @param orderId
     * @param employee
     */
    void sendOrder(long orderId,long employee) throws Exception;

    /**
     * 接单(进入待服务状态)
     * @param orderId
     */
    //void takeOrder(long orderId) throws Exception;

    /**
     * 服务结束(订单进入待确认状态)
     * @param orderId
     */
    void rejectOrder(long orderId) throws Exception;

    /**
     * 确认订单(进入已完成状态)
     * @param orderId
     */
    void confirmOrder(long orderId) throws Exception;
}
