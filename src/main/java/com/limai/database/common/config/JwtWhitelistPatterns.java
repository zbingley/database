package com.limai.database.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import java.util.List;


/**
 * @Author: zhangbin
 * @Date: 2018/11/10 10:51
 * @Desc:
 */
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtWhitelistPatterns {

    private List<String> whitelists;

    public List<String> getWhitelists() {
        return whitelists;
    }

    public void setWhitelists(List<String> whitelists) {
        this.whitelists = whitelists;
    }
}
