package com.limai.database.common.dto;

import lombok.Data;

/**
 * @Author: zhangbin
 * @Date: 2018/11/5 10:11
 * @Desc:
 */
@Data
public class ErrorInfo {
    private int code;
    private String msg;

    public ErrorInfo() {
    }

    public ErrorInfo(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
