package com.briup.jz.service.impl;

import com.briup.jz.bean.User;
import com.briup.jz.bean.UserExample;
import com.briup.jz.bean.extend.UserExtend;
import com.briup.jz.dao.UserMapper;
import com.briup.jz.dao.extend.UserExtendMapper;
import com.briup.jz.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IUserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private UserExtendMapper userExtendMapper;

    @Override
    public List<User> findAll() {
        UserExample example = new UserExample();
        return userMapper.selectByExample(example);
    }

    @Override
    public List<UserExtend> findAllEmployee() {
        return userExtendMapper.selectAllEmployee();
    }

    @Override
    public void saveOrUpdate(User user) {
        if(user.getId() != null){
            userMapper.updateByPrimaryKey(user);
        }else{
            userMapper.insert(user);
        }

    }

    @Override
    public void deleteById(long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<UserExtend> selectAllRole() {
        return userExtendMapper.selectAllRole();
    }

    @Override
    public User findById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

}
