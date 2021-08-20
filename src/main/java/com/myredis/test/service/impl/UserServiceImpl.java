package com.myredis.test.service.impl;

import com.myredis.test.dao.UserDao;
import com.myredis.test.entity.UserEntity;
import com.myredis.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public List<UserEntity> getListByParameter(Map<String, Object> map) {
        return userDao.getListByPatameter(map);
    }

    @Override
    public UserEntity selectByPrimaryKey(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }
}
