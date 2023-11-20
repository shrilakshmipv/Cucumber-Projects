package TestCucumber.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EasyAdvancedSerach_elements {

    WebDriver driver;

    @FindBy(xpath = "//a[@id='gh-la']") public WebElement ebayLogo;
    @FindBy(xpath = "//input[@id='_nkw']") public WebElement searchString;
    @FindBy(xpath = "//input[@id='_ex_kw']") public WebElement excludeString;
    @FindBy(xpath = "//input[@name='_udlo']") public WebElement minPrice;

    @FindBy(xpath = "//input[@name='_udhi']") public WebElement maxPrice;
    @FindBy(xpath = "//div[@class='adv-form__actions']//button[@type='submit'][normalize-space()='Search']") public WebElement searchButton;

    public  EasyAdvancedSerach_elements(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }


}
