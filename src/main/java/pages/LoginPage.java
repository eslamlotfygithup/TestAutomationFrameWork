package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Pagebase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}


	@FindBy (id = "Email")
	WebElement emailTxtbox;



	@FindBy (id = "Password")
	WebElement passwordtxtbox;


	@FindBy ( css = "input.button-1.login-button")
	WebElement Loginbutton;


	public void userLogin(String Email, String password) {


		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(emailTxtbox));	 
		SetTextElemnetintext(emailTxtbox, Email);

		wait.until(ExpectedConditions.elementToBeClickable(passwordtxtbox));	 
		SetTextElemnetintext(passwordtxtbox, password);

		ClickButton(Loginbutton);

	}



}
