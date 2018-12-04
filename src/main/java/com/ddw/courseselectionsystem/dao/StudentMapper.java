package com.ddw.courseselectionsystem.dao;

import com.ddw.courseselectionsystem.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: StudentMapper.java,v 1.0 2018/12/4 17:09 dengdingwwen
 * @date 2018/12/4 17:09
 */
@Mapper
public interface StudentMapper {

    @Select("select * from select_student")
    public List<Student> getAll();

}