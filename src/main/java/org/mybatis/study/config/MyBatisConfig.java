package org.mybatis.study.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @param
 * @author jipeng
 * @date 2021-02-18 9:57
 */
@Configuration
@MapperScan("org.mybatis.study.mapper")
@ComponentScan("org.mybatis.study")
public class MyBatisConfig {
  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    factoryBean.setDataSource(dataSource());
    return factoryBean.getObject();
  }
  @Bean
  public DataSource dataSource(){
    DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
    driverManagerDataSource.setUrl("jdbc:mysql://192.168.9.223:3306/mybatis_example?characterEncoding=utf8");
    driverManagerDataSource.setUsername("root");
    driverManagerDataSource.setPassword("ablejava");
    return driverManagerDataSource;
  }
//  @Bean
//  public UserMapper userMapper() throws Exception {
//    SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
//    return sqlSessionTemplate.getMapper(UserMapper.class);
//  }

}

