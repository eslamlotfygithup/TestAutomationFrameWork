package tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.Searchpage;
import pages.UserRegisterationPage;

public class AddproductReviewTest extends Testbase {

	/*
	 * user regerisrt seachforproduct addreview logout
	 */

	HomePage homepageobject;
	UserRegisterationPage userRegisterobject;
	LoginPage loginobject;

	String oldpassword = "1234567890";
	String firstname = "Islam";
	String lastname = "Lotfy";
	String emial = genRand() + "@yahoo.com";
	String productName = "Apple MacBook Pro 13-inch";
	Searchpage searchpageObject;
	ProductDetailsPage detailsObject;

	ProductReviewPage reviewObject;

	// 1- user Registration
	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccssfully() {
		homepageobject = new HomePage(driver);
		homepageobject.openRegisterPage();
		userRegisterobject = new UserRegisterationPage(driver);
		userRegisterobject.userRegisteration(firstname, lastname, emial, oldpassword);
		Assert.assertTrue(userRegisterobject.successmessage.getText().contains("Your registration completed"));
	}

	// 2-search for product
	@Test(priority = 2)
	public void UserCanSearchByAutoSuggest() {
		try {
			searchpageObject = new Searchpage(driver);
			searchpageObject.SearchForprodcutUsingAutoSuggest("mac");
			detailsObject = new ProductDetailsPage(driver);
			assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
		  } catch (Exception e) {
			System.out.println("Error... " + e.getMessage());
		}
	}

	// 3- user can add review
	@Test(priority = 3)
	public void RegisterUseAddReviewToProduct() {
		detailsObject.OpenAddReviewPage();
		reviewObject = new ProductReviewPage(driver);
		reviewObject.AddProductReview("New Review", "It's Very good product !");
		Assert.assertTrue(reviewObject.reviewNotification.getText().contains("Product review is successfully added"));
	}

	// 4- user logout
	@Test(priority = 4, dependsOnMethods = { "UserCanRegisterSuccssfully" })
	public void UseRegisterCanLogout() {
		userRegisterobject.userLogout();
	}

}