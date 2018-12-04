package com.ddw.courseselectionsystem.model;

import lombok.Data;

import java.util.Date;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: Student.java,v 1.0 2018/12/4 17:46 dengdingwwen
 * @date 2018/12/4 17:46
 */
@Data
public class Student {

    /**
     * 主键id
     */
    private Long id;

    private String nickname;

    private String password;

    private String salt;

    private String head;

    private Date registerDate;

    private Date lastLoginDate;

    private Integer loginCount;

}