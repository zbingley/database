package com.limai.database.test.thread;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import sun.net.www.http.HttpClient;

import java.io.IOException;

/**
 * @author zhang bin
 * @date 2019/10/16
 */
public class ThreadExample {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable(){
                @Override
                public void run(){
                    CloseableHttpClient httpclient = HttpClients.createDefault();
                    HttpGet httpGet = new HttpGet("http://localhost:8080/users/thread");
                    System.out.println(Thread.currentThread().getName());
                    httpGet.setHeader("Thread", Thread.currentThread().getName());
                    try {
                        httpclient.execute(httpGet);
                    } catch (ClientProtocolException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }
}
