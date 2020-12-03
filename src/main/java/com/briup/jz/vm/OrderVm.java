package com.briup.jz.vm;

import com.briup.jz.bean.Order;
import com.briup.jz.bean.OrderLine;

import java.util.List;

public class OrderVm extends Order {
    private List<OrderLine> orderLines;

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
