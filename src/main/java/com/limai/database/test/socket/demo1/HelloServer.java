package com.limai.database.test.socket.demo1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Zhang bin
 * @version [版本号, 2020/7/4 13:37]
 */
public class HelloServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket client;
        client = serverSocket.accept();
        System.out.println("Hello client!");
    }
}
