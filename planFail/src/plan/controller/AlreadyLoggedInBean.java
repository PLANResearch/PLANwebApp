package plan.controller;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import plan.model.TestHoldData;

public class AlreadyLoggedInBean {
	TestHoldData user;
	
	public AlreadyLoggedInBean(){
		//when creating this bean, if the user is not logged in 
		//(session data for user = null), redirect
		
		//get user data
		TestHoldData dataFromSession = (TestHoldData)FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get("testHoldData");
	
		//check if logged in
		if(dataFromSession == null || dataFromSession.getUserID().equals("")){
			System.out.println("alreadyLoggedIn redirecting to index");
			//if not, redirect to login
			FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(
					FacesContext.getCurrentInstance(), null, "../index.jsf");
		
		} else {//if logged in, get session data.
			user = dataFromSession;
		}
	}
	
	public void logout(){
		System.out.println("logging out");
		//invalidate session
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpSession session = (HttpSession) externalContext.getSession(false);
		session.invalidate();
		
		//redirect to login page
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(
				FacesContext.getCurrentInstance(), null, "../index.jsf");
	}

	public TestHoldData getUser() {
		return user;
	}

	public void setUser(TestHoldData user) {
		this.user = user;
	}
}
