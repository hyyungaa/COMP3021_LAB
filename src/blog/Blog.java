package blog;

import java.util.ArrayList;

import base.*;

public class Blog {
	
	private User user;
	private ArrayList<Post> allPosts;
	
	public Blog(User user){
		this.user = user;
		allPosts = new ArrayList<Post>();
	}
	
	public void setUser(User user){
		this.user = user;
	}
	
	public User getUser(){
		return user;
	}
	
	public void post(Post p){
		allPosts.add(p);
	}
	
	public void list(){
		for(int i=0; i<allPosts.size(); i++){
			if(allPosts.get(i)!=null){
				System.out.println("Post[" + (i+1) + "]:" + allPosts.get(i));
			}
		}
	}
	
	public void delete(int index){
		index-=1;
		if(index>=allPosts.size() || index<0){
			System.out.println("The input index is illegal!!");
		}
		else if(allPosts.get(index)==null){
			System.out.println("The corresponding post is already deleted!!");
		}
		else{
			allPosts.remove(index);
		}
	}
	
	@Override
	public String toString(){
		return allPosts.toString();
	}
	
	public boolean equals(Object o){
		boolean ans = true;

		if(o == null){
			ans = false;
		}
		else{
			o.getClass();
			Blog blog = (Blog) o;
			if(!this.user.equals(blog.user) || !this.allPosts.equals(blog.allPosts)){
				ans = false;
			}
		}

		return ans;
	}
	
	public int hashCode(){
		
		int hashCode = 0;

		hashCode = user.hashCode() + allPosts.hashCode();

		return hashCode;
	}

}
