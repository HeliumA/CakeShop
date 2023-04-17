
package com.utils;

/**
 * 
 */

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.entity.EIException;

/**
 * hibernate-validator校验工具类
 * 验证对象的属性是否符合规范
 */

public class ValidatorUtils {
    private static Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * 静态方法 validateEntity
     * 接收两个参数，要校验的对象和分组校验的分组信息
     */
    
    public static void validateEntity(Object object, Class<?>... groups)
            throws EIException {
    	/**
    	 * 调用 Validator 对象的 validate 方法，传入要校验的对象和分组信息
    	 * 得到一个 ConstraintViolation 的 Set 集合，表示校验出来的错误信息
    	 */
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
        	/**
        	 * 如果这个 Set 不为空，说明校验出错了
        	 * 就从集合中取出第一条错误信息
        	 * 然后抛出一个 EIException 异常
        	 * 异常信息为这个错误信息的消息
        	 */
        	ConstraintViolation<Object> constraint = (ConstraintViolation<Object>)constraintViolations.iterator().next();
            throw new EIException(constraint.getMessage());
        }
    }
    
    
}
