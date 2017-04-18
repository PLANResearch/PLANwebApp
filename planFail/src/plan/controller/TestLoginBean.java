package plan.controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.websocket.Session;

import net.bootsfaces.utils.FacesMessages;

import plan.model.TestHoldData;

public class TestLoginBean {
	
	String userID;
	String password;
	
	public TestLoginBean(){
		//when loading page and bean, redirect if they're already logged in
		
		//get user data
		TestHoldData dataFromSession = (TestHoldData)FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get("testHoldData");
		//if user data isn't null, redirect
		if(dataFromSession != null && dataFromSession.getUserID() != ""){
			System.out.println("TestLogin redirecting to alreadyLoggedIn.jsf");
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("pages/alreadyLoggedIn.jsf");
			} catch (IOException e) {
				System.out.println("failed to redirect");
				e.printStackTrace();
			}
		}
		
	}
	
	public String getUserID(){
		return userID;
	}
	
	public void setUserID(String userID){
		this.userID = userID;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return "";
	}
	
	public void logIn(){
		//this is bullsh*t, do something good for Login, don't do this.
		TestHoldData possibleUser = new TestHoldData();
		if(possibleUser.tryPassword(password)){
			System.out.println("logged IN");
			//have your log in method get the full user data, and put it into the session.
			//session variables can be called what ever you want (they don't need to be testHoldData),
			//but they have to match when you get them.
			possibleUser.setUserID(userID);
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			externalContext.getSessionMap().put("testHoldData", possibleUser);
			//and send it to the next page
			try {
				externalContext.dispatch("pages/alreadyLoggedIn.jsf");
			} catch (IOException e) {
				System.out.println("failed to redirect");
				e.printStackTrace();
			}
			
		} else {
			System.out.println("failed to log in");
		}
	}
	
}
