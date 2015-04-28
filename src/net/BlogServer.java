package net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import base.*;
import blog.*;

public class BlogServer {
	public static final int PORT = 3021;
	
	public static void main(String[] args){
		try(
				ServerSocket serverSocket = new ServerSocket(PORT);
				Socket clientSocket = serverSocket.accept();
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				){
			String inputLine;
			while((inputLine = in.readLine()) != null){
				out.println(inputLine);
			}
		}catch(IOException e){
			System.out.println("Error!");
			System.out.println(e.getMessage());
		}
	}

}
