package com.briup.jz.web.controller;

import com.briup.jz.bean.User;
import com.briup.jz.bean.extend.UserExtend;
import com.briup.jz.service.IUserService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("findAllEmployee")
    public Message findAllEmployee(){
        return MessageUtil.success(userService.findAllEmployee());
    }

    @GetMapping("auditing")
    public Message auditing(long id){
        User user = userService.findById(id);
        user.setStatus("启用");
        userService.saveOrUpdate(user);
        return MessageUtil.success("审核成功");
    }

    @GetMapping("refuseauditing")
    public Message refuseauditing(long id){
        User user = userService.findById(id);
        user.setStatus("禁用");
        userService.saveOrUpdate(user);
        return MessageUtil.success("已拒绝审核");
    }

    @GetMapping("findAll")
    public Message findAll(){
        return MessageUtil.success(userService.findAll());
    }

    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(User user){
        userService.saveOrUpdate(user);
        return MessageUtil.success("保存成功！");
    }

    @GetMapping("deleteById")
    public Message deleteById(long id){
        userService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @GetMapping("selectAllRole")
    public Message selectAllRole(){
        return MessageUtil.success(userService.selectAllRole());
    }
}
