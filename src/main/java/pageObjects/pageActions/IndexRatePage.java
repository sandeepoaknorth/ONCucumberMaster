package pageObjects.pageActions;

public class IndexRatePage extends pageObjects.pageObject.IndexRatePage{
		
	public void clickUpdate() {
		scriptClick(getUpdateButton());
	}
	
	public void clickRefresh() {
		scriptClick(getRefreshButton());
	}
	
	public void clickCancel() {
		scriptClick(getCancelbutton());
	}
	
	public void clickFrequency() {
		scriptClick(getTenorFrequency());
	}
	
	public void fixedTenorYes() throws InterruptedException {
		if(getToggleButton().getAttribute("class").contains("mat-checked")) {
			System.out.println("Selecting Fixed Tenor.");
			softAssert.assertEquals(getTenorValue().isEnabled(), true, "Tenor Value field is Disabled; Please check.");
			softAssert.assertEquals(getTenorFrequency().isEnabled(), true, "Tenor Frequency field is Disabled; Please check.");
		} else {
			getToggleButton().click();
			System.out.println("Selecting Fixed Tenor.");
			softAssert.assertEquals(getTenorValue().isEnabled(), true, "Tenor Value field is Disabled; Please check.");
			softAssert.assertEquals(getTenorFrequency().isEnabled(), true, "Tenor Frequency field is Disabled; Please check.");
		}
	}
	
	public void fixedTenorNo() throws InterruptedException {
		if(getToggleButton().getAttribute("class").contains("mat-checked")) {
			getToggleButton().click();
		}
		System.out.println("Selecting Variable Tenor aka BoE rate.");
		softAssert.assertEquals(getTenorValue().getSize(), 0, "Tenor Value field is Enabled; Please check.");
		softAssert.assertEquals(getTenorFrequency().getSize(), 0, "Tenor Frequency field is Enabled; Please check.");
	}
	
	public int searchByIndex(String indexName) throws InterruptedException {
		getFilterByIndex().sendKeys(indexName);
		int rows = getTableRows().size();
		int cells = getTableData().size();
		int columns = cells/rows;
		int entry = 0;
		try {
			for(int i=0; i<cells; i=i+columns) {
				if(getTableData().get(i).getText().contains(indexName)) {
					System.out.println("Available index name " + i+1 + ": " + getTableData().get(i).getText());
					entry++;
				}
			}
			System.out.println("Total no of index entries available in search result: " + entry);
		} catch (Exception e) {
			System.out.println("No entry with provided search result is available in system. Please provide different search criteria!");
			e.printStackTrace();
		}
		return entry;
	}
	
	public int searchByCurrency(String currencyName) throws InterruptedException {
		getFilterByCurrency().sendKeys(currencyName);
		int rows = getTableRows().size();
		int cells = getTableData().size();
		int columns = cells/rows;
		int entry = 0;
		try {
			for(int i=1; i<cells; i=i+columns) {
				if(getTableData().get(i).getText().contains(currencyName)) {
					System.out.println("Available currency name " + i + ": " + getTableData().get(i).getText());
					entry++;
				}
			}
			System.out.println("Total no of index entries available in search result: " + entry);
		} catch (Exception e) {
			System.out.println("No entry with provided search result is available in system. Please provide different search criteria!");
			e.printStackTrace();
		}
		return entry;
	}
	
	public int searchByCurrencyAndIndex(String indexName, String currencyName) throws InterruptedException {
		getFilterByIndex().sendKeys(indexName);
		getFilterByCurrency().sendKeys(currencyName);
		int rows = getTableRows().size();
		int cells = getTableData().size();
		int columns = cells/rows;
		int entry = 0;
		try {
			for(int i=0; i<cells; i=i+columns) {
				if(getTableData().get(i).getText().contains(indexName) && getTableData().get(i+1).getText().contains(currencyName)) {
					System.out.println("Available index name " + i+1 + ": " + getTableData().get(i).getText() + " with currency: " + getTableData().get(i+1).getText());
					entry++;
				}
			}
			System.out.println("Total no of index entries available in search result: " + entry);
		} catch (Exception e) {
			System.out.println("No entry with provided search result is available in system. Please provide different search criteria!");
			e.printStackTrace();
		}
		return entry;
	}
}
