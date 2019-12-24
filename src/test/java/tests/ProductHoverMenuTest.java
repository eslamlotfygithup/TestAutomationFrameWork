package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends Testbase {

	HomePage homeObject;

	@Test
	public void UserCanHoverToMenu() {

		homeObject = new HomePage(driver);
		homeObject.selectNotebooksMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));

	}

}
