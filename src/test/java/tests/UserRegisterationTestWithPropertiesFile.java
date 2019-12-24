package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTestWithPropertiesFile extends Testbase {

	HomePage homepageobject;
	UserRegisterationPage userRegisterobject;
	LoginPage loginobject;

	
	String fname= LoadProperties.userData.getProperty("firstname");
	String lastname= LoadProperties.userData.getProperty("lastname");
	String email= LoadProperties.userData.getProperty("email");
	String password= LoadProperties.userData.getProperty("password");

	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccssfully(){

		homepageobject = new HomePage(driver);
		homepageobject.openRegisterPage();
		userRegisterobject = new UserRegisterationPage(driver);
		userRegisterobject.userRegisteration(fname, lastname, email, password);

		Assert.assertTrue(userRegisterobject.successmessage.getText().contains("Your registration completed"));		
	}

	
	@Test(priority = 2)
	public void  UseRegisterCanLogout() {
		userRegisterobject.userLogout();
	}


	@Test(priority = 3)
	public void UserCanLoginSuccssfully() {
		homepageobject.openLoginpage();
		loginobject = new LoginPage(driver);
		loginobject.userLogin(email, password);
		Assert.assertTrue(userRegisterobject.LogoutLink.getText().contains("Log out"));	
	}
	

	
}