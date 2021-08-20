package com.myredis.test.service;

import com.myredis.test.entity.UserEntity;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 通过参数map 获取用户列表信息
     * @param map
     * @return
     */
    List<UserEntity> getListByParameter(Map<String,Object> map);

    UserEntity selectByPrimaryKey(Integer id);
}
