package com.cxl.util.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @program: diancan
 * @Description: 避免重复提交
 * @create: 2019-11-01 23:08
 * @author: Chen Xiaolong<xiaolong.chen@ifenxi.com>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AvoidRepeatableCommit {

    /**
     * 指定时间内不可重复提交,单位毫秒
     */
    long timeout()  default 3000 ;

}
