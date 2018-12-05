package com.ddw.courseselectionsystem.config.redis;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: BasePrefix.java,v 1.0 2018/12/5 11:24 dengdingwwen
 * @date 2018/12/5 11:24
 */
public abstract class BasePrefix implements KeyPrefix{

    private int expireSeconds;

    private String prefix;

    public BasePrefix(String prefix) {//0代表永不过期
        this(0, prefix);
    }

    public BasePrefix( int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    @Override
    public int expireSeconds() {//默认0代表永不过期
        return expireSeconds;
    }
    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className+":" + prefix;
    }

}