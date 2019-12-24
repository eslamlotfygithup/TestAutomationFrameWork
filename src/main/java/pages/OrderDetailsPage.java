package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends Pagebase {

	public OrderDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "a.button-2.print-order-button")
	public WebElement printInvoicLink;
 
	@FindBy(css = "a.button-2.pdf-invoice-button")
	public WebElement pdfInvoicLink;

	public void PrintOrderDetails() {
		ClickButton(printInvoicLink);
	}

	public void DownloadPdfOrderDetails() throws InterruptedException {
		ClickButton(pdfInvoicLink);
		Thread.sleep(1000);
	}

}
