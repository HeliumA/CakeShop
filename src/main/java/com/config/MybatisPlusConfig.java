
package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;

/**
 * MyBatis Plus配置类
 **/
@Configuration
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    //通过@Bean注解获取MetaObjectHandler实例，就可以实现自动填充功能
    public PaginationInterceptor paginationInterceptor() {
    	//获取分页插件的实例
        return new PaginationInterceptor();
    }
    
}
