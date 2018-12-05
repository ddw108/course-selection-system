package com.ddw.courseselectionsystem.config.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import springfox.documentation.spring.web.json.Json;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: RedisService.java,v 1.0 2018/12/5 11:13 dengdingwwen
 * @date 2018/12/5 11:13
 */
public class RedisService {

    @Autowired
    JedisPool jedisPool;

    /**
     * 获取对象
     **/
    public <T> T get(KeyPrefix prefix, String key, Class<T> clazz){
        Jedis jedis = null;
        try{
            //redis连接池
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            String str = jedis.get(realKey);
            T t = stringToBean(str, clazz);
            return t;
        }finally {
            returnToPool(jedis);
        }
    }

    /**
     * 设置对象
     **/
    public <T> boolean set(KeyPrefix prefix, String key, T value){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            String str = beanToString(value);
            if(str == null || str.length() == 0){
                return false;
            }
            String realKey = prefix.getPrefix() + key;
            int seconds = prefix.expireSeconds();
            //如果时间为0的话，即设置永久缓存
            if(seconds <= 0){
                jedis.set(realKey, str);
            }else{
                jedis.setex(realKey, seconds, str);
            }
            return true;
        }finally {
            returnToPool(jedis);
        }
    }

    private <T> String beanToString(T value){
        if(value == null){
            return null;
        }else{
            return JSON.toJSONString(value);
        }
    }

    private <T> T stringToBean(String str, Class<T> clazz){
        if(str == null || str.length() == 0 || clazz == null){
            return null;
        }else{
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }

    private void returnToPool(Jedis jedis){
        if(jedis != null){
            jedis.close();
        }
    }
}