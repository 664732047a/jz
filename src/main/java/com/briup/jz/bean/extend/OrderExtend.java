package com.briup.jz.bean.extend;

import com.briup.jz.bean.Address;
import com.briup.jz.bean.User;

public class OrderExtend {
    public static final String STATUS_WFK="未付款";
    public static final String STATUS_WFH="未发货";
    public static final String STATUS_DSH="待收货";
    public static final String STATUS_DPL="带评论";
    public static final String STATUS_YWC="已完成";
    private User customer;
    private User employee;
    private Address address;

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
