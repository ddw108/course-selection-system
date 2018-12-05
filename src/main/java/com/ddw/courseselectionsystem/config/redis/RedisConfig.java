package com.ddw.courseselectionsystem.config.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取配置文件中关于redis的配置
 *
 * @author dengdingwwen
 * @version $Id: RedisConfig.java,v 1.0 2018/12/5 11:07 dengdingwwen
 * @date 2018/12/5 11:07
 */
@Component
@ConfigurationProperties(prefix="redis")
@Data
public class RedisConfig {

    private String host;

    private int port;

    private int timeout;//秒

    private String password;

    private int poolMaxTotal;

    private int poolMaxIdle;

    private int poolMaxWait;//秒
}