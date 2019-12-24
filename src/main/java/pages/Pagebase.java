package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Pagebase {

	protected WebDriver driver;
	public JavascriptExecutor js;
	public Select select;
	public Actions action;

	public Pagebase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	protected static void ClickButton(WebElement button) {
		button.click();
	}

	protected static void SetTextElemnetintext(WebElement textElement, String value) {
		textElement.sendKeys(value);
	}

	
	protected static void ClearText(WebElement element) {
		element.clear();
	}

	
	public void ScrollToButtom() {

		js.executeScript("scrollBy(0,2500)");
	}

	
	// new
	public void ScrollToElement(WebElement locator) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", locator);
	}

	// new
	public void changeDropDownList(WebElement nameOfList, String searchTxt) {
		select = new Select(nameOfList);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			if (options.get(i).getText().contains(searchTxt)) {
				options.get(i).click();
				break;
			}
		}
	}

	// new
	public void checkdatatable(String value) {
		WebElement table = driver.findElement(By.cssSelector("table.compare-products-table"));
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		// System.out.println("allRows" + allRows.toString());

		for (WebElement row : allRows) {
			// System.out.println("rows :" + row.getText() );
			List<WebElement> allCols = row.findElements(By.tagName("td"));
			// System.out.println("allCols" +allCols.toString());

			for (WebElement col : allCols) {
				if (col.getText().contains(value)) {
					System.out.println("Elememt existing " + col.getText());
				} else {
					System.out.println("Elememt Not existing ");
				}
			}

		}

	}

}
