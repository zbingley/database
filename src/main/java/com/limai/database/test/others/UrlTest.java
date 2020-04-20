package com.limai.database.test.others;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: zhangbin
 * @date: 2019/8/12
 */
public class UrlTest {
    public static void main(String[] args) {

//        System.out.println("ss="+String.valueOf(null));
        System.out.println(convertName("query_equip_auth"));

        Map<String, Object> map = new HashMap<>();
        map.put("failReason","41");
        System.out.println((String) map.get("failReason"));

        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("===="+stringBuilder.toString());
        // result  queryEquipAuth
        String id="MA0YQ8191000000000020191130";
        System.out.println(id.substring(9));
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
