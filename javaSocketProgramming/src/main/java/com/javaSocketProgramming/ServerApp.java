package com.javaSocketProgramming;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

	public static void main(String[] args) throws IOException {

		System.out.println("Start Socker Programming Server !");
		System.out.println("Wating from client !");
		ServerSocket serSocket = new ServerSocket(9999);

		Socket sock = serSocket.accept();
		System.out.println("Client connected !");

		InputStream in = sock.getInputStream();
		OutputStream out = sock.getOutputStream();
		byte buffer[] = new byte[1024];

		
		in.read(buffer);
		System.out.println("Received from Client: " + new String(buffer).trim());

		out.write("Hellow from Server".getBytes());

		sock.close();
		serSocket.close();
	}

}
