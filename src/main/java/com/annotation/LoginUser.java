package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 该注解用于标记参数，表示该参数是用于登录的客户信息。
 **/
@Target(ElementType.PARAMETER)//该注解的作用目标为参数
@Retention(RetentionPolicy.RUNTIME)//该注解的生命周期为运行时
public @interface LoginUser {

}
