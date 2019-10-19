package com.limai.database.UrlFilter.repository;

import com.limai.database.UrlFilter.repository.entity.ApiInterceptorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: zhangbin
 * @Date: 2019/6/16 11:35
 * @Desc:
 */
public interface ApiInterceptorRepository extends JpaRepository<ApiInterceptorEntity,Long> {
    List<ApiInterceptorEntity> findByInvalidStatus(String invalidStatus);
}
