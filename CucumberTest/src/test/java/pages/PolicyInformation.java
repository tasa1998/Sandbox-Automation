package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PolicyInformation extends BasePage {
    WebDriver driver;

    @FindBy(xpath = "//div[text()='Billing Method']/../../../..//input")
    WebElement billingMethod;
    @FindBy(xpath = "//div[text()='Program Type']/../../../..//input")
    WebElement programType;


    public PolicyInformation(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void billingMethod(String method) {
//        typeText(billingMethod, method, "");
        clickElement(billingMethod, "");
        clickElement(driver.findElement(By.xpath("//li[text()='" + method + "']")), "billing method");
    }

    public void programType(String type) throws InterruptedException {
//        typeText(programType, type, "");
        clickElement(programType, "");
        clickElement(driver.findElement(By.xpath("//li[text()='" + type + "']")), "program type");
        clickElement(programType, "");
        clickElement(driver.findElement(By.xpath("//li[text()='" + type + "']")), "program type");
    }

    public void isChildOrDayCareRunOutOfTheHome(String yesNo) {
        clickElement(driver.findElement(By.xpath("//div[text()='Is Child or Day Care run out of the home?']/../../../..//label[text()='" + yesNo + "']")), "");
    }

    public void anyUndergroundOilOrStorageTanks(String yesNo) {
        clickElement(driver.findElement(By.xpath("//div[text()='Any underground oil or storage tanks?']/../../../..//label[text()='" + yesNo + "']")), "");
    }

    public void isTheResidenceRentedMoreThan10Weeks(String yesNo) {
        clickElement(driver.findElement(By.xpath("//div[text()='Is the residence rented more than 10 weeks per year?']/../../../..//label[text()='" + yesNo + "']")), "");
    }

    public void isTheResidenceVacant(String yesNo) {
        clickElement(driver.findElement(By.xpath("//div[text()='Is the residence vacant?']/../../../..//label[text()='" + yesNo + "']")), "");
    }

    public void areThereAnyAnimalsOrExoticPetsKeptOnThePremises(String yesNo) {
        clickElement(driver.findElement(By.xpath("//div[text()='Are there any animals or exotic pets kept on the premises?']/../../../..//label[text()='" + yesNo + "']")), "");
    }

}
