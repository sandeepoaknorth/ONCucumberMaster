package pageObjects.pageActions;

public class InterestRateMaintenancePage extends pageObjects.pageObject.InterestRateMaintenancePage {

	public void clickUpdate() {
		scriptClick(getUpdateButton());
	}

	public void clickCancel() {
		scriptClick(getCancelbutton());
	}

	public void clickRefresh() {
		scriptClick(getRefreshButton());
	}

}
