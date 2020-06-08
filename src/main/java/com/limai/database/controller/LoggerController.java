package com.limai.database.controller;

import lombok.Data;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * @author Zhang bin
 * @version [版本号, 2020/6/6 8:47]
 */
@RestController
@RequestMapping("/logger")
public class LoggerController {

    @RequestMapping("/change")
    public String change(String packageName,String level){
        try {
            Level level1 = Level.toLevel(level);
            Logger logger = LogManager.getLogger(packageName);
            logger.setLevel(level1);
        } catch (Exception e) {
            return "false";
        }
        return "true";
    }



    /**
     * 查看现在包的日志级别
     * @return
     */
    @RequestMapping(value = "/loggers", method = RequestMethod.GET)
    public void index(HttpServletRequest request, HttpServletResponse response) {

        StringBuilder sb = new StringBuilder();
        try {
            sb.append("<html>");
            Writer writer = response.getWriter();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=utf-8");
            Enumeration logs = LogManager.getCurrentLoggers();
            while (logs.hasMoreElements()) {
                Logger logger = (Logger) logs.nextElement();
                sb.append("<span style='display:block;'>");
                sb.append(logger.getName()).append(",").append(logger.getEffectiveLevel());    //可根据名称  显示指定包名的
                sb.append("</span>");
            }
            sb.append("</html>");
            writer.write(sb.toString());
            writer.flush();
            if(writer != null){
                writer.close();
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
        }

    }


    public static void main(String[] args) {
        ArrayList<A> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            A a = new A();
            a.setAge(i);
            a.setName("nnnnn");
            list.add(a);
        }
        list.forEach(a->{
            a.setAge(a.getAge()+1);
        });

        System.out.println(list);
    }

    @Data
    private static class A{
        private String name;
        private int age;
    }

}

