package org.mybatis.study.mapper;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.study.model.User;

/**
 * @param
 * @author jipeng
 * @date 2021-02-18 9:58
 */
public interface UserMapper {

  @Select("select * from user where id = #{userId}")
  User getUser(@Param("userId") Integer userId);
}

