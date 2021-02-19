package org.mybatis.study.service;


import org.mybatis.study.mapper.UserMapper;
import org.mybatis.study.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @param
 * @author jipeng
 * @date 2021-02-18 11:25
 */
@Service("userService")
public class UserService {
  @Resource
  UserMapper userMapper;

  public void getUser(){
    User user = userMapper.getUser(1);
    User user1 = userMapper.getUser(1);
    System.err.println(user);
  }
  @Transactional
  public void getUserWithTrans(){
    User user = userMapper.getUser(1);
    User user1 = userMapper.getUser(1);
    System.err.println(user);
  }

}

