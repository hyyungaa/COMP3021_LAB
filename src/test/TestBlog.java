package test;

import java.io.*;
import java.util.Date;
import base.*;
import blog.*;

public class TestBlog {
	
	public String getInput(){
		String line = "";
		System.out.print("Enter the prompt:");
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			line = br.readLine();
		}catch(IOException e){
			e.printStackTrace();
		}
		return line;
	}
	
	public static void main(String[] args){
		
		TestBlog testBlog = new TestBlog();
		User user = new User(1, "COMP3021", "COMP3021@cse.ust.hk");
		Blog myblog = new Blog(user);
		String prompt = null;
		
		while(!(prompt = testBlog.getInput()).equals("exit")){
			
			if(prompt.startsWith("list")){
				System.out.println("Current post:");
				myblog.list();
			}
			else if(prompt.startsWith("post")){
				
				String[] promptcontent = prompt.split(" ");
				String content = new String();
				for(int i = 1; i<promptcontent.length; i++){
					content += (promptcontent[i] + " ");
				}
				Date date = new Date();
				Post post = new Post(date, content);
				myblog.post(post);
				System.out.println("A new Post:");
				System.out.println(post);
			}
			else if(prompt.startsWith("delete")){
				String[] promptcontent = prompt.split(" ");
				int index = Integer.parseInt(promptcontent[1]);
				myblog.delete(index);
			}
		}
	}

}
