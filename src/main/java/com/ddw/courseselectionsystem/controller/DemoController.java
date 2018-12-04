package com.ddw.courseselectionsystem.controller;

import com.ddw.courseselectionsystem.result.ErrorMsg;
import com.ddw.courseselectionsystem.result.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public Result<String> success(){
        return Result.success("Hello");
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public Result<String> error(){
        return Result.error(ErrorMsg.SERVER_ERROR);
    }

}