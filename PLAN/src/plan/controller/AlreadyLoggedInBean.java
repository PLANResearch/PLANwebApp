package plan.controller;

import javax.faces.context.FacesContext;

import plan.model.User;

public class AlreadyLoggedInBean {
	User user; 
	
	public AlreadyLoggedInBean() {
		user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(User.USER_INFO);
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	

}
