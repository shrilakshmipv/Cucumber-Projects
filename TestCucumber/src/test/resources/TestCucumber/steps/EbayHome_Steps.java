package TestCucumber.steps;

import static java.lang.Integer.parseInt;
import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class EbayHome_Steps {
	WebDriver driver;



	
	@Given("Ebay home page")
	public void ebay_home_page() {
		System.setProperty("webdriver.chrome.driver", "/Users/nishanth/Downloads/chromedriver-mac-x64/chromedriver");
		driver= new ChromeDriver();
		driver.get("https://www.ebay.com/");
	}

	@When("i click the advanced link")
	public void i_click_the_advanced_link() {
		driver.findElement(By.linkText("Advanced")).click();
	   
	}

	@Then("I navigate to Advanced Search page")
	public void i_navigate_to_advanced_search_page() {
		String expUrl= "https://www.ebay.com/sch/ebayadvsearch";
		String actual=driver.getCurrentUrl();
		if(!actual.equals(expUrl))
		{
			fail("Page did not navigate to the expected URL");
		}


	}


	@When("I search for {string}")
	public void i_search_for_iphone(String prod) {
		driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(prod);
		driver.findElement(By.xpath("//input[@id='gh-btn']")).click();

	}
	@Then("I validate atleast {int} items")
	public void i_validate_atleast_items(int count) {
		String itemCount= driver.findElement(By.cssSelector("div[class='srp-controls__control srp-controls__count'] span:nth-child(1)")).getText().trim();
		String itemCount2= itemCount.replace(",","");
		int itemCountInt = Integer.parseInt(itemCount2);
		if(itemCountInt <= count){
			fail("count less than 1000");
		}
		driver.quit();

	}


	@When("I search for {string} in {string} category")
	public void iSearchForSoapInBabyCategory(String str1, String str2) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(str1);
		List<WebElement> cat =  driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
		for(WebElement i : cat){
			if(i.getText().trim().toLowerCase().equals(str2.toLowerCase())){
				i.click();
				break;
			}
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
		Thread.sleep(1000);
		driver.quit();
	}

	@When("I click on the {string}")
	public void i_click_on_the(String pageLink) throws InterruptedException {
		driver.findElement(By.linkText(pageLink)).click();
		Thread.sleep(1000);
	}
	@Then("I validate that the page navigates to {string} and title contains {string}")
	public void i_validate_that_the_page_navigates_to_and_title_contains(String eUrl, String title) {
		String actUrl= driver.getCurrentUrl();
		String actTitle=driver.getTitle();

		if(!actUrl.equals(eUrl)){
			fail("page did not navigate to"+ eUrl);
		}
		if(!actTitle.contains(title)){
			fail("Title did not match");
		}
		driver.quit();
	}
}
