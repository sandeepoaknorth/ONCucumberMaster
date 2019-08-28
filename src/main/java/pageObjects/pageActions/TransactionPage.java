package pageObjects.pageActions;

import utils.JavaOnlyMethods;

public class TransactionPage extends pageObjects.pageObject.TransactionPage {
	public void comments() {
		JavaOnlyMethods j = new JavaOnlyMethods();
		getComments().sendKeys(j.getAlphaNumericString(6));
		scriptClick(getTransaction());
	}
}
