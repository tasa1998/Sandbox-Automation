package pages.AutoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class AutoVehicle extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//input[@class='x-form-field x-form-text x-form-text-default ']")
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

    public AutoVehicle(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void selectYear(String value) {
        clickElement(yearSelect, "Gender dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + value + "']")), "Gender");
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

    public void fillInVehiclePage(String year, String make, String model, String specification, String vehicleUse){
        selectYear(year);
        selectMake(make);
        selectModel(model);
        selectSpecification(specification);
        selectVehicleUse(vehicleUse);
        clickNextBtn();
    }



}
