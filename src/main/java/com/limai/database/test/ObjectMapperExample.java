package com.limai.database.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author: zhang bin
 * @date: 2019/8/20
 */
public class ObjectMapperExample {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Person jack = new Person(12, "Jack", new Date());
        // object to jsonString
        String string = objectMapper.writeValueAsString(jack);
        /**
         * {"age":12,"name":"Jack","birthday":1566265772319}
         * 默认情况Jackson会将日期转换成long类型，可以自己设置日期格式
         */
        System.out.println(string);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        objectMapper.setDateFormat(simpleDateFormat);
        String string1 = objectMapper.writeValueAsString(jack);
        /**
         * {"age":12,"name":"Jack","birthday":"2019-08-20"}
         */
        System.out.println(string1);
        //jsonString to Object 必须要有无参构造，否则会报错
        Person person = objectMapper.readValue(string1, Person.class);
        System.out.println(person);
        // 报UnrecognizedPropertyException未识别属性异常，hobby为Person未定义属性，可以设置不报错
        String jsonStr="{\"age\":12,\"name\":\"Jack\",\"birthday\":\"2019-08-20\",\"hobby\":\"reading\"}";
        //person person1 = objectMapper.readValue(jsonStr, Person.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        Person person1 = objectMapper.readValue(jsonStr, Person.class);
        System.out.println(person1);
        Person person2 = new Person(13, "Jack");
        String string2 = objectMapper.writeValueAsString(person2);
        //{"age":13,"name":"Jack"}
        System.out.println(string2);

    }
    @AllArgsConstructor
    @Data
    @NoArgsConstructor
    private static class Person{
        private int age;
        private String name;
        @JsonInclude(JsonInclude.Include.NON_EMPTY)// 字段为null时不展示
        private Date birthday;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }


}
