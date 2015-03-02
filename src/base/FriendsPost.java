package base;

import java.util.Date;

public class FriendsPost  extends Post{
	
	private User friends;
	
	public FriendsPost(Date date, String content, User user){
		super(date, content);
		 this.friends = user;		 
	}
	
	public String toString(){
		return friends.toString() + "\n" + this.getDateinString() + "\n" + this.getContent();
	}
}
