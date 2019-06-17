package com.limai.database.common;

import lombok.Data;

/**
 * @Author: zhangbin
 * @Date: 2019/5/14 14:33
 * @Desc:
 */
@Data
public class BaseResponse<T> {
    private Integer code;
    private String msg;
    private T date;

    public BaseResponse() {
        this.code=0;
        this.msg="success";
    }

    public BaseResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.date = null;
    }
}
