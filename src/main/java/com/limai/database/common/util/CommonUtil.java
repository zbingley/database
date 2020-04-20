package com.limai.database.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

/**
 * @author zhang bin
 * @date 2019/11/6
 */
@Slf4j
public class CommonUtil {
    /**
     * 数据脱敏工具类
     *
     * @param content    原文
     * @param headLength 头部长度
     * @param tailLength 尾部长度
     * @return 脱敏结果
     */
    public static String desensitization(String content, int headLength, int tailLength) {
        if (StringUtils.isEmpty(content)) {
            return content;
        }
        if (content.length() <= headLength + tailLength) {
            log.info("数据长度不够，不脱敏");
            return content;
        }
        int length = content.length();
        return StringUtils.rightPad(content.substring(0, headLength), length - tailLength, "*") + content.substring(length - tailLength);
    }


}
