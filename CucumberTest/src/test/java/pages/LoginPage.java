package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BasePage{
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(text(),'PARTNER NUMBER')]/../../../..//input")
    WebElement partnerNumber;

    @FindBy(xpath = "//div[contains(text(),'USERNAME')]/../../../..//input")
    WebElement username;

    @FindBy(xpath = "//div[contains(text(),'PASSWORD')]/../../../..//input")
    WebElement password;

    @FindBy(xpath = "//span[contains(text(),'login')]")
    WebElement loginBtn;

    public void login(){
        typeText(partnerNumber, "0", "");
        typeText(username, "nastasjadamjanac", "");
        typeText(password, "oneshield", "");
        clickElement(loginBtn, "");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='os-title-bar-greet']")).getText(),"Welcome");
    }
}
