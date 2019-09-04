package pageObjects.pageObject;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

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
