package pageObjects.pageActions;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.pageObject.Products_Page2;

public class Products_Page extends Products_Page2 {
	public Products_Page clickOnProceedButton_Popup() throws IOException, InterruptedException {
		click(button_Proceed_Popup);
		return new Products_Page();
	}

	public String printSpecialOffersVoucherCode() throws InterruptedException {
		click(voucherCode);
		String voucherCodeValue = voucherCode.getText();
		System.out.println("Voucher Code: " + voucherCode.getText());
		return voucherCodeValue;
	}
}
