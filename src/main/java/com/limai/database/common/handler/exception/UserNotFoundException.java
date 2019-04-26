package com.limai.database.common.handler.exception;

import lombok.Data;

/**
 * @Author: zhangbin
 * @Date: 2018/11/5 10:15
 * @Desc:
 */
@Data
public class UserNotFoundException extends RuntimeException {
    private String mobile;

    public UserNotFoundException(String mobile) {
        this.mobile = mobile;
    }
}
