package com.cxl.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author yong.tang
 * @description jedis配置
 * @date 2018-09-22 18:24
 */
@RestController
@Configuration
public class JedisConfig {
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.timeout}")
    private Integer timeout;
    @Value("${spring.redis.port}")
    private Integer port;
    @Value("${spring.redis.pool.max-idle}")
    private Integer maxIdle;
    @Value("${spring.redis.pool.min-idle}")
    private Integer minIdle;
    @Value("${spring.redis.pool.max-active}")
    private Integer maxActive;
    @Value("${spring.redis.pool.max-wait}")
    private Integer maxWait;
//    @Value("${redis-pool.testOnBorrow}")
//    private Boolean testOnBorrow;
//    @Value("${redis-pool.testOnReturn}")
//    private Boolean testOnReturn;
//    @Value("${redis-pool.testWhileIdle}")
//    private Boolean testWhileIdle;

    @Bean
    public JedisPool jedisPool() {
        return new JedisPool(jedisPoolConfig(), host, port, timeout, password);
    }

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxActive);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWait);
        return jedisPoolConfig;
    }

    public Integer getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }

    public Integer getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(Integer maxActive) {
        this.maxActive = maxActive;
    }

    public Integer getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(Integer maxWait) {
        this.maxWait = maxWait;
    }

//    public Boolean getTestOnBorrow() {
//        return testOnBorrow;
//    }
//
//    public void setTestOnBorrow(Boolean testOnBorrow) {
//        this.testOnBorrow = testOnBorrow;
//    }
//
//    public Boolean getTestOnReturn() {
//        return testOnReturn;
//    }
//
//    public void setTestOnReturn(Boolean testOnReturn) {
//        this.testOnReturn = testOnReturn;
//    }
//
//    public Boolean getTestWhileIdle() {
//        return testWhileIdle;
//    }
//
//    public void setTestWhileIdle(Boolean testWhileIdle) {
//        this.testWhileIdle = testWhileIdle;
//    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }


}
