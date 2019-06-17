package com.limai.database.UrlFilter.service.impl;

import com.limai.database.UrlFilter.repository.ApiInterceptorRepository;
import com.limai.database.UrlFilter.repository.entity.ApiInterceptorEntity;
import com.limai.database.UrlFilter.service.ApiInterceptorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

/**
 * @Author: zhangbin
 * @Date: 2019/6/16 13:09
 * @Desc:
 */
@Slf4j
@Service
public class ApiInterceptorServiceImpl implements ApiInterceptorService {

    @Autowired
    private ApiInterceptorRepository apiInterceptorRepository;
    @Override
    public ApiInterceptorEntity checkInterruptedUrl(String url) {
        try {
            LocalDateTime now = LocalDateTime.now();
            List<ApiInterceptorEntity> apiInterceptorEntities = listUrls();
            for (ApiInterceptorEntity urlEntity:apiInterceptorEntities ) {
                Timestamp startTime = urlEntity.getStartTime();
                Timestamp endTime = urlEntity.getEndTime();
                Date nowDate = Date.from(now.toInstant(ZoneOffset.of("+8")));
                String[] urlRegs = urlEntity.getUrls().split(",");
                for (String urlReg:urlRegs){
                    urlReg=urlReg.replace("\\*",".*?");
                    if(url.matches(urlReg) && nowDate.compareTo(startTime)>=0 && nowDate.compareTo(endTime)<=0){
                        return urlEntity;
                    }
                }
            }
        } catch (Exception e) {
            log.error("获取url[{}]阻断时发生异常{}",url,e.getMessage());
        }
        return null;
    }

    @Override
    public List<ApiInterceptorEntity> listUrls() {
        return apiInterceptorRepository.findByInvalidStatus("0");
    }
}
