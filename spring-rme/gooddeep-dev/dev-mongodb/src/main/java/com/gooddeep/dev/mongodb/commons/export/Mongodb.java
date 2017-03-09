package com.gooddeep.dev.mongodb.commons.export;

import java.lang.annotation.*;

/**
 * 标示mongodb有关类及方法
 * @author lhy
 *
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Mongodb {


}
