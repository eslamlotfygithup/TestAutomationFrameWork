package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.Searchpage;

public class SearchproductTest extends Testbase{

	String productName="Apple MacBook Pro 13-inch";
	Searchpage searchpageObject;	
	ProductDetailsPage detailsObject;



	@Test
	public void UserCanSearchProducts() {

		searchpageObject = new Searchpage(driver);
		detailsObject = new ProductDetailsPage(driver);	
		searchpageObject.SearchForprodcut(productName);
		searchpageObject.OpenProductDetailsPage();
		assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
		assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));

	}
}
