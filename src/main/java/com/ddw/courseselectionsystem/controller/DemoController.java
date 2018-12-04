package com.ddw.courseselectionsystem.controller;

import com.ddw.courseselectionsystem.model.Student;
import com.ddw.courseselectionsystem.result.ErrorMsg;
import com.ddw.courseselectionsystem.result.Result;
import com.ddw.courseselectionsystem.service.DemoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 测试Controller
 *
 * @author dengdingwwen
 * @version $Id: DemoController.java,v 1.0 2018/12/4 15:51 dengdingwwen
 * @date 2018/12/4 15:51
 */
@Api(value = "测试入口", tags = {"学生选课系统-测试入口"})
@RestController
@RequestMapping(value = "/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public Result<String> success(){
        return Result.success("Hello");
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public Result<String> error(){
        return Result.error(ErrorMsg.SERVER_ERROR);
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public Result<List<Student>> getAll(){
        List<Student> students = demoService.getAll();
        return Result.success(students);
    }

}