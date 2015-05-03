package net;

import java.io.*;
import java.net.Socket;

public class ThreadHandler implements Runnable{
	
	private Socket client;
	private int visitor;
	
	public ThreadHandler(Socket client, int visitor){

		this.client = client;
		this.visitor = visitor;

	}

	public void run(){
		try(
				PrintWriter out = new PrintWriter(client.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				){
			String inputLine;
			while((inputLine = in.readLine()) != null){
				if(inputLine.equals("visitor")){
					out.println("You're the " + visitor + " visitor today");
				}
				else if(inputLine.equals("quit"))
					System.exit(1);
				else
				out.println(inputLine);
			}
		}catch(IOException e){
			//e.printStackTrace();
		}
	}

}
