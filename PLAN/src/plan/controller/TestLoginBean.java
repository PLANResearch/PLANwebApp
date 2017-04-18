package plan.controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import plan.model.User;

public class TestLoginBean {
	String username;
	String password;
	
	public TestLoginBean() {
		
	}
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login() {
		if(password!= null && password.equals("password")) { 
			User user = new User();
			user.setFirstName("sami");
			user.setLastName("glass");
			
			return "page/main?faces-redirect=true";
			//FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(User.USER_INFO, user);
			/*
			try {
				ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
				ec.redirect(ec.getRequestContextPath()+"/pages/main.jsf");
			} catch (IOException e) {
				FacesContext.getCurrentInstance().addMessage("password", 
						new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to Redirect", "ughhh What happened?" ));
			}
			*/
			
		}
		else {
			FacesContext.getCurrentInstance().addMessage("password", 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,"Invalid Password", "Please try your password again" ));
			return "";
		}
	}

}
