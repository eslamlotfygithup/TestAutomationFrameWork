package tests;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.Excelreader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTestWithExcelfile extends Testbase{


	HomePage homepageobject;
	UserRegisterationPage userRegisterobject;
	LoginPage loginobject;

	
	@DataProvider(name = "ExcelData")
	public static Object[][] userExcelData() throws IOException
	{
		Excelreader ER = new Excelreader();
		return ER.getExcelData();
	}

	@Test(priority = 1, alwaysRun = true, dataProvider = "ExcelData")
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