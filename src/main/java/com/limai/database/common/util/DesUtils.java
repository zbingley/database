package com.limai.database.common.util;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.Charset;
import java.security.Key;
import java.util.Arrays;
import java.util.Base64;

/**
 * @author Zhang bin
 * @version [版本号, 2020/3/4 15:30]
 */
public class DesUtils {

    private static final Charset CHARSET = Charset.forName("UTF-8");

    private static Key desKEY=null;

    private static final byte[] DESIV = { 0x12, 0x34, 0x56, 0x78, (byte) 0x90, (byte) 0xAB,
            (byte) 0xCD, (byte) 0xEF };

    public static Key initKey() {
        try {

            // 初始化密钥key

            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");

            keyGenerator.init(56);// 选择DES算法,密钥长度必须为56位

            desKEY = keyGenerator.generateKey();// 生成密钥，每次生成的密钥都是不一样的
            String s = Base64.getEncoder().encodeToString(desKEY.getEncoded());
            System.out.println("Base64编码key:"+s);
            System.out.println("16进制编码key:"+parseByte2HexStr(desKEY.getEncoded()));
            System.out.println("key直接转字符串:"+Arrays.toString(desKEY.getEncoded()));

        } catch (Exception ex) {

            ex.printStackTrace();

        }

        return desKEY;

    }

    public static void main(String[] args) throws Exception {

        initKey();
        String data="测试内容，今天周四";
        String  skey="lIW3CXkw";
        String encrypt = encrypt(data, CHARSET, skey);
        System.out.println("加密前："+data);
        System.out.println("加密后："+encrypt );
        System.out.println(encrypt.length());
        String abcdef = decrypt(encrypt, CHARSET, skey);
        System.out.println("解密后："+abcdef);
    }

    /**
     * 加密
     *
     * @param srcStr
     * @param charset
     * @param sKey
     * @return
     */
    public static String encrypt(String srcStr, Charset charset, String sKey) {
        byte[] src = srcStr.getBytes(charset);
        byte[] buf = encrypt(src, sKey);
        return Base64.getEncoder().encodeToString(buf);
//        return parseByte2HexStr(buf);
    }

    /**
     * 解密
     *
     * @param hexStr
     * @param sKey
     * @return
     * @throws Exception
     */
    public static String decrypt(String hexStr, Charset charset, String sKey) throws Exception {
//        byte[] src = parseHexStr2Byte(hexStr);
        byte[] src = Base64.getDecoder().decode(hexStr);
        byte[] buf = decrypt(src, sKey);
        return new String(buf, charset);
    }

    private static byte[] encrypt(byte[] data, String sKey) {
        try {
            byte[] key = sKey.getBytes();
            // 初始化向量
            IvParameterSpec iv = new IvParameterSpec(DESIV);
            //实例化DES密钥材料
            DESKeySpec desKey = new DESKeySpec(key);
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成securekey
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            Key securekey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, iv);
//            cipher.init(Cipher.ENCRYPT_MODE, securekey);
            // 现在，获取数据并加密
            // 正式执行加密操作
            return cipher.doFinal(data);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] decrypt(byte[] src, String sKey) throws Exception {
        byte[] key = sKey.getBytes(CHARSET);
        // 初始化向量
        IvParameterSpec iv = new IvParameterSpec(DESIV);
        // 创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(key);
        // 创建一个密匙工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        // 将DESKeySpec对象转换成SecretKey对象
        Key securekey = keyFactory.generateSecret(desKey);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, iv);
//        cipher.init(Cipher.DECRYPT_MODE, securekey);
        // 真正开始解密操作
        return cipher.doFinal(src);
    }

    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

}
