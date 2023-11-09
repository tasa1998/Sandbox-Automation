package pages.AutoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class AutoVehicle extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//div[text()='Year']/../../../..//input[@class='x-form-field x-form-text x-form-text-default ']")
    WebElement yearSelect;

    @FindBy(xpath = "//div[text()='Make']/../../../..//input[@class='x-form-field x-form-text x-form-text-default ']")
    WebElement makeSelect;

    @FindBy(xpath = "//div[text()='Model']/../../../..//input[@class='x-form-field x-form-text x-form-text-default ']")
    WebElement modelSelect;

    @FindBy(xpath = "//div[text()='Specification']/../../../..//input[@class='x-form-field x-form-text x-form-text-default ']")
    WebElement specificationSelect;

    @FindBy(xpath = "//input[@class='x-form-field x-form-text x-form-text-default ']")
    WebElement vehicleUseSelect;

    @FindBy(xpath = "//span[text()='next']")
    WebElement nextBtn;

    @FindBy(xpath = "//span[text()='add vehicle']")
    WebElement addVehicleBtn;

    @FindBy(xpath = "//div[text()='Original Cost']/../../../..//input[@class='x-form-field x-form-text x-form-text-default ']")
    WebElement originalCost;

    @FindBy(xpath = "//div[text()='Stated Amount']/../../../..//input[@class='x-form-field x-form-text x-form-text-default ']")
    WebElement statedAmount;

    public AutoVehicle(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void selectYear(String value) throws InterruptedException {
        Thread.sleep(3000);
        clickElement(yearSelect, "Year dropdown");
        Thread.sleep(3000);
        clickElement(driver.findElement(By.xpath("//li[text()='" + value + "']")), "Year");
    }
    public void selectMake(String value) {
        clickElement(makeSelect, "Make dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + value + "']")), "Make");
    }
    public void selectModel(String value) {
        clickElement(modelSelect, "Model dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + value + "']")), "Model");
    }
    public void selectSpecification(String value) {
        clickElement(specificationSelect, "Specification dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + value + "']")), "Specification");
    }
    public void selectVehicleUse(String value) {
        clickElement(vehicleUseSelect, "VehicleUse dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + value + "']")), "VehicleUse");
    }

    public void clickNextBtn(){
        clickElement(nextBtn, "next");
    }

    public void addVehicle(String originalcost, String statedamount){
        clickElement(addVehicleBtn, "Add Vehicle");
        typeText(originalCost, originalcost, "Original Cost");
        typeText(statedAmount, statedamount, "Stated Amount");
    }

    public void fillInVehiclePage(String year, String make, String model, String specification, String vehicleUse) throws InterruptedException {
        selectYear(year);
        selectMake(make);
        selectModel(model);
        selectSpecification(specification);
        selectVehicleUse(vehicleUse);
        clickNextBtn();
    }

    public void fillInVehiclePageRegression(String year, String make, String model, String specification, String vehicleUse, String originalcost, String statedamount) throws InterruptedException {
        selectYear(year);
        selectMake(make);
        selectModel(model);
        selectSpecification(specification);
        selectVehicleUse(vehicleUse);
        addVehicle(originalcost, statedamount);
        selectYear(year);
        selectMake(make);
        selectModel(model);
        selectSpecification(specification);
        selectVehicleUse(vehicleUse);
        clickNextBtn();
    }
}
