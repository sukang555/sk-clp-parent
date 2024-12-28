package com.skse.serverio.nio;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sukang on 2018/7/24.
 */
public class SocketServer {


    public static void main(String[] args) {
        int port = 18081;
        try {
            ServerSocket server = new ServerSocket(port);
            ExecutorService threadPool = Executors.newFixedThreadPool(50);
            System.out.println("start success");
            for (;;) {
                Socket socket = server.accept();

                    threadPool.execute(new NioServerHandler(port));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
