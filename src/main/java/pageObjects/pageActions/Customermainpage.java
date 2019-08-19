package pageObjects.pageActions;

public class Customermainpage extends pageObjects.pageObject.Customermainpage {
	
	public void clickaccountActionView(String accountStatus) throws InterruptedException {
		scriptClick(getAccountView(accountStatus));
	}
	
}
