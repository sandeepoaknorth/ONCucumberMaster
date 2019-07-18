package pageObjects.pageActions;

public class Quickaccesspage extends pageObjects.pageObject.Quickaccesspage{
	
	public void clickCustomer()
	{
		scriptClick(getCustomer());	
	}
	
	public void clickMenu() {
		scriptClick(getMenu());
	}

}

