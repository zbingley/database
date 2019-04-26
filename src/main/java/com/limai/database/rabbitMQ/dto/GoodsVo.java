package com.limai.database.rabbitMQ.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zhangbin
 * @Date: 2018/11/7 9:35
 * @Desc:
 */
@Data
public class GoodsVo implements Serializable {
    private String name;
    private String price;

    public GoodsVo() {
    }

    public GoodsVo(String name, String price) {
        this.name = name;
        this.price = price;
    }
}
