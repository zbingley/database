package com.limai.database.test.aop;

import java.lang.reflect.Proxy;
/*
*  JDK动态代理，是生成相应【接口】的代理类，不是使用接口注入的（spring @autowired）就不能使用JDK动态代理，
*  cglib可以解决这个问题，cglib会根据当前目标类，动态生成一个子类，在子类中织入切面逻辑，然后子类对象代理父类对象
*  所以能够织入成功的都是子类能覆盖父类的方法，因此cglib也有一个弊端，它无法处理final方法。
*
* */

public class Main {
    public static void main(String[] args) {
        SMSServiceImpl smsService = new SMSServiceImpl();
        SMSService proxyInstance = (SMSService) Proxy.newProxyInstance(smsService.getClass().getClassLoader(),
                smsService.getClass().getInterfaces(),
                new MoneyCountInvocationHandler(smsService));
        proxyInstance.sendMessage();
        proxyInstance.sendMessage();
        proxyInstance.sendMessage();
    }
}
