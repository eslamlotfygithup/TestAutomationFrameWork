package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyaccountPage;
import pages.UserRegisterationPage;

public class MyAccountTest extends Testbase
{


	
	
	HomePage homepageobject;
	UserRegisterationPage  userRegisterobject;
	MyaccountPage myaccountobject;
	LoginPage loginobject;

	
	
	String oldpassword= "1234567890";
	String newPassword="123456";
	String firstname="Islam";
	String lastname="Lotfy";
	String emial=genRand()+"@yahoo.com";


	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccssfully() throws InterruptedException{

		homepageobject = new HomePage(driver);
		homepageobject.openRegisterPage();
		userRegisterobject = new UserRegisterationPage(driver);
		userRegisterobject.userRegisteration(firstname, lastname, emial, oldpassword);

		Assert.assertTrue(userRegisterobject.successmessage.getText().contains("Your registration completed"));		
	
	}



	@Test(dependsOnMethods = {"UserCanRegisterSuccssfully"})
	public void UserCanChangepasswordSuccssfully() {

		myaccountobject = new MyaccountPage(driver);
		userRegisterobject.openMyaccountpage();

		myaccountobject.openChangepasswordpage();
		myaccountobject.Changepassword(oldpassword, newPassword);
		Assert.assertTrue(myaccountobject.resultLbi.getText().contains("Password was changed"));

	}


	@Test(dependsOnMethods = {"UserCanChangepasswordSuccssfully"})
	public void  UseRegisterCanLogout() {

		userRegisterobject.userLogout();

	}

	@Test(dependsOnMethods = {"UseRegisterCanLogout"})
	public void UserCanLoginSuccssfully() {

		homepageobject.openLoginpage();
		loginobject = new LoginPage(driver);
		loginobject.userLogin(emial, newPassword);

		Assert.assertTrue(userRegisterobject.LogoutLink.getText().contains("Log out"));	

	}






}
