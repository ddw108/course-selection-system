package com.ddw.courseselectionsystem.service;

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

    public List<Student> getAll(){
        return userMapper.getAll();
    }
}