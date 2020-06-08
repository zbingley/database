package com.limai.database.controller;

import com.limai.database.common.BaseResponse;
import com.limai.database.common.annotation.NotRepeatSubmit;
import com.limai.database.dto.AccessToken;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zhang bin
 * @version [版本号, 2020/5/28 16:14]
 */
@RestController
@RequestMapping("/api/token")
public class TokenController {

    @NotRepeatSubmit(20*1000)
    @PostMapping("/api_token")
    public BaseResponse<AccessToken> getAccessToken(String appId,
                                                    @RequestHeader(name = "timestamp", required = false) String timeStamp,
                                                    @RequestHeader(name = "sign", required = false) String sign) {

        Assert.isTrue(!StringUtils.isEmpty(appId) && !StringUtils.isEmpty(timeStamp) && !StringUtils.isEmpty(sign), "参数不合法");

//        long requestInterval = System.currentTimeMillis() - Long.valueOf(timeStamp);
////        Assert.isTrue(requestInterval < 5 * 60 * 1000, "请求已过期，请重试！");


        return new BaseResponse<>();
    }
}
