package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CheckoutPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.Searchpage;
import pages.ShopingCartPage;
import tests.Testbase;

public class E2ETests extends Testbase {

	Searchpage searchpageObject;
	ProductDetailsPage detailsObject;
	ShopingCartPage shopcartObject;

	@Given("^user is on Home page$")
	public void user_is_on_Home_page() throws Throwable {
		assertTrue(driver.getCurrentUrl().contains("demo.nopcommerce.com"));
	}

	@When("^he can search for \"([^\"]*)\"$")
	public void he_can_search_for(String product) throws Throwable {
		searchpageObject = new Searchpage(driver);
		searchpageObject.SearchForprodcutUsingAutoSuggest(product);
		detailsObject = new ProductDetailsPage(driver);
		assertEquals(detailsObject.productNamebreadCrumb.getText(), product);
	}

	@When("^choose to buy Two items$")
	public void choose_to_buy_Two_items() throws Throwable {
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddProductToShopingCart();
		Thread.sleep(2000);
		driver.navigate().to("https://demo.nopcommerce.com" + "/cart");
	}

	CheckoutPage checkoutObject;
	OrderDetailsPage orderObjct;
	String productName = "Apple MacBook Pro 13-inch";

	@When("^move to checkout cart and enter personal details on checkout page and place order$")
	public void move_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_order() throws Throwable {
		checkoutObject = new CheckoutPage(driver);
		shopcartObject = new ShopingCartPage(driver);
		shopcartObject.OpenCheckOutPage();
		shopcartObject.OpenCheckOutPageAsGuest();

		checkoutObject.RegesisterCanCheckOutProduct("test010", "test010", "test010@test.com", "Egypt", "Test address",
				"Cairo", "123456", "0123456789", productName);
		Assert.assertTrue(checkoutObject.productNameTxt.isDisplayed());
		Assert.assertTrue(checkoutObject.productNameTxt.getText().contains(productName));
		checkoutObject.ConfirmOrder();
		Assert.assertTrue(checkoutObject.thankyouLab1.isDisplayed());
	}

	@Then("^he can view order and download the invoice$")
	public void he_can_view_order_and_download_the_invoice() throws Throwable {
		checkoutObject.VieworderDetails();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObjct = new OrderDetailsPage(driver);
		orderObjct.DownloadPdfOrderDetails();
		Thread.sleep(2000);
		orderObjct.PrintOrderDetails();

	}

}
