package com.limai.database;

import com.limai.database.common.util.AESUtils;
import com.limai.database.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: zhangbin
 * @Date: 2019/6/16 15:50
 * @Desc:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AESUtilsTest {

    @Autowired
    private PersonRepository personRepository;
    @Test
    public void testEncrypt(){
        String content="18296511820";
        String password="5cd2413deb998e0e09544749";
        String encrypt = AESUtils.encrypt(content, password);
        System.out.println(encrypt);
        String decrypt = AESUtils.decrypt(encrypt, password);
        System.out.println(decrypt);
    }
}
