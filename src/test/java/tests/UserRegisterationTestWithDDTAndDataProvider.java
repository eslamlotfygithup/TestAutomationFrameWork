package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTestWithDDTAndDataProvider extends Testbase {

	HomePage homepageobject;
	UserRegisterationPage userRegisterobject;
	LoginPage loginobject;

	
	@DataProvider(name = "testData")
	public static Object[][] userData()
	{
		return new Object[][] 
			{ 
			    { "Eslam1" , "Lotfy1" ,   "eslam111@test0111.com"  , "123466"},
				{ "ahmed1" , "ahmed1" ,   "ahmed111@test0121.com" , "123456"}
			};
	}

	@Test(priority = 1, alwaysRun = true, dataProvider = "testData")
	public void UserCanRegisterSuccssfully(String firstname, String lastname, String email, String oldpassword) 
	{
		homepageobject = new HomePage(driver);
		homepageobject.openRegisterPage();
		userRegisterobject = new UserRegisterationPage(driver);
		userRegisterobject.userRegisteration(firstname, lastname, email, oldpassword);
		Assert.assertTrue(userRegisterobject.successmessage.getText().contains("Your registration completed"));		
		userRegisterobject.userLogout();
		homepageobject.openLoginpage();
		loginobject = new LoginPage(driver);
		loginobject.userLogin(email, oldpassword);
 		Assert.assertTrue(userRegisterobject.LogoutLink.getText().contains("Log out"));
		userRegisterobject.userLogout();
	}

}