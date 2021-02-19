package org.mybatis.study.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.study.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

/**
 * @param
 * @author jipeng
 * @date 2021-02-18 9:57
 */
@Configuration
@MapperScan("org.mybatis.study.mapper")
@ComponentScan("org.mybatis.study")
@EnableTransactionManagement
public class MyBatisConfig {
  @Bean
  public SqlSessionFactory sqlSessionFactory()  {
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    //org.apache.ibatis.session.Configuration configuration=new org.apache.ibatis.session.Configuration();
    Resource resource=new ClassPathResource("mybatis-config.xml");
    factoryBean.setConfigLocation(resource);
    factoryBean.setDataSource(dataSource());
    try {
      return factoryBean.getObject();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
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

  @Bean
  public DataSourceTransactionManager dataSourceTransactionManager(){
    DataSourceTransactionManager transactionManager=new DataSourceTransactionManager();
    transactionManager.setDataSource(dataSource());
    return transactionManager;
  }

//  @Bean
//  public UserMapper userMapper(){
//    MapperFactoryBean mapperFactoryBean=new MapperFactoryBean();
//    mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory());
//    mapperFactoryBean.setMapperInterface(UserMapper.class);
//    Object object = null;
//    try {
//      object = mapperFactoryBean.getObject();
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//    return (UserMapper) object;
//
//  }
//  @Bean
//  public UserMapper userMapper() throws Exception {
//    SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
//    return sqlSessionTemplate.getMapper(UserMapper.class);
//  }

}

