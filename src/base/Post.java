package base;

import java.util.Date;

public class Post {
	
	private Date date;
	private String content;
	
	public Post(Date date, String content){
		this.date = date;
		this.content = content;
	}
	
	public String getContent(){
		return content;
	}
	
	public String getDate(){
		return date.toString();
	}
	
	public void setContent(String content){
		this.content = content;
	}
	
	@Override
	public String toString(){
		return date.toString()+ "\n" + content;
	}
	
	@Override
	public boolean equals(Object o){
		
		boolean ans = true;
		
		if(o == null){
			ans = false;
		}
		else{
			o.getClass();
			Post post = (Post) o;
			if(!this.equals(o)){
				ans = false;
			}
		}
		
		return ans;
	}
	
	@Override
	public int hashCode(){
		int hashCode = 0;
		
		
		
		date.hashCode();
		content.hashCode();
		
		return hashCode;
	}
	
	public boolean contains(String keyword){
		if(content.contains(keyword))
			return true;
		else
			return false;
	}

}
