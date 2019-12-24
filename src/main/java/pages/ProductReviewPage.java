package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends Pagebase {

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "AddProductReview_Title")
	WebElement reviewTitleTxt;

	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewTxt;

	@FindBy(id = "addproductrating_4")
	WebElement ratingRadioBtn;

	@FindBy(name = "add-review")
	WebElement submitReviewBtn;

	@FindBy(css = "div.result")
	public WebElement reviewNotification;

	public void AddProductReview(String reviewTitle, String reviewMessage) {
		SetTextElemnetintext(reviewTitleTxt, reviewTitle);
		SetTextElemnetintext(reviewTxt, reviewMessage);
		ClickButton(ratingRadioBtn);
		ClickButton(submitReviewBtn);
	}

}
