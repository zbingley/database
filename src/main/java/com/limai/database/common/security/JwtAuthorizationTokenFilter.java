package com.limai.database.common.security;

import com.limai.database.common.config.JwtWhitelistPatterns;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: zhangbin
 * @Date: 2018/11/10 10:42
 * @Desc:
 */
@Slf4j
@Component
public class JwtAuthorizationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtWhitelistPatterns jwtWhitelist;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        log.info("enter filter");
        String url = request.getRequestURI();
        if (!inWhiteList(url)){
            log.info("to auth.....");
        }
        filterChain.doFilter(request,response);
    }
    private boolean inWhiteList(String requestUrl){
        AntPathMatcher pathMatcher = new AntPathMatcher();
        for (String jwtWhitelistPatterns:jwtWhitelist.getWhitelists()){
            if(pathMatcher.match(jwtWhitelistPatterns,requestUrl)){
                log.info("requestUrl:["+requestUrl+"] in whitelist,don't need auth!");
                return true;
            }
        }
        return false;
    }

}
