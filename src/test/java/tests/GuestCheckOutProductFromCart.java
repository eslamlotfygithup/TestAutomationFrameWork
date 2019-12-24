package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.Searchpage;
import pages.ShopingCartPage;
import pages.UserRegisterationPage;

public class GuestCheckOutProductFromCart extends Testbase{

	
	
	HomePage homepageobject;
	UserRegisterationPage userRegisterobject;
	LoginPage loginobject;

	String oldpassword = "1234567890";
	String firstname = "Islam";
	String lastname = "Lotfy";
	String emial = genRand() + "@yahoo.com";

	String productName = "Asus N551JK-XO076H Laptop";
	Searchpage searchpageObject;
	ProductDetailsPage detailsObject;


	@Test(priority = 1)
	public void UserCanSearchByAutoSuggest() {
		try {
			searchpageObject = new Searchpage(driver);
			searchpageObject.SearchForprodcutUsingAutoSuggest("Asus");
			detailsObject = new ProductDetailsPage(driver);
			assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
		} catch (Exception e) {
			System.out.println("Error... " + e.getMessage());

		}
	}

	ShopingCartPage shopcartObject;

	@Test(priority = 2)
	public void UserCanAddProductToShopingCart() throws InterruptedException {
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddProductToShopingCart();
		Thread.sleep(2000);
		driver.navigate().to("https://demo.nopcommerce.com" + "/cart");
		shopcartObject = new ShopingCartPage(driver);
		assertTrue(shopcartObject.totalLb1.getText().contains("1,500"));
	}

	CheckoutPage checkoutObject;
	OrderDetailsPage orderObjct;
	
	@Test(priority = 3)
	public void UserCanCheckOutProfduct() throws InterruptedException {
		checkoutObject = new CheckoutPage(driver);
		shopcartObject.OpenCheckOutPage();
		shopcartObject.OpenCheckOutPageAsGuest();
		
		
		checkoutObject.RegesisterCanCheckOutProduct(firstname,lastname,emial,
				"Egypt", "Test address", "Cairo", "123456", "0123456789",productName);
		Assert.assertTrue(checkoutObject.productNameTxt.isDisplayed());
		Assert.assertTrue(checkoutObject.productNameTxt.getText().contains(productName));
		checkoutObject.ConfirmOrder();
		Assert.assertTrue(checkoutObject.thankyouLab1.isDisplayed());

	}

	
	@Test(priority = 4)
	public void UsCanViewOrderDetails() throws InterruptedException {
		checkoutObject.VieworderDetails();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));      
		orderObjct = new OrderDetailsPage(driver);
		orderObjct.DownloadPdfOrderDetails();
		Thread.sleep(2000);
		orderObjct.PrintOrderDetails();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
