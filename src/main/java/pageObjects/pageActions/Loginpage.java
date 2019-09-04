package pageObjects.pageActions;

public class Loginpage extends pageObjects.pageObject.Loginpage {

	public void login(String tenant, String username, String password) {
		getTenant().sendKeys(tenant);
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);
		click(getSignin());
	}

}
