package com.cxl.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author yong.tang
 * @description RedisTemplate
 * @date 2018-10-22 05:11
 */
public class RedisTemplateUtils {
    private RedisTemplate<String, String> redisTemplate;
    private ValueOperations<String, String> valueOperations;
    private RedisTemplate<String, Object> redisTemplateObj;
    private ValueOperations<String, Object> valueOperationsObj;

    public RedisTemplateUtils(RedisTemplate<String, String> redisTemplate, RedisTemplate<String, Object> redisTemplateObj) {
        this.redisTemplate = redisTemplate;
        this.valueOperations = redisTemplate.opsForValue();
        this.redisTemplateObj = redisTemplateObj;
        this.valueOperationsObj = redisTemplateObj.opsForValue();
    }

    public RedisTemplateUtils(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.valueOperations = redisTemplate.opsForValue();
    }

    /**
     * 根据key获取值
     *
     * @param key 键
     * @return java.lang.String
     * @author yong.tang
     * @date 5:31 2018/10/22
     */
    public String getStringValue(String key) {
        Object o = valueOperations.get(key);
        return o == null ? null : o.toString();
    }

    /**
     * 根据key获取值
     *
     * @param key 键
     * @return java.util.map
     * @author yong.tang
     * @date 5:31 2018/11/22
     */
    public Object getMapValue(String key) {
        Object o = valueOperations.get(key);
        return o == null ? null : o;
    }

    /**
     * 根据key删除
     *
     * @param key 键
     * @author yong.tang
     * @date 5:30 2018/10/22
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * @param key     键
     * @param timeout 超时时间
     * @param unit    时间单位
     * @return boolean
     * @author yong.tang
     * @date 5:29 2018/10/22
     */
    public boolean expire(String key, final long timeout, final TimeUnit unit) {
        return redisTemplate.expire(key, timeout, unit);
    }

    /**
     * 获取剩余时间
     *
     * @param key 键
     * @return java.lang.Long
     * @author yong.tang
     * @date 5:29 2018/10/22
     */
    public Long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }

    /**
     * 新增
     *
     * @param key      键
     * @param value    值
     * @param timeout  超时时间
     * @param timeUnit 时间单位
     * @author yong.tang
     * @date 5:27 2018/10/22
     */
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        valueOperations.set(key, value, timeout, timeUnit);
    }

    /**
     * 新增
     *
     * @param key      键
     * @param value    值
     * @param timeout  超时时间
     * @param timeUnit 时间单位
     * @author xiaolong
     * @date 5:27 2018/11/22
     */
    public void add(String key, Object value, long timeout, TimeUnit timeUnit) {
        valueOperationsObj.set(key, value, timeout, timeUnit);
    }

    /**
     * 模糊查询key
     *
     * @param selective 条件
     * @return key列表
     * @author xiaolong
     */
    public Set<String> getKeys(String selective) {
        return redisTemplateObj.keys(selective + "*");
    }
}
