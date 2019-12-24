package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends Pagebase{

	public EmailPage(WebDriver driver) {
		super(driver);
	}


	@FindBy (id = "FriendEmail")
	WebElement emailFriendTxt;


	@FindBy (id = "PersonalMessage")
	WebElement personalMessageTxt;

	@FindBy (name ="send-email")
	WebElement sendEmailBtn;

	@FindBy (css = "div.result")
	public WebElement messageNotificaiton;


	public void SendEmailToFriend(String FriendEmail , String PersonalMessage) {
		SetTextElemnetintext(emailFriendTxt, FriendEmail);
		SetTextElemnetintext(personalMessageTxt, PersonalMessage);
		ClickButton(sendEmailBtn);
	}

}
