package com.ddw.courseselectionsystem.result;

import lombok.Data;

/**
 * 定义的一些错误状态码
 *
 * @author dengdingwwen
 * @version $Id: ErrorMsg.java,v 1.0 2018/12/4 15:43 dengdingwwen
 * @date 2018/12/4 15:43
 */
@Data
public class ErrorMsg {

    private int code;

    private String msg;

    private ErrorMsg(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public static ErrorMsg SERVER_ERROR = new ErrorMsg(500001, "服务端异常");
}