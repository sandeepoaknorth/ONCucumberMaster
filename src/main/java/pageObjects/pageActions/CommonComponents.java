package pageObjects.pageActions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class CommonComponents extends pageObjects.pageObject.CommonComponents {

	/**********************************************************************************
	 ** CALENDAR HANDLING
	 **********************************************************************************/
	public void selectDate() {

		scriptClick(getToday());

	}

	/**********************************************************************************/
	/**********************************************************************************/

	/**********************************************************************************
	 ** PASSING DATE MANUALLY
	 **********************************************************************************/
	public String selectDate(String PastFuture) throws ParseException {
		LocalDate timestamp = LocalDate.now();
		Integer randomDays = (int) (365 * Math.random());
		LocalDate randomDate = null;
		String randomDate1;
		SimpleDateFormat format2;
		Date daate = null;
		if (PastFuture.equalsIgnoreCase("Past")) {
			randomDate = timestamp.minusDays(randomDays);
		} else if (PastFuture.equalsIgnoreCase("Future")) {
			randomDate = timestamp.plusDays(randomDays);
		}
		randomDate1 = randomDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		format2 = new SimpleDateFormat("dd-M-yyyy");
		daate = format2.parse(randomDate1);
		if (daate.toString().contains("Sun") || daate.toString().contains("Sat")) {
			randomDate1 = selectDate(PastFuture);
		}
		return randomDate1;
	}

	public String selectFirstofthemonth(WebElement element) throws StaleElementReferenceException {
		String selecteddate = "";
		int flag = 0;
		List<WebElement> rows = element.findElements(By.tagName("tr"));
		for (int rnum = 0; rnum < rows.size(); rnum++) {
			List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
			for (int cnum = 0; cnum < columns.size(); cnum++) {
				String yeartext = columns.get(cnum).getText();
				if (yeartext.equals("1")) {
					selecteddate = columns.get(cnum).getText();
					columns.get(cnum).click();
					flag = 1;
					break;
				} else {
					System.out.println("selectFirstofthemonth() method is failing!");
				}
			}
			if (flag == 1)
				break;
		}
		return selecteddate;
	}

	/**********************************************************************************/
	/**********************************************************************************/

	/**********************************************************************************
	 ** UNIVERSAL DROP DOWN HANDLING
	 **********************************************************************************/
	public void checkDropDown(String propertyName) {
		for (int i = 0; i < getDropDown().size(); i++) {
			assertString(getDropDown().get(i), prop.getProperty(propertyName + (i + 1)));
		}
	}

	public void selectDropDown(String dropDownElementName) throws InterruptedException {
		try {
//			Thread.sleep(1000);
			for (int i = 0; i < getDropDown().size(); i++) {
				if (getDropDown().get(i).getText().contains(dropDownElementName)) {
					scriptClick(getDropDown().get(i));
					break;
				}
			}
		} catch (StaleElementReferenceException e) {
//			Thread.sleep(1000);
			selectDropDown(dropDownElementName);
		}
	}

	/**********************************************************************************/
	/**********************************************************************************/

	/**********************************************************************************
	 ** ERROR MESSAGE STACK
	 **********************************************************************************/
	public void validateErrorMessage(String propertyName) {
		try {
			if (getErrorMessage().getText().equalsIgnoreCase(prop.getProperty(propertyName))) {
				System.out.println(getErrorMessage().getText());
//				Reporter.addStepLog("Actual error message matches expected!");
			}
		} catch (Exception e) {
			System.out.println(getErrorMessage().getText());
//			Reporter.addStepLog("Actual error message does not match expected!");
		}

	}

	public void validateNotificErrorMessage(String propertyName) {
		try {
			if (getNotificErrorMessage().getText().equalsIgnoreCase(prop.getProperty(propertyName))) {
				System.out.println(getNotificErrorMessage().getText());
//				Reporter.addStepLog("Actual error message matches expected!");
			}
		} catch (Exception e) {
			System.out.println(getNotificErrorMessage().getText());
//			Reporter.addStepLog("Actual error message does not match expected!");
		}

	}

	/**********************************************************************************/
	/**********************************************************************************/

	/**********************************************************************************
	 ** TABLE HANDLING
	 * 
	 * @throws InterruptedException
	 **********************************************************************************/

	// Validate an entry in table (Any row, Any Column)
	// Method will search if the provided parameters are present in a single row
	// Need enhancement to search for entries in any column of a particular row. Use
	// a map to insert all keys and search for remaining keys once a baseString is
	// found.
	public void validateTableEntry(String baseString, String validationString1, String validationString2)
			throws InterruptedException {
//		Thread.sleep(1000);
		indexRatePage.jsPageScrollIntoView(getPaginationNext());
		int totalRows = Integer.parseInt(getPaginationTotalRows().getText());
		int rowsPerPage = Integer.parseInt(getPaginationRowsPerPage().getText());
		int page = totalRows / rowsPerPage;
		boolean flag = false;
		for (int j = 0; j <= page; j++) {
			int rows = getTableRows().size();
			for (int i = 0; i < rows; i++) {
				List<WebElement> rowElement = getTableRows().get(i).findElements(By.tagName("td"));
				if (rowElement.get(1).findElement(By.tagName("div")).getText().toLowerCase()
						.contains(validationString1.toLowerCase())
						&& (rowElement.get(2).findElement(By.tagName("div")).getText().toLowerCase().toLowerCase()
								.contains(validationString2.toLowerCase()))) {
					System.out.println("Entry found in row: " + (i + 1) + " of page: " + j + 1);
					flag = true;
					break;
				}
			}
			if (flag == true) {
				break;
			}
			if (j < page) {
				indexRatePage.jsPageScrollIntoView(getPaginationNext());
				indexRatePage.scriptClick(getPaginationNext());
				Thread.sleep(1000);
			}
		}
		if (flag != true) {
			Assert.fail("Entry not available in table!");
		}
	}
	
	public void clickOnMatTableElement(String baseString, List<WebElement> key, List<WebElement> clickCell) {
		for(int i=0; i<key.size(); i++) {
			if(baseString.equalsIgnoreCase(key.get(i).getText())) {
				clickCell.get(i).click();
				break;
			}
		}
	}
	
	public void clickOnTableElement(List<WebElement> tableData, String baseString, int nextClickCell) throws InterruptedException {
		for(int i=0; i<tableData.size(); i++) {
			if(tableData.get(i).getText().contains(baseString)) {
				tableData.get(i+nextClickCell).click();
				break;
			}
		}
	}
	
	public void clickOnTableElement(String baseString) throws InterruptedException {
		for(int i=0; i<getTableData().size(); i++) {
			if(baseString.equalsIgnoreCase(getTableData().get(i).getText())) {
				getTableData().get(i).click();
				break;
			}
		}
	}
}
