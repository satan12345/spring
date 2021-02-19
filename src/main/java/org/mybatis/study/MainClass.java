package org.mybatis.study;


import org.mybatis.study.config.MyBatisConfig;
import org.mybatis.study.mapper.UserMapper;
import org.mybatis.study.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @param
 * @author jipeng
 * @date 2021-02-18 10:11
 */
public class MainClass {
  public static void main(String[] args){

    AnnotationConfigApplicationContext context=
      new AnnotationConfigApplicationContext(MyBatisConfig.class);
    UserService userService = (UserService) context.getBean("userService");
    userService.getUserWithTrans();
//    userService.getUser();

    UserMapper userMapper = (UserMapper) context.getBean("userMapper");
    UserMapper userMapper2 = (UserMapper) context.getBean("userMapper");
    System.out.println(userMapper == userMapper2);

  }
}

