package com.briup.jz.service;

import com.briup.jz.bean.User;
import com.briup.jz.bean.extend.UserExtend;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    List<UserExtend> findAllEmployee();

    void saveOrUpdate(User user);

    void deleteById(long id);

    List<UserExtend> selectAllRole();

    User findById(long id);
}
