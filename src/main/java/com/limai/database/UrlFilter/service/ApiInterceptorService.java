package com.limai.database.UrlFilter.service;

import com.limai.database.UrlFilter.repository.entity.ApiInterceptorEntity;

import java.util.List;

/**
 * @Author: zhangbin
 * @Date: 2019/6/16 13:04
 * @Desc:
 */
public interface ApiInterceptorService {
    ApiInterceptorEntity checkInterruptedUrl(String url);
    List<ApiInterceptorEntity> listUrls();
}
