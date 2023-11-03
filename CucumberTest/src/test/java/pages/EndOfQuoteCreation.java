package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class EndOfQuoteCreation extends BasePage {
    WebDriver driver;

    @FindBy(xpath = "//span[text()='>>> rate quote']/../../..")
    WebElement rateQuote;

    @FindBy(xpath = "//span[text()=' >>> request issue']/../../..")
    WebElement requestIssue;

    @FindBy(xpath = "//span[text()='save changes']/../../..")
    WebElement saveChanges;

    @FindBy(xpath = "//span[text()='>>> next ']/../../..")
    WebElement next;

    @FindBy(xpath = "//span[text()='>>> bind']/../../..")
    WebElement bind;
    public EndOfQuoteCreation(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void rateAndRequestIssue() throws InterruptedException {
        Thread.sleep(3000);
        clickElement(rateQuote,"");
        Thread.sleep(3000);
        clickElement(requestIssue,"");
    }
    public void bindInformation(String existingAgencyClient, String canceledOrRefusedToInsure, String coverageNonRenewedOrDeclined){
        clickElement(driver.findElement(By.xpath("//div[text()='Existing Agency Client?']/../../../..//label[text()='" + existingAgencyClient + "']")), "");
        clickElement(driver.findElement(By.xpath("//div[text()='Has any company cancelled or refused to insure in the past 3 years?']/../../../..//label[text()='" + canceledOrRefusedToInsure + "']")), "");
        clickElement(driver.findElement(By.xpath("//div[text()='Has coverage been non-renewed or Declined?']/../../../..//label[text()='" + coverageNonRenewedOrDeclined + "']")), "");
        clickElement(saveChanges,"");
    }

    public void clickNext() throws InterruptedException {
        Thread.sleep(3000);
        clickElement(next,"");
        Thread.sleep(3000);
        clickElement(next,"");
        Thread.sleep(3000);
        clickElement(bind,"");
    }

    public void bindQuote(String existingClient, String refusedToInsure, String nonRenewedOrDeclined) throws InterruptedException, IOException {
        rateAndRequestIssue();
        bindInformation(existingClient, refusedToInsure, nonRenewedOrDeclined);
        rateAndRequestIssue();
        clickNext();
        Thread.sleep(3000);
        reportScreenshot("src1","Testdesc");
    }


}
