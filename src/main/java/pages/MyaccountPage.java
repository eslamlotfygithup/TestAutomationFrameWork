package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyaccountPage extends Pagebase{

	public MyaccountPage(WebDriver driver) {
		super(driver);
	}



	@FindBy (linkText = "Change password")
	WebElement changepasswordlink;


	@FindBy (id = "OldPassword")
	WebElement oldPasswordtxt;

	@FindBy (id = "NewPassword")
	WebElement newPasswordtxt;

	@FindBy (id = "ConfirmNewPassword")
	WebElement confirmNewPasswordtxt;


	@FindBy (xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/form/div[2]/input")
	WebElement ChangepasswordBtn;


	@FindBy (css = "div.result")
	public	WebElement resultLbi;


	public void openChangepasswordpage() {

		ClickButton(changepasswordlink);

	}


	public void Changepassword (String oldpassword , String newpassword) {

		SetTextElemnetintext(oldPasswordtxt, oldpassword);

		SetTextElemnetintext(newPasswordtxt, newpassword);

		SetTextElemnetintext(confirmNewPasswordtxt, newpassword);

		ClickButton(ChangepasswordBtn);	
	}


}
