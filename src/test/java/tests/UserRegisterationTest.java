package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTest extends Testbase{


	HomePage homepageobject;
	UserRegisterationPage  userRegisterobject;
	LoginPage loginobject;

	String oldpassword= "1234567890";
	String firstname="Islam";
	String lastname="Lotfy";
	String emial=genRand()+"@yahoo.com";

	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccssfully(){

		homepageobject = new HomePage(driver);
		homepageobject.openRegisterPage();
		userRegisterobject = new UserRegisterationPage(driver);
		userRegisterobject.userRegisteration(firstname, lastname, emial, oldpassword);

		Assert.assertTrue(userRegisterobject.successmessage.getText().contains("Your registration completed"));		
	}

	
	@Test(dependsOnMethods = {"UserCanRegisterSuccssfully"})
	public void  UseRegisterCanLogout() {

		userRegisterobject.userLogout();

	}



	@Test(dependsOnMethods = {"UseRegisterCanLogout"})
	public void UserCanLoginSuccssfully() {

		homepageobject.openLoginpage();
		loginobject = new LoginPage(driver);
		loginobject.userLogin(emial, oldpassword);
		Assert.assertTrue(userRegisterobject.LogoutLink.getText().contains("Log out"));	
	}





} 