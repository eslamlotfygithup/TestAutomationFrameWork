package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends Pagebase {

	public ComparePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Asus N551JK-XO076H Laptop")
	public WebElement firstProduct;

	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement secoundProduct;

	@FindBy(css = "a.clear-list")
	WebElement clearListLinks;

	@FindBy(css = "div.no-data")
	public WebElement noDataLab1;
	// You have no items to compare.

	@FindBy(css = "table.compare-products-table")
	WebElement compareTable;

	@FindBy(tagName = "tr")
	List<WebElement> allRows;

	@FindBy(tagName = "td")
	List<WebElement> allCols;

	public void clearCompareList() {
		ClickButton(clearListLinks);
	}

	public void compareProducts() {

		System.out.println(allRows.size());

		for (WebElement row : allRows) {
			System.out.println("rows :" + row.getText() );
			for (WebElement col : allCols) {
				System.out.println("Cols :" + col.getText());
			}
		}
	}

}
