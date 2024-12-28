package com.skse.serverio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * https://blog.csdn.net/anxpp/article/details/51512200
 *
 * Created by sukang on 2018/7/24.
 */
public class NioServerHandler implements Runnable{

    private Selector selector;
    private ServerSocketChannel serverChannel;
    private volatile boolean started;


    public NioServerHandler(int port) {

        try {
            //开启一个选择器
            selector = Selector.open();
            //打开监听通道
            serverChannel = ServerSocketChannel.open();

            serverChannel.configureBlocking(false);
            serverChannel.socket().bind(new InetSocketAddress(port),1024);
            //监听客户端连接请求
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);
            //标记服务器已开启
            started = true;
            System.out.println("服务器已启动，端口号：" + port);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {




    }
}
