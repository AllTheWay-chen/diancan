package com.cxl.util.aspect;

import com.cxl.util.ConstantsUtil;
import com.cxl.util.HttpUtil;
import com.cxl.util.annotations.AvoidRepeatableCommit;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @program: diancan
 * @Description: 重复提交aop
 * @create: 2019-11-01 23:13
 * @author: Chen Xiaolong<xiaolong.chen@ifenxi.com>
 */

@Log4j
@Component
@Aspect
public class AvoidRepeatableCommitAspect {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @param point 切点
     */
    @Around("@annotation(com.cxl.util.annotations.AvoidRepeatableCommit)")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = HttpUtil.getRealIp(request);
        //获取注解
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        //目标类、方法
        String className = method.getDeclaringClass().getName();
        String name = method.getName();
        String ipKey = String.format("%s#%s", className, name);
        int hashCode = Math.abs(ipKey.hashCode());

        String key = ConstantsUtil.REDIS_ROOT + String.format("%s_%d", ip, hashCode);

        log.info("ipKey:" + ipKey + ",hashCode:" + hashCode + ",key:" + key);
        AvoidRepeatableCommit avoidRepeatableCommit = method.getAnnotation(AvoidRepeatableCommit.class);
        long timeout = avoidRepeatableCommit.timeout();
        if (timeout < 0) {
            timeout = 3 * ConstantsUtil.SECOND;
        }
        String value = (String) redisTemplate.opsForValue().get(key);
        if (StringUtils.isNotBlank(value)) {
            return "请勿重复提交";
        }
        redisTemplate.opsForValue().set(key, UUID.randomUUID().toString(), timeout, TimeUnit.MILLISECONDS);
        //执行方法
        Object object = point.proceed();

        return object;
    }
}
