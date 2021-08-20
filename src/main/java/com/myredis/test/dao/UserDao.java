package com.myredis.test.dao;

import com.myredis.test.entity.UserEntity;
import com.myredis.test.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

/**
 * UserDao继承基类
 */
@Mapper
public interface UserDao{

    int deleteByPrimaryKey(Integer id);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);

    List<UserEntity> getListByPatameter(Map<String, Object> map);
}