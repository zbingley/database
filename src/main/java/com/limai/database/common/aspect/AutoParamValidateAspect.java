package com.limai.database.common.aspect;

import com.limai.database.common.BaseResponse;
import com.limai.database.common.annotation.AutoParamValidate;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.lang.reflect.Parameter;
import java.util.Set;

/**
 * @Author: zhangbin
 * @Date: 2019/6/6 15:16
 * @Desc:
 */
@Component
@Aspect
public class AutoParamValidateAspect implements Ordered {
    private Validator validator=Validation.buildDefaultValidatorFactory().getValidator();

    @Pointcut(value = "execution(public * com.limai.database.controller.*.*(..)) ||execution(public * com.limai.database..*.controller.*.*(..))")
    public void autoParamValidatePointcut(){
    }

    @Around(value = "autoParamValidatePointcut() && @annotation(autoParamValidate)" )
    public Object autoParamValidateAround(ProceedingJoinPoint pjp, AutoParamValidate autoParamValidate) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
//        String methodName = methodSignature.getName();
        Parameter[] parameters = methodSignature.getMethod().getParameters();
        Object[] args = pjp.getArgs();
        for(int i=0;i<parameters.length;i++) {
            if(parameters[i].isAnnotationPresent(RequestBody.class)){
                BaseResponse<?> response = validate(methodSignature, args[i]);
                if(response!=null){
                    return response;
                }
            }
        }
        return pjp.proceed();
    }

    private BaseResponse<?> validate(MethodSignature methodSignature,Object arg) throws Exception {
        BaseResponse<?> response =null;
        Set<ConstraintViolation<Object>> constraintViolationSet = validator.validate(arg);
        // 若不为空，则有参数不合法，返回错误信息
        if(!constraintViolationSet.isEmpty()){
            ConstraintViolation<Object> first = constraintViolationSet.iterator().next();
            if(BaseResponse.class.isAssignableFrom(methodSignature.getReturnType())){
                 response = (BaseResponse) methodSignature.getReturnType().newInstance();
                 response.setCode(98);
                 response.setMsg(first.getMessage());
            }else {
                throw new RuntimeException("被AutoParamValidate修饰的方法返回值必须为BaseResponse");
            }
        }
        return response;
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
