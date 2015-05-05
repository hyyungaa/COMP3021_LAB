package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiThreadServer {
	
	ArrayList clientOutputStreams;
	int visitor = 0;
	
	public class ThreadHandler implements Runnable{
		
		BufferedReader reader;
		Socket sock;
		int visitor;
		
		public ThreadHandler(Socket clientSocket, int visitor){
			try{
				sock = clientSocket;
				InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(isReader);
			    this.visitor = visitor;
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
		public void run(){
			String inputLine;
			try{
				PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
				while((inputLine = reader.readLine()) != null){
					if(inputLine.equals("visitor")){
						out.println("You're the " + visitor + " visitor today");
					}
					else if(inputLine.equals("quit"))
						System.exit(1);
					else
					out.println(inputLine);
				}
			}catch(Exception ex){
//				ex.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		new MultiThreadServer().go();
	}
	
	public void go(){
		
		clientOutputStreams = new ArrayList();
		
		try{
			ServerSocket serverSock = new ServerSocket(3021);
			
			while(true){
				Socket clientSocket = serverSock.accept();
				visitor++;
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
				clientOutputStreams.add(writer);
				
				Thread t = new Thread(new ThreadHandler(clientSocket, visitor));
				t.start();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}


}
