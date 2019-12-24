package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends Pagebase{

	public UserRegisterationPage(WebDriver driver) {
		super(driver);

	}


	@FindBy(id = "gender-male")
	WebElement genderRadio ;

	@FindBy(id = "FirstName")
	WebElement firstnametxt;

	@FindBy (id = "LastName")
	WebElement lastNametxt;

	@FindBy (id = "Email")
	WebElement emailtxt;

	@FindBy(id="Password")
	WebElement passwordtxt;

	@FindBy(id="ConfirmPassword")
	WebElement conpasswordtxt;

	@FindBy(id = "register-button")
	WebElement registerbutton;

	@FindBy(css = "div.result")
	public WebElement  successmessage ;

	@FindBy (css = "a.ico-logout")
	public	WebElement LogoutLink;

	@FindBy (linkText = "My account")
	WebElement myaccountLink;

	public void userRegisteration(String FirstName, String LastName, String Email,String Password) {

		ClickButton(genderRadio);

		SetTextElemnetintext(firstnametxt,FirstName);
		SetTextElemnetintext(lastNametxt, LastName);
		SetTextElemnetintext(emailtxt, Email);
		SetTextElemnetintext(passwordtxt, Password);
		SetTextElemnetintext(conpasswordtxt, Password);

		ClickButton(registerbutton);

	}


	public void userLogout() {

		ClickButton(LogoutLink);
	}




	public void openMyaccountpage() {
	
		ClickButton(myaccountLink);

	}


}
