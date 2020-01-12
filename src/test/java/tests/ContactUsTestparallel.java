package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTestparallel extends Testbase2{

	HomePage homeobject;
	ContactUsPage  contactusobject;

	String fullName="test@test.com";
	String email="test@test.com";
	String enquiry="test@test.com";

	@Test
	public void UserCanContactUS() {

		homeobject = new HomePage(getDriver());
		homeobject.openContactUSPage();
		
		contactusobject = new ContactUsPage(getDriver());
		contactusobject.ContactUs(fullName, email, enquiry);	
		assertTrue(contactusobject.successMessage.getText()
				.contains("Your enquiry has been successfully sent to the store owner."));
	}

}
