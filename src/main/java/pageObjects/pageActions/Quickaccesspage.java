package pageObjects.pageActions;

public class Quickaccesspage extends pageObjects.pageObject.Quickaccesspage{
	
	public void clickCustomer()
	{
		scriptClick(getCustomer());	
	}
	
	public void clickMenu() {
		scriptClick(getMenu());
	}
	
	public void clickInterestRateMaintenance() {
		scriptClick(getIntrstratemaintenance());
	}
	
	public void clickIndexRate() {
		scriptClick(getIndexRate());
	}

}

