package pageObjects.pageActions;

public class ManageLoanpage extends pageObjects.pageObject.ManageLoanpage {
	public void selectLoanSection() {
		int size = getLoanSection().size();
		for (int i = 1; i < size; i++) {
			scriptClick(getLoanSection().get(i));
			if (getAccountStatus().getText().equalsIgnoreCase("Active")) {
				break;
			}
		}
	}

	public void selectLoanSection(String accountName) {
		int size = getLoanSection().size();
		for (int i = 1; i < size; i++) {
			scriptClick(getLoanSection().get(i));
			if (getLoanSection().get(i).getText().contains(accountName)) {
				break;
			}
		}
	}

	public void clickRepayment() {
		scriptClick(getLoanMenuButton());
		scriptClick(getRepaymentButton());
	}
}
