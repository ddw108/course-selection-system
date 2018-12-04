package com.ddw.courseselectionsystem.result;

import lombok.Data;

/**
 * 返回的Result结果由这里输出
 *
 * @author dengdingwwen
 * @version $Id: Result.java,v 1.0 2018/12/4 15:36 dengdingwwen
 * @date 2018/12/4 15:36
 */
@Data
public class Result<T> {

    private int code;

    private String msg;

    private T data;

    private Result(T data){
        this.code = 200;
        this.msg = "Sucess";
        this.data = data;
    }

    private Result(ErrorMsg msg){
        if(msg == null){
            return;
        }
        this.code = msg.getCode();
        this.msg = msg.getMsg();
    }

    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }

    public static <T> Result<T> error(ErrorMsg msg){
        return new Result<T>(msg);
    }
}