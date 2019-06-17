package com.limai.database.UrlFilter.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.sql.Timestamp;

/**
 * @Author: zhangbin
 * @Date: 2019/6/16 11:30
 * @Desc:
 */
@Data
@Entity
@Table(name = "api_interceptor_config")
public class ApiInterceptorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp startTime;
    private Timestamp endTime;
    private String urls;
    private String errorCode;
    private String errorMsg;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private String invalidStatus;
}
