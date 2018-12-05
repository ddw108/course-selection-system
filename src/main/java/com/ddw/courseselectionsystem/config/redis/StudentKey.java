package com.ddw.courseselectionsystem.config.redis;

/**
 * 学生类key的前缀
 *
 * @author dengdingwwen
 * @version $Id: StudentKey.java,v 1.0 2018/12/5 14:33 dengdingwwen
 * @date 2018/12/5 14:33
 */
public class StudentKey extends BasePrefix{

    private StudentKey(String prefix) {
        super(prefix);
    }

    public static StudentKey getById =  new StudentKey("id");

    public static StudentKey getByName = new StudentKey("name");
}