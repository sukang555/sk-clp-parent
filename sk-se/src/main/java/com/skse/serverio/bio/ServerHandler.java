package com.skse.serverio.bio;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by sukang on 2018/7/24.
 */
public class ServerHandler  implements Runnable{

    private Socket socket;

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream= null;
        BufferedInputStream bufferedInputStream = null;
        PrintWriter printWriter = null;

        try {
            inputStream = socket.getInputStream();
            printWriter = new PrintWriter(socket.getOutputStream(),true);

            bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] b = new byte[1024];
            int length = 0;
            StringBuilder stringBuilder = new StringBuilder();
            while ((length = bufferedInputStream.read(b)) != -1) {
                stringBuilder.append(new String(b, 0, length));
            }

            System.out.println(Thread.currentThread().getName()
                    +"接收到的数据为:"+stringBuilder.toString());

            printWriter.write("success--".concat(Thread.currentThread().getName()));

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (inputStream != null){
                try {
                    inputStream.close();
                    inputStream = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (printWriter != null){
                printWriter.close();
                printWriter = null;
            }

            if (socket != null){
                try {
                    socket.close();
                    socket = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
