package com.limai.database.common.security;

import com.limai.database.common.annotation.NotRepeatSubmit;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * token拦截器
 *
 * @author Zhang bin
 * @version [版本号, 2020/5/28 15:59]
 */
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String sign = request.getHeader("sign");
        String timeStamp = request.getHeader("timeStamp");

        NotRepeatSubmit notRepeatSubmit = null;
        long expireTime =0L;
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            notRepeatSubmit = method.getAnnotation(NotRepeatSubmit.class);
            expireTime = notRepeatSubmit == null ? 5 * 60 * 1000 : notRepeatSubmit.value();
            System.out.println(expireTime);
        }
        if (notRepeatSubmit != null) {
            ValueOperations<String ,Integer> valueOperations = redisTemplate.opsForValue();
            Integer value = valueOperations.get(sign);
            Assert.isTrue(value==null,"请勿重复提交");

            valueOperations.set(sign,0,expireTime, TimeUnit.MILLISECONDS);
        }
        return super.preHandle(request, response, handler);
    }
}
