package net;

import java.io.*;
import java.net.Socket;
import java.util.Date;

import base.*;
import blog.*;

public class BlogClient {
	public static final String IP="127.0.0.1";
	public static final int PORT = 3021;
	
	public static void main(String[] args){
		try(
				Socket echoSocket = new Socket(IP, PORT);
				PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
				BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
				
				){			
			String content;
			while((content = stdIn.readLine()) != null){
				Date date = new Date();
				Post post = new Post(date, content);
				out.println(post.toString());
				System.out.println("echo: " + in.readLine());
			}		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
