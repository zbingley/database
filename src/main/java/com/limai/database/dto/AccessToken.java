package com.limai.database.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Zhang bin
 * @version [版本号, 2020/5/28 16:17]
 */
@Data
@AllArgsConstructor
public class AccessToken {

    private String token;

    private long expireTime;
}
