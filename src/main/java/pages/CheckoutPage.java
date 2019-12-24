package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends Pagebase {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "BillingNewAddress_FirstName")
	public WebElement firstNameTxt;

	@FindBy(id = "BillingNewAddress_LastName")
	public WebElement lasttNameTxt;

	@FindBy(id = "BillingNewAddress_Email")
	public WebElement emailTxt;

	@FindBy(id = "BillingNewAddress_CountryId")
	public WebElement countryList;

	@FindBy(id = "BillingNewAddress_City")
	public WebElement cityTxt;

	@FindBy(id = "BillingNewAddress_Address1")
	public WebElement addressTxt;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	public WebElement zipostalcodeTxt;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	public WebElement phonenumberTxt;

	@FindBy(css = "input.button-1.new-address-next-step-button")
	public WebElement contineuBtn;

	@FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/input")
	public WebElement contineushippingBtn;

	@FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/input")
	public WebElement contineupaymentBtn;

	@FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/input")
	public WebElement contineuinfoBtn;

	@FindBy(css = "a.product-name")
	public WebElement productNameTxt;

	@FindBy(xpath = "//*[@id=\"confirm-order-buttons-container\"]/input")
	public WebElement confirmOrderBtn;

	@FindBy(css = "h1")
	public WebElement thankyouLab1;

	@FindBy(css = "div.title")
	public WebElement successMessage;

	@FindBy(linkText = "Click here for order details.")
	public WebElement orderDetailsLink;

	public void RegesisterCanCheckOutProduct(String country, String Address, String city, String PostalCode,
			String phonenumbre, String productName) throws InterruptedException {

		select = new Select(countryList);
		select.selectByVisibleText(country);

		SetTextElemnetintext(addressTxt, Address);
		SetTextElemnetintext(cityTxt, city);
		SetTextElemnetintext(zipostalcodeTxt, PostalCode);
		SetTextElemnetintext(phonenumberTxt, phonenumbre);
		ClickButton(contineuBtn);
		Thread.sleep(1000);
		ClickButton(contineushippingBtn);
		Thread.sleep(1000);
		ClickButton(contineupaymentBtn);
		Thread.sleep(1000);
		ClickButton(contineuinfoBtn);
	}
	
	public void RegesisterCanCheckOutProduct(String fname,String Lname,String Email,String country, String Address, String city, String PostalCode,
			String phonenumbre, String productName) throws InterruptedException {

		SetTextElemnetintext(firstNameTxt, fname);
		SetTextElemnetintext(lasttNameTxt, Lname);
		SetTextElemnetintext(emailTxt, Email);
		
		
		
		select = new Select(countryList);
		select.selectByVisibleText(country);

		
		SetTextElemnetintext(addressTxt, Address);
		SetTextElemnetintext(cityTxt, city);
		SetTextElemnetintext(zipostalcodeTxt, PostalCode);
		SetTextElemnetintext(phonenumberTxt, phonenumbre);
		ClickButton(contineuBtn);
		Thread.sleep(1000);
		ClickButton(contineushippingBtn);
		Thread.sleep(1000);
		ClickButton(contineupaymentBtn);
		Thread.sleep(1000);
		ClickButton(contineuinfoBtn);
	}

	// Assert.assertTrue(productNameTxt.isDisplayed());
	// Assert.assertTrue(productNameTxt.getText().contains(productName));

	public void ConfirmOrder() throws InterruptedException {
		Thread.sleep(1000);
		ClickButton(confirmOrderBtn);
	}

	public void VieworderDetails() {
		ClickButton(orderDetailsLink);
	}

	// Assert.assertTrue(thankyouLab1.isDisplayed());
	// Assert.assertTrue(successMessage.getText().contains("Your order has been
	// successfully processed!"));

}
