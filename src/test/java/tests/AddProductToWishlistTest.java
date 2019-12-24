package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.Searchpage;
import pages.WishListPage;

public class AddProductToWishlistTest extends Testbase {

	String productName = "Samsung Series 9 NP900X4C Premium Ultrabook";
	Searchpage searchpageObject;
	ProductDetailsPage detailsObject;
	WishListPage wishlistObject;

	@Test(priority = 1)
	public void UserCanSearchByAutoSuggest() {
		searchpageObject = new Searchpage(driver);
		searchpageObject.SearchForprodcutUsingAutoSuggest("Samsung");
		detailsObject = new ProductDetailsPage(driver);
		assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
	}

	@Test(priority = 2)
	public void UserCanAddProductToWishList() {
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddProductWishListPage();

		driver.navigate().to("https://demo.nopcommerce.com/" + "/wishlist");
		wishlistObject = new WishListPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleContains("Wishlist"));

		assertTrue(wishlistObject.wishListHeader.isDisplayed());
		assertTrue(wishlistObject.productCell.getText().contains(productName));
	}

	@Test(priority = 3)
	public void UsrCanRemoveProductFormCart() {
		wishlistObject = new WishListPage(driver);
		wishlistObject.removeProductFromWishList();
		assertTrue(wishlistObject.empteCartLb1.getText().contains("The wishlist is empty!"));

	}

}
