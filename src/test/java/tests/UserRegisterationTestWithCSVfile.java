package tests;


import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTestWithCSVfile extends Testbase{


	HomePage homepageobject;
	UserRegisterationPage userRegisterobject;
	LoginPage loginobject;


	CSVReader reader;




	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccssfully() throws CsvValidationException, IOException 
	{

		String pathcsv= System.getProperty("user.dir")+"\\src\\test\\java\\data\\userData.csv";
		reader = new CSVReader(new FileReader(pathcsv));

		String []csvCell;
		while ((csvCell = reader.readNext())!= null) 
		{
			String firstname	= csvCell[0];
			String lastname	= csvCell[1];
			String email	= csvCell[2];
			String oldpassword	= csvCell[3];

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
} 