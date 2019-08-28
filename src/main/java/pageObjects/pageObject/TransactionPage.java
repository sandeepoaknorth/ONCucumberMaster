package pageObjects.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

import java.util.ArrayList;
import java.util.List;

public class TransactionPage extends BasePage {
	@FindBy(xpath = "//mat-cell[contains(@class, 'eventType')]/span")
	private List<WebElement> eventType;
	
	public List<WebElement> getEventType() {
		return visibilityOf(eventType);
	}
	
	@FindBy(xpath = "//mat-icon[contains(text(), 'undo')]")
	private WebElement undoButton;
	
	public WebElement getUndoButton() {
		return visibilityOf(undoButton);
	}
	
	@FindBy(xpath = "//div/input")
	private WebElement comments;
	
	public WebElement getComments() {
		return visibilityOf(comments);
	}
	
	@FindBy(xpath = "//span[contains(text(),'Transaction')]")
	private WebElement transaction;
	
	public WebElement getTransaction() {
		return clickabilityOf(transaction);
	}
	
	@FindBy(xpath = "//mat-icon[contains(text(),'redo')]")
	private WebElement redoButton;
	
	public WebElement getRedoButton() {
		return clickabilityOf(redoButton);
	}
}
