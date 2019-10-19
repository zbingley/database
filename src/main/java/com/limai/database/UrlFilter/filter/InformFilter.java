package com.limai.database.UrlFilter.filter;

import com.alibaba.fastjson.JSON;
import com.limai.database.UrlFilter.repository.entity.ApiInterceptorEntity;
import com.limai.database.UrlFilter.service.ApiInterceptorService;
import com.limai.database.common.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: zhangbin
 * @Date: 2019/6/16 11:27
 * @Desc:
 */
@Component
@Slf4j
public class InformFilter extends OncePerRequestFilter {
    @Autowired
    private ApiInterceptorService apiInterceptorService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        ApiInterceptorEntity apiInterceptorEntity = apiInterceptorService.checkInterruptedUrl(requestURI);
        if(apiInterceptorEntity!=null){
            BaseResponse<Object> baseResponse = new BaseResponse<>();
            baseResponse.setCode(Integer.valueOf(apiInterceptorEntity.getErrorCode()));
            baseResponse.setMsg(apiInterceptorEntity.getErrorMsg());
            String jsonString = JSON.toJSONString(baseResponse);
            log.info("[{}] is interrupted,response",requestURI,jsonString );
            response.setStatus(200);
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            PrintWriter out = response.getWriter();
            out.println(jsonString);
            out.close();
            return;
        }
        filterChain.doFilter(request,response);
    }
}
