package com.briup.jz.web.controller;

import com.briup.jz.bean.User;
import com.briup.jz.bean.extend.UserExtend;
import com.briup.jz.service.IUserService;
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

    @GetMapping("findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(User user){
        userService.saveOrUpdate(user);
        return "修改成功";
    }

    @GetMapping("deleteById")
    public String deleteById(long id){
        userService.deleteById(id);
        return "删除成功";
    }

    @GetMapping("selectAllRole")
    public List<UserExtend> selectAllRole(){
        return userService.selectAllRole();
    }
}
