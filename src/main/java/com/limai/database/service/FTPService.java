package com.limai.database.service;

import jdk.nashorn.internal.objects.annotations.Constructor;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.SocketException;

/**
 * @author Zhang bin
 * @version [版本号, 2020/6/5 10:26]
 */
@Service
public class FTPService {

    private static String host = "39.105.37.47";
    private static String user = "zhangbin";
    private static String password = "123456";
    private static String directory = "/home/vsftpd/zhangbin";
    private static String saveFile = "G:\\saveftp";

    private FTPClient ftpClient;

    /**
     * 获取FTPCLIENT
     */
    @PostConstruct
    public void getFtpClient() {
        try {
            FTPClient ftp = new FTPClient();
            // 连接
            ftp.connect(host);// 连接FTP服务器
            ftp.login(user, password);// 登陆FTP服务器
            //验证FTP服务器是否登录成功
            int replyCode = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("登录验证失败");
            }
            ftp.setControlEncoding("UTF-8"); // 中文支持
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
//		ftp.enterLocalPassiveMode();  // 被动模式
            ftp.enterLocalActiveMode();  // 主动模式
            ftp.changeWorkingDirectory(directory);
            this.ftpClient = ftp;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("FTP连接发生异常！", e);
        }
    }

    /**
     * FTP下载文件
     */
    public String download() {
        OutputStream os = null;
        String result = "";
        try {
            //切换FTP目录
            ftpClient.changeWorkingDirectory(directory);
            ftpClient.setRemoteVerificationEnabled(false);
            FTPFile[] ftpFiles = ftpClient.listFiles();
            //遍历目录下所有文件
            for (FTPFile file : ftpFiles) {
                File localFile = new File(saveFile + File.separator + file.getName());
                os = new FileOutputStream(localFile);
                ftpClient.retrieveFile(file.getName(), os);
                os.close();
            }
            System.out.println("ftp dowmload over");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("FTP客户端出错！", e);
        } finally {
            try {
                if (os != null) {
                    os.close();
                    ftpClient.logout();
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("关闭FTP连接发生异常！", e);
            }
        }
        return result;
    }

    public void upload() {
        FileInputStream is = null;
        try {
            File file = new File("G:\\llcd1.png");
            is = new FileInputStream(file);
            ftpClient.changeWorkingDirectory(directory);
            ftpClient.setRemoteVerificationEnabled(false);
            ftpClient.setBufferSize(1024);
            ftpClient.setControlEncoding("Utf-8");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            //参数1是文件名（一定要后缀）
            ftpClient.storeFile("llcd1.png", is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                    ftpClient.logout();
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("关闭FTP连接发生异常！", e);
            }
        }
    }
}