package com.limai.database.common.dto;

import lombok.Data;

import javax.validation.constraints.Size;

/**
 * @Author: zhangbin
 * @Date: 2019/6/16 10:42
 * @Desc:
 */
@Data
public class SubmitStudentRequest {
    @Size(max=5,message = "姓名太长了")
    private String name;
}
