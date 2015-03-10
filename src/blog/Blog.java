package blog;

import java.util.ArrayList;
import java.util.Calendar;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((allPosts == null) ? 0 : allPosts.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Blog other = (Blog) obj;
		if (allPosts == null) {
			if (other.allPosts != null)
				return false;
		} else if (!allPosts.equals(other.allPosts))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	public void setPosts(ArrayList<Post> allposts){
		this.allPosts = allposts;
	}
	
	public void search(int month, String someone){
		
		Calendar cal = Calendar.getInstance();
		
		for(Post p : allPosts){
			cal.setTime(p.getDate());
			int postMonth = cal.get(Calendar.MONTH) + 1;
			
			if((postMonth==month)&&(p.getContent().contains(someone)))
				System.out.println(p);
		}
	}

}
