package com.briup.jz.bean.extend;

import com.briup.jz.bean.Address;
import com.briup.jz.bean.OrderLine;
import com.briup.jz.bean.User;

import java.util.List;

public class OrderExtend {
    public static final String STATUS_WFK="未付款";
    public static final String STATUS_DPD="待配单";
    public static final String STATUS_DFW="待服务";
    public static final String STATUS_DQR="待确认";
    public static final String STATUS_YWC="已完成";
    private User customer;
    private User employee;
    private Address address;
    private List<OrderLine> orderLine;

    public List<OrderLine> getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(List<OrderLine> orderLine) {
        this.orderLine = orderLine;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
