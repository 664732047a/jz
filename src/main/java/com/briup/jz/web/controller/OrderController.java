package com.briup.jz.web.controller;

import com.briup.jz.service.IOrderService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;
import com.briup.jz.vm.OrderVm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
@Api(description = "订单管理接口")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("commit")
    @ApiOperation("提交订单")
    public Message commit(@RequestBody OrderVm orderVm){
        orderService.commit(orderVm);
        return MessageUtil.success("提交成功！");
    }

    @GetMapping("findAll")
    @ApiOperation("查询所有订单")
    public Message findAll(){
        return MessageUtil.success("success",orderService.findAll());
    }

    @GetMapping("query")
    @ApiOperation("查询所有订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "status",value = "订单状态",required = false,paramType = "query")
    }
    )
    public Message query(String status){
        return MessageUtil.success("success",orderService.query(status));
    }

    @GetMapping("findById")
    @ApiOperation("根据id查单条")
    public Message findById(long id){
        return MessageUtil.success("success",orderService.findById(id));
    }

    @GetMapping("payOrder")
    @ApiOperation("支付订单")
    public Message payOrder(Long orderId) throws Exception {
        orderService.payOrder(orderId);
        return MessageUtil.success("success");
    }

    @GetMapping("sendOrder")
    @ApiOperation("派单")
    public Message sendOrder(Long orderId,long employee) throws Exception {
        orderService.sendOrder(orderId,employee);
        return MessageUtil.success("success");
    }

    @GetMapping("rejectOrder")
    @ApiOperation("服务订单")
    public Message rejectOrder(Long orderId) throws Exception {
        orderService.rejectOrder(orderId);
        return MessageUtil.success("success");
    }

    @GetMapping("confirmOrder")
    @ApiOperation("确认订单")
    public Message confirmOrder(Long orderId) throws Exception {
        orderService.confirmOrder(orderId);
        return MessageUtil.success("success");
    }

}
