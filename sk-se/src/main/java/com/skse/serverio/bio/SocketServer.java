package com.skse.serverio.bio;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * bio
 */
public class SocketServer {
	
	
	public static void main(String[] args) throws Exception {
		
		int port = 18081;
		
		ServerSocket server = new ServerSocket(port);
		ExecutorService threadPool = Executors.newFixedThreadPool(50);
		System.out.println("start success");
		for (;;) {
			Socket socket = server.accept();
			try {
				threadPool.execute(new ServerHandler(socket));

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
	}

}
