package com.limai.database.common.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * @Author: zhangbin
 * @Date: 2019/6/16 15:24
 * @Desc:
 */
public class AESUtils {
    private static final Logger logger= LoggerFactory.getLogger(AESUtils.class);
    private static final String KEY_ALGORITHM="AES";
    private static final String DEFAULT_CIPHER_ALGORITHM="AES/ECB/PKCS5PAdding";//默认的加密算法


    public static String encrypt(String content,String password){
        try {
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);//创建密码器
            cipher.init(Cipher.ENCRYPT_MODE,getSecretKey(password));//初始化为加密模式的密码器
            byte[] contentBytes = content.getBytes(StandardCharsets.UTF_8);
            byte[] result = cipher.doFinal(contentBytes);
            return Base64Utils.encodeToString(result);
//            return Base64.getEncoder().encodeToString(result);
        } catch (Exception e) {
            logger.error("加密失败{}",e.getMessage());
        }
        return null;
    }

    public static String decrypt(String content,String password){
        try {
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);//创建密码器
            cipher.init(Cipher.ENCRYPT_MODE,getSecretKey(password));//初始化为加密模式的密码器
            byte[] bytes =Base64Utils.decodeFromString(content);
//            byte[] bytes = Base64.getDecoder().decode(content);
            byte[] result = cipher.doFinal(bytes);
            return new String(result,StandardCharsets.UTF_8);
        } catch (Exception e) {
            logger.error("解密失败{}",e.getMessage());
        }
        return null;
    }
    /*
    * AES生成秘钥
    *
    * @param password 密码
    * @return 秘钥
    * */
    private static SecretKeySpec getSecretKey(final String password){
        KeyGenerator kg=null;
        try {
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes());
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
            kg.init(128,random);
            SecretKey secretKey = kg.generateKey();
            byte[] encoded = secretKey.getEncoded();
            return new SecretKeySpec(encoded,KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            logger.error("生成秘钥失败：{}",e.getMessage());
        }
        return null;
    }
}
