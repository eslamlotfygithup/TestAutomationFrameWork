package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends Pagebase {

	public WishListPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "removefromcart")
	public WebElement removefromCartCheck;

	@FindBy(css = "a.product-name")
	public WebElement productCell;

	@FindBy(css = "h1")
	public WebElement wishListHeader;

	@FindBy(name = "updatecart")
	public WebElement updateCartBtn;
	

	
	
	@FindBy(css = "div.no-data")
	public WebElement empteCartLb1;

	
	public void removeProductFromWishList() {
			ClickButton(removefromCartCheck);
			ClickButton(updateCartBtn);	
	}
	
	
	
	
}
