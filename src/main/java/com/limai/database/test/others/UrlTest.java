package com.limai.database.test.others;

import org.springframework.util.StringUtils;

/**
 * @description:
 * @author: zhangbin
 * @date: 2019/8/12
 */
public class UrlTest {
    public static void main(String[] args) {
        System.out.println(convertName("query_equip_auth"));
        // result  queryEquipAuth
    }
    private static String convertName(String name){
        if(StringUtils.isEmpty(name)){
            return null;
        }
        String[] splitWords = name.split("_");
        StringBuilder newName = new StringBuilder();
        for (int i = 0; i < splitWords.length; i++) {
            if(i==0){
                newName.append(splitWords[0]);
            }
            newName.append(splitWords[i].substring(0,1).toUpperCase()+splitWords[i].substring(1));
        }
        return newName.toString();
    }
}
