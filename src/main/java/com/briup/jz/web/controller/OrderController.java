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

    @GetMapping("findById")
    @ApiOperation("根据id查单条")
    public Message findById(long id){
        return MessageUtil.success("success",orderService.findById(id));
    }
}
