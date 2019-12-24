package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.Searchpage;
import pages.UserRegisterationPage;

public class EmailFriendTest extends Testbase{



	HomePage homepageobject;
	UserRegisterationPage  userRegisterobject;
	LoginPage loginobject;

	String oldpassword= "1234567890";
	String firstname="Islam";
	String lastname="Lotfy";
	String emial=genRand()+"@yahoo.com";

	String productName="Apple MacBook Pro 13-inch";
	Searchpage searchpageObject;	
	ProductDetailsPage detailsObject;

	
	
	EmailPage emailPageObject;
	
	//1- user Registration
	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccssfully(){

		homepageobject = new HomePage(driver);
		homepageobject.openRegisterPage();
		userRegisterobject = new UserRegisterationPage(driver);
		userRegisterobject.userRegisteration(firstname, lastname, emial, oldpassword);

		Assert.assertTrue(userRegisterobject.successmessage.getText().contains("Your registration completed"));		
	}


	//2-search for product 
	@Test(priority = 2)
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


	//3- Friend Email
	@Test(priority = 3)
	public void RegisterUserCanSendEmailToFreiend() {
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.OpenSendEmailPage();
		
		
		emailPageObject = new EmailPage(driver);
		emailPageObject.SendEmailToFriend("myfriendemail@yahoo.com", "Hi ! My friend , check this product.");
		assertTrue(emailPageObject.messageNotificaiton.getText().contains("Your message has been sent"));
		
		
	}

	
	//4- user logout
	@Test(priority = 4,dependsOnMethods = {"UserCanRegisterSuccssfully"})
	public void  UseRegisterCanLogout() {
		userRegisterobject.userLogout();
	}


}
