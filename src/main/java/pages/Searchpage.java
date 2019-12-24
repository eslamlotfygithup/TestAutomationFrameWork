package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Searchpage extends Pagebase{

	public Searchpage(WebDriver driver) {
		super(driver);
	}


	@FindBy (id = "small-searchterms")
	WebElement searchTextBox;


	@FindBy (css = "input.button-1.search-box-button")
	WebElement searchBtn;

	@FindBy (id = "ui-id-1")
	List<WebElement> productList;


	@FindBy (linkText ="Apple MacBook Pro 13-inch")
	WebElement productTitle;



	public void SearchForprodcut(String productName) {

		SetTextElemnetintext(searchTextBox, productName);
		ClickButton(searchBtn);
	}


	public void OpenProductDetailsPage() {

		ClickButton(productTitle);
	}


	public void SearchForprodcutUsingAutoSuggest(String searchTxt) {

		SetTextElemnetintext(searchTextBox, searchTxt);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Error... "+e.getMessage());
		}
		productList.get(0).click();
		

	}



	




}
