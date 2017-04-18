package plan.model;

public class TestHoldData {
	String userID;
	String password;
	public TestHoldData(){
		userID = "JohnnyAppleseed";
		password = "password";
	}
	
	public String getUserID(){
		return userID;
	}
	
	public void setUserID(String userID){
		this.userID = userID;
	}
	
	public boolean tryPassword(String password){
		if(password != "" && password.equals(this.password)){
			return true;
		} else {
			return false;
		}
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
}
