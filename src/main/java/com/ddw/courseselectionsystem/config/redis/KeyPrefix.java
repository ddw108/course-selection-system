package com.ddw.courseselectionsystem.config.redis;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: KeyPrefix.java,v 1.0 2018/12/5 11:23 dengdingwwen
 * @date 2018/12/5 11:23
 */
public interface KeyPrefix {

    public int expireSeconds();

    public String getPrefix();
}