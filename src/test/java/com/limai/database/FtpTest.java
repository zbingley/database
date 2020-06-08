package com.limai.database;

import com.limai.database.service.FTPService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Zhang bin
 * @version [版本号, 2020/6/5 10:31]
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FtpTest {

    @Autowired
    private FTPService ftpService;

    @Test
    public void download(){
        ftpService.download();
    }

    @Test
    public void upload(){
      ftpService.upload();
    }
}
