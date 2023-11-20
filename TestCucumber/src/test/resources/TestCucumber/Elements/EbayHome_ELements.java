package TestCucumber.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EbayHome_ELements {
    WebDriver driver;
    @FindBy(linkText = "Advanced") public WebElement adHomePage;
    @FindBy(xpath = "//input[@id='gh-ac']") public WebElement prodName;
    @FindBy(xpath = "//input[@id='gh-btn']") public WebElement srchbttn;
    @FindBy(css = "div[class='srp-controls__control srp-controls__count'] span:nth-child(1)") public WebElement noOfItems;
    @FindBy(xpath = "//input[@id='gh-ac']") public WebElement productName;
    @FindBy(xpath = "//select[@id='gh-cat']/option") public List<WebElement> category;

    public  EbayHome_ELements(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }


}
