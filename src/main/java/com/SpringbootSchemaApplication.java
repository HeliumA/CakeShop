
//启动Spring Boot应用程序并设置应用程序上下文。
package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
//基于Spring Boot框架的Java应用程序入口类
@MapperScan(basePackages = {"com.dao"})
//指定了MyBatis Mapper接口所在的包路径，以便应用程序能够自动扫描并生成Mapper接口的实现类。
public class SpringbootSchemaApplication extends SpringBootServletInitializer{
//继承了SpringBootServletInitializer类，并重写了其中的configure方法
	//让Spring Boot应用程序能够在Web容器中运行，而不仅仅是在嵌入式的Tomcat容器中运行
	public static void main(String[] args) {
		//自动扫描应用程序中的所有组件，并创建应用程序上下文。通过这个上下文，应用程序能够访问依赖注入的bean、配置文件、环境变量等。
		SpringApplication.run(SpringbootSchemaApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(SpringbootSchemaApplication.class);
    }
}
