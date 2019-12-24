package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.Searchpage;

public class ChangeCurrenyTest extends Testbase{


	HomePage homepageobje;
	ProductDetailsPage detailsObject;
	String productName="Apple MacBook Pro 13-inch";
	Searchpage searchpageObject;	



	@Test(priority = 1)
	public void UserCanChangeCurrerny() {

		homepageobje = new HomePage(driver);
		//homepageobje.changedropdownbyname("Euro");
		homepageobje.changecurrency();
	}


	@Test(priority = 2)
	public void UserCanSearchByAutoSuggest() {
		try {
			searchpageObject = new Searchpage(driver);
			searchpageObject.SearchForprodcutUsingAutoSuggest("mac");
			detailsObject= new ProductDetailsPage(driver);
			assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
			assertTrue(detailsObject.productpriceLable.getText().contains("Ђ"));
			System.out.println(detailsObject.productpriceLable.getText());
		}catch (Exception e) {
			System.out.println("Error... "+e.getMessage());
		}
	}


}