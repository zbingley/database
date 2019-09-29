package com.limai.database.test.rsa;

import javax.crypto.Cipher;
import java.nio.charset.Charset;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
/**
* RSA非对称加密
* */
public class RsaCoder {
    private static final String ALGORITHM_RSA="RSA";
    private static final String CHARSET="UTF-8";
    private static final int KEY_SIZE=512;
    private static final String PUBLIC_KEY="publicKey";
    private static final String PRIVATE_KEY="privateKey";
/*
*  生成密钥对
*
* */
 private static Map<String,String> generateKey() throws Exception {
        HashMap<String, String> keyMap = new HashMap<>();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM_RSA);
        keyPairGenerator.initialize(KEY_SIZE);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        String privateKey = Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded());
        String publicKey = Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());
        keyMap.put(PUBLIC_KEY,publicKey);
        keyMap.put(PRIVATE_KEY,privateKey);
        System.out.println(keyMap);
        return  keyMap;
    }

    private static Map<String,Object> generateKeyAsObject() throws Exception {
        HashMap<String, Object> keyMap = new HashMap<>();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM_RSA);
        keyPairGenerator.initialize(KEY_SIZE);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey  privateKey= keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        keyMap.put(PUBLIC_KEY,publicKey);
        keyMap.put(PRIVATE_KEY,privateKey);
        return  keyMap;
    }

    /*
    * 私钥加密
    *
    * @param data
    * @param key
    * @return byte[]
    * */
    public static byte[] encryptByPrivateKey(byte[] date,byte[] key) throws Exception {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE,privateKey);
        return cipher.doFinal(date);
    }
    /*
     * 私钥加密
     *
     * @param data
     * @param base64Key
     * @return String
     * */
    public static String encryptByPrivateKey(String data,String base64Key) throws Exception {
        byte[] encrypted = encryptByPrivateKey(data.getBytes(Charset.forName(CHARSET)), Base64.getDecoder().decode(base64Key));
        return Base64.getEncoder().encodeToString(encrypted);
    }
    /*
     * 公钥加密
     *
     * @param data
     * @param key
     * @return byte[]
     * */
    public static byte[] encryptByPublicKey(byte[] data,byte[] key) throws Exception {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
        return cipher.doFinal(data);
    }
    /*
     * 公钥加密
     *
     * @param data 待加密数据
     * @param base64Key 公钥
     * @return string 加密后的数据
     * */
    public static String encryptByPublicKey(String data,String base64Key) throws Exception {
        byte[] encrypted = encryptByPublicKey(data.getBytes(Charset.forName(CHARSET)), Base64.getDecoder().decode(base64Key));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    /*
     * 私钥加密
     *
     * @param data 待加密数据
     * @param base64Key 私钥
     * @return string 加密后的数据
     * */
    public static byte[] decryptByPrivateKey(byte[] data,byte[] key) throws Exception {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        return cipher.doFinal(data);
    }
    public static byte[] decryptByPublicKey(byte[] data,byte[] key) throws Exception {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE,publicKey);
        return cipher.doFinal(data);
    }
    public static String decryptByPublicKey(String encryptedBase64,String base64Key) throws Exception {
        byte[] bytes = decryptByPublicKey(Base64.getDecoder().decode(encryptedBase64), Base64.getDecoder().decode(base64Key));
        return new String(bytes,CHARSET);
    }
    public static String decryptByPrivateKey(String encryptedBase64,String base64Key) throws Exception {
        byte[] bytes = decryptByPrivateKey(Base64.getDecoder().decode(encryptedBase64), Base64.getDecoder().decode(base64Key));
        return new String(bytes,CHARSET);
    }
    public static void main(String[] args) throws Exception {
        Map<String, String> keyMap = generateKey();
        String data="hello World!";

        String encryptedBase64Data = encryptByPublicKey(data, keyMap.get(PUBLIC_KEY));
        String decrypt = decryptByPrivateKey(encryptedBase64Data, keyMap.get(PRIVATE_KEY));
        System.out.println(decrypt);
        String encrypt = encryptByPrivateKey(data, keyMap.get(PRIVATE_KEY));
        System.out.println(decryptByPublicKey(encrypt,keyMap.get(PUBLIC_KEY)));

        Map<String, Object> keyMap1 = generateKeyAsObject();
        String sign = sign(data, (PrivateKey) keyMap1.get(PRIVATE_KEY));
        boolean verify = verify(data, sign, (PublicKey) keyMap1.get(PUBLIC_KEY));
        System.out.println("verify result:"+verify);
    }
    private static String sign(String data, PrivateKey privateKey) throws Exception {
       /* byte[] keyBytes = privateKey.getEncoded();
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
        PrivateKey key = keyFactory.generatePrivate(keySpec);*/
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initSign(privateKey);
        signature.update(data.getBytes());
        return Base64.getEncoder().encodeToString(signature.sign());
    }
    private static boolean verify(String srcData,String sign,PublicKey publicKey) throws Exception{
       /* byte[] keyBytes = publicKey.getEncoded();
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey key = keyFactory.generatePublic(keySpec);*/
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initVerify(publicKey);
        signature.update(srcData.getBytes());
        return signature.verify(Base64.getDecoder().decode(sign.getBytes()));
    }
}
