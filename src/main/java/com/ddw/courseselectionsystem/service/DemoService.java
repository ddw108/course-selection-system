package com.ddw.courseselectionsystem.service;

import com.ddw.courseselectionsystem.config.redis.RedisService;
import com.ddw.courseselectionsystem.config.redis.StudentKey;
import com.ddw.courseselectionsystem.dao.StudentMapper;
import com.ddw.courseselectionsystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 测试服务类
 *
 * @author dengdingwwen
 * @version $Id: DemoService.java,v 1.0 2018/12/4 17:51 dengdingwwen
 * @date 2018/12/4 17:51
 */
@Service
public class DemoService {

    @Autowired
    private StudentMapper userMapper;

    @Autowired
    private RedisService redisService;

    public List<Student> getAll(){
        return userMapper.getAll();
    }

    public Student getByStudentName(String name){
        Student student = redisService.get(StudentKey.getByName, name, Student.class);
        if(student == null){
            student = userMapper.getByName(name);
        }
        redisService.set(StudentKey.getByName, name, student);
        return student;
    }
}