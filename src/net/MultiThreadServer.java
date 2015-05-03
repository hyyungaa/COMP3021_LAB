package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer {

	public static final int PORT = 300;
	
	public static int visitor = 0;

	public static void main(String[] args){
		while(true){
			try(
					ServerSocket serverSocket = new ServerSocket(PORT);
					Socket clientSocket = serverSocket.accept();
					PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
					BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
					){
				visitor++;
				ThreadHandler newThread = new ThreadHandler(clientSocket, visitor);
				newThread.run();
			}catch(Exception e){
//				System.out.println("Error!");
//				System.out.println(e.getMessage());
			}
		}
	}


}
