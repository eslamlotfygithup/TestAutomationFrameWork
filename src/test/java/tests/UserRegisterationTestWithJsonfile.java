package tests;


import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTestWithJsonfile extends Testbase{


	HomePage homepageobject;
	UserRegisterationPage userRegisterobject;
	LoginPage loginobject;


	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccssfully() throws CsvValidationException, IOException, ParseException 
	{

		JsonDataReader json =  new JsonDataReader();
		json.jsonreader();
				
		homepageobject = new HomePage(driver);
		homepageobject.openRegisterPage();
		userRegisterobject = new UserRegisterationPage(driver);
		userRegisterobject.userRegisteration(json.firstname, json.lastname, json.email, json.password);
		Assert.assertTrue(userRegisterobject.successmessage.getText().contains("Your registration completed"));		
		userRegisterobject.userLogout();
		homepageobject.openLoginpage();
		loginobject = new LoginPage(driver);
		loginobject.userLogin(json.email, json.password);
		Assert.assertTrue(userRegisterobject.LogoutLink.getText().contains("Log out"));
		userRegisterobject.userLogout();
	}
 }
