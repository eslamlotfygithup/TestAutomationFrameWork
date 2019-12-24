package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.Searchpage;
import pages.ShopingCartPage;

public class AddProductToShopingCartTest extends Testbase {

	String productName = "Asus N551JK-XO076H Laptop";
	Searchpage searchpageObject;
	ProductDetailsPage detailsObject;
	ShopingCartPage shopcartObject;

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

	@Test(priority = 2)
	public void UserCanAddProductToShopingCart() throws InterruptedException {
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddProductToShopingCart();
		Thread.sleep(2000);
		driver.navigate().to("https://demo.nopcommerce.com" + "/cart");
		shopcartObject = new ShopingCartPage(driver);
		assertTrue(shopcartObject.totalLb1.getText().contains("1,500"));
	}

	@Test(priority = 3)
	public void UserCanUpdateProductFromShopingCart() {
		shopcartObject = new ShopingCartPage(driver);
		shopcartObject.UpdateProductQuantityInCart("3");
	}

	@Test(priority = 4)
	public void UserRemoveProductFromShopingCart() {
		shopcartObject = new ShopingCartPage(driver);
		shopcartObject.RemoveProductFromCart();
		assertTrue(shopcartObject.noDataLab1.getText().contains("Your Shopping Cart is empty!"));

	}

}
