package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.Searchpage;

public class SearchProductUsingAutocompleteTest extends Testbase{



	String productName="Apple MacBook Pro 13-inch";
	Searchpage searchpageObject;	
	ProductDetailsPage detailsObject;


	@Test
	public void UserCanSearchByAutoSuggest() {
		try {
		searchpageObject = new Searchpage(driver);
		searchpageObject.SearchForprodcutUsingAutoSuggest("mac");
		detailsObject= new ProductDetailsPage(driver);
		assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
		}catch (Exception e) {
			System.out.println("Error... "+e.getMessage());

		}
		
	}






}
