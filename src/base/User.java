package base;

public class User {
	
	private int userId;
	private String userName;
	private String userEmail;
	
	public User(int userId, String userName, String userEmail){
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;			
	}
	
	@Override
	public String toString(){
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail+ "]"; 
	}

}
