package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.Searchpage;

public class AddProductTocompateTest extends Testbase {

	String firstproductName = "Apple MacBook Pro 13-inch";
	String secoundproductName = "Asus N551JK-XO076H Laptop";

	Searchpage searchpageObject;
	ProductDetailsPage detailsObject;
	HomePage homepageOgject;
	ComparePage compareObject;

	
	
	@Test(priority = 1)
	public void UserCanCompareToproducts() throws InterruptedException {
		searchpageObject = new Searchpage(driver);
		detailsObject = new ProductDetailsPage(driver);
		homepageOgject = new HomePage(driver);
		compareObject = new ComparePage(driver);

		searchpageObject.SearchForprodcutUsingAutoSuggest("Asus");
		assertEquals(detailsObject.productNamebreadCrumb.getText(), secoundproductName);
		detailsObject.AddProductToCompareList();

		Thread.sleep(3000);
		searchpageObject.SearchForprodcutUsingAutoSuggest("MacB");
		assertEquals(detailsObject.productNamebreadCrumb.getText(), firstproductName);
		detailsObject.AddProductToCompareList();

		Thread.sleep(3000);
		driver.navigate().to("https://demo.nopcommerce.com" + "/compareproducts");
		assertTrue(compareObject.firstProduct.isDisplayed());
		assertTrue(compareObject.secoundProduct.isDisplayed());
	  	//compareObject.compareProducts();
	}

	
	
	@Test(dependsOnMethods = { "UserCanCompareToproducts" })
	public void UserCanClearCompareList() {
		compareObject.clearCompareList();
		assertTrue(compareObject.noDataLab1.getText().contains("You have no items to compare."));
	
	}
	

}
