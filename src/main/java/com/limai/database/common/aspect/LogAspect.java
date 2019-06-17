package com.limai.database.common.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @Author: zhangbin
 * @Date: 2018/11/10 13:32
 * @Desc: 日志切面
 */
@Slf4j
@Aspect
@Component
public class LogAspect implements Ordered {
    //定义切点:
    //可以用使用 && ||逻辑运算符
    @Pointcut("execution(public * com.limai.database..*.controller.*.*(..)) || execution(public * com.limai.database.controller.*.*(..))")
    public void logPointCut() {
    }
    //定义切面：
    @Around("logPointCut()")
    public Object commonLogAspect(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();
        String method = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().getName();
//        System.out.println("className:"+className);
        //从RequestContextHolder中获取请求参数（当方法中没有传请求参数情况下适用）
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String userId = (String) request.getAttribute("userId");
        String requestURI = request.getRequestURI();
        String httpMethod = request.getMethod();
        JSONObject requestParams = this.getAllRequestParams(request);
        JSONObject jsonObject = new JSONObject();
        try {
            //获取方法的所有参数：
            Object[] args = pjp.getArgs();
//            System.out.println("args:"+args.toString());
            String[] paramNames = ((MethodSignature) pjp.getSignature()).getParameterNames();
            Class[] paramTypes = ((MethodSignature) pjp.getSignature()).getParameterTypes();
            for (int i=0;i<args.length;i++) {
                if (! (args[i] instanceof  HttpServletRequest) && !requestParams.containsKey(paramNames[i])){
                    jsonObject.put(paramNames[i],args[i].toString());
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        // " " 中如果需要加" ",前面加 \ 转义
        log.info("{}.request#{\"uri\":{},\"httpMethod\":{},\"userId\":{},\"params\":{},\"data\":{}"
                ,method,requestURI,httpMethod,userId,JSONObject.toJSONString(requestParams),jsonObject);
        Object proceedResult = pjp.proceed();
        log.info("{}.response#{}",method, JSON.toJSON(proceedResult));
        log.info("{}.timecost:{}",method,System.currentTimeMillis()-begin);
        return proceedResult;
    }
    //从HttpServletRequest中获取所有请求参数
    private JSONObject getAllRequestParams(HttpServletRequest request)  {
        JSONObject params = new JSONObject();
        Enumeration<String> eumNames = request.getParameterNames();
        while (eumNames.hasMoreElements()) {
            String paramName = eumNames.nextElement();
            String paramValue = request.getParameter(paramName);
            params.put(paramName, paramValue);
        }
        return params;
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
