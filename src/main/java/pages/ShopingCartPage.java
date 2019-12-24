package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopingCartPage extends Pagebase {

	public ShopingCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "termsofservice")
	public WebElement agreetermsofserviceBtn;

	@FindBy(id = "checkout")
	public WebElement checkoutBtn;

	@FindBy(css = "div.no-data")
	public WebElement noDataLab1;
	// Your Shopping Cart is empty!

	@FindBy(name = "removefromcart")
	WebElement removeCheck;

	@FindBy(name = "updatecart")
	WebElement updatecartBtn;

	@FindBy(css = "input.qty-input")
	WebElement quantityTxt;

	@FindBy(css = "td.subtotal")
	public WebElement totalLb1;

	@FindBy(css = "input.button-1.checkout-as-guest-button")
	public WebElement checkoutasguestBtn;
	
	public void RemoveProductFromCart() {
		ClickButton(removeCheck);
		ClickButton(updatecartBtn);

	}

	public void UpdateProductQuantityInCart(String quantity) {
		ClearText(quantityTxt);
		SetTextElemnetintext(quantityTxt, quantity);
		ClickButton(updatecartBtn);
	}

	public void OpenCheckOutPage() {
		ScrollToElement(agreetermsofserviceBtn);
		ClickButton(agreetermsofserviceBtn);
		ScrollToElement(checkoutBtn);
		ClickButton(checkoutBtn);
	}
	
	public void OpenCheckOutPageAsGuest() {
		ScrollToElement(checkoutasguestBtn);
		ClickButton(checkoutasguestBtn);
	}
	
	

}
