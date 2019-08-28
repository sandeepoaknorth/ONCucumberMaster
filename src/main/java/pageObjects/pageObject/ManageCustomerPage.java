package pageObjects.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

import java.util.ArrayList;
import java.util.List;

public class ManageCustomerPage extends BasePage {
	@FindBy(xpath = "//mat-cell[contains(@class, 'eventType')]")
	private List<WebElement> eventType;
	
	public List<WebElement> getEventType() {
		return visibilityOf(eventType);
	}
	
	@FindBy(xpath = "//mat-icon[contains(text(), 'undo')]")
	private List<WebElement> undoButton;
	
	public List<WebElement> getUndoButton() {
		return visibilityOf(undoButton);
	}
}
