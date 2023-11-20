package TestCucumber.steps;

import static org.junit.Assert.fail;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Ebay_Advanced_Search {
    WebDriver driver;


    @Given("I am on Ebay Advanced Search Page")
    public void i_am_on_ebay_advanced_search_page() {
        System.setProperty("webdriver.chrome.driver", "/Users/nishanth/Downloads/chromedriver-mac-x64/chromedriver");
        driver= new ChromeDriver();
        driver.get("https://www.ebay.com/sch/ebayadvsearch");

    }

    @When("I click on Ebay logo")
    public void i_click_on_ebay_logo() {

        driver.findElement(By.xpath("//a[@id='gh-la']")).click();
    }


    @Then("I navigate to Ebay HOme page")
    public void i_navigate_to_ebay_h_ome_page() {
        String expUrl = "https://www.ebay.com/";
        String actual = driver.getCurrentUrl();
        if (!expUrl.contains(actual)) {
            fail("Page did not navigate");
        }
        driver.quit();
    }


    @When("I advance searced an item")
    public void i_advance_searced_an_item(DataTable dataTable) throws InterruptedException {
       driver.findElement(By.xpath("//input[@id='_nkw']")).sendKeys(dataTable.cell(1,0));
       driver.findElement(By.xpath("//input[@id='_ex_kw']")).sendKeys(dataTable.cell(1,1));
       driver.findElement(By.xpath("//input[@name='_udlo']")).sendKeys(dataTable.cell(1,2));
       driver.findElement(By.xpath("//input[@name='_udhi']")).sendKeys(dataTable.cell(1,3));
       driver.findElement(By.xpath("//div[@class='adv-form__actions']//button[@type='submit'][normalize-space()='Search']")).click();
       Thread.sleep(3000);
       driver.quit();

    }
}


