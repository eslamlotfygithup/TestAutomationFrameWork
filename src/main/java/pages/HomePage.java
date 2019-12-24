package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends Pagebase {

	public HomePage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}

	@FindBy(xpath ="/html/body/div[6]/div[2]/ul[1]/li[1]/a")
	WebElement computerMenu;

	@FindBy(linkText = "Notebooks")
	WebElement NotebooksMenu;

	@FindBy(linkText = "Register")
	WebElement RegisterLink;

	@FindBy(linkText = "Log in")
	public WebElement LoginLink;

	@FindBy(linkText = "Contact us")
	public WebElement ContactUsLink;

	@FindBy(id = "customerCurrency")
	WebElement currencydroplist;

	public void openRegisterPage() {
		ClickButton(RegisterLink);
	}

	public void openLoginpage() {

		ClickButton(LoginLink);

	}

	public void openContactUSPage() {

		ScrollToButtom();
		ClickButton(ContactUsLink);
	}

	public void changecurrency() {

		select = new Select(currencydroplist);
		select.selectByVisibleText("Euro");
	}

	// new
	public void changedropdownbyname(String name) {

		changeDropDownList(currencydroplist, name);
	}

	public void selectNotebooksMenu() {

		action.moveToElement(computerMenu)
		.moveToElement(NotebooksMenu)
		.click()
		.build()
		.perform();
	}

}
