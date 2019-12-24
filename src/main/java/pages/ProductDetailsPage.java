package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends Pagebase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "add-to-cart-button-4")
	public WebElement addToShopingCartBtn;

	@FindBy(css = "input.button-2.add-to-compare-list-button")
	public WebElement addToCompareBtn;

	@FindBy(id = "add-to-wishlist-button-6")
	public WebElement addToWishListbtn;

	@FindBy(linkText = "Add your review")
	public WebElement addReviewLink;

	@FindBy(css = "strong.current-item")
	public WebElement productNamebreadCrumb;

	@FindBy(css = "input.button-2.email-a-friend-button")
	public WebElement emailFreiendBtn;

	@FindBy(css = "span.price-value-4")
	public WebElement productpriceLable;

	public void OpenSendEmailPage() {
		ScrollToElement(emailFreiendBtn);
		ClickButton(emailFreiendBtn);

	}

	public void OpenAddReviewPage() {
		ScrollToElement(addReviewLink);
		ClickButton(addReviewLink);
	}

	public void AddProductWishListPage() {
		ScrollToElement(addToWishListbtn);
		ClickButton(addToWishListbtn);

	}

	public void AddProductToCompareList() {

		ScrollToElement(addToCompareBtn);
		ClickButton(addToCompareBtn);
	}

	public void AddProductToShopingCart() {
		//ScrollToElement(addToShopingCartBtn);
		ClickButton(addToShopingCartBtn);
	}

	/*
	 * public void gotoproductpriceLable() { ScrollToElement(productpriceLable); }
	 */

}
