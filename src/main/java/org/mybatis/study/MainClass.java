package org.mybatis.study;


import org.mybatis.study.config.MyBatisConfig;
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
    userService.getUser();
  }
}

