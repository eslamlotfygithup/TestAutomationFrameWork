package tests;


import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTestWithJavafakerfile extends Testbase{
	
	HomePage homepageobject;
	UserRegisterationPage userRegisterobject;
	LoginPage loginobject;


	Faker fakeData = new Faker();
	String firstname = fakeData.name().firstName();
	String lastname = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String password = fakeData.number().digits(8).toString();



	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccssfully() throws CsvValidationException, IOException 
	{

		homepageobject = new HomePage(driver);
		homepageobject.openRegisterPage();
		userRegisterobject = new UserRegisterationPage(driver);
		userRegisterobject.userRegisteration(firstname, lastname, email, password);
		Assert.assertTrue(userRegisterobject.successmessage.getText().contains("Your registration completed"));		
		userRegisterobject.userLogout();
		homepageobject.openLoginpage();
		loginobject = new LoginPage(driver);
		loginobject.userLogin(email, password);
		Assert.assertTrue(userRegisterobject.LogoutLink.getText().contains("Log out"));
		userRegisterobject.userLogout();

	}
} 