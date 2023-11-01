package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LocationCoverage extends BasePage{

    WebDriver driver;

    @FindBy(xpath = "//div[text()='Residence Type']/../../../..//input")
    WebElement residenceType;

    @FindBy(xpath = "//div[text()='All Perils Deductible']/../../../..//input")
    WebElement allPerilsDeductible;

    @FindBy(xpath = "//div[text()='Replacement Cost']/../../../..//input")
    WebElement replacementCost;

    @FindBy(xpath = "//div[text()='Other Structures']/../../../..//input")
    WebElement otherStructures;

    @FindBy(xpath = "//div[text()='Year Built']/../../../..//input")
    WebElement yearBuilt;

    @FindBy(xpath = "//div[text()='Windstorm or Hail  Deductible']/../../../..//input")
    WebElement windstormOrHailDeductible;

    @FindBy(xpath = "//div[text()='Liability']/../../../..//input")
    WebElement liability;

    @FindBy(xpath = "//div[text()='Medical Payments']/../../../..//input")
    WebElement medicalPayments;

    @FindBy(xpath = "//a[text()='homeowners | location coverage']")
    WebElement locationCoverage;

    @FindBy(xpath = "//div[text()='Construction Type']/../../../..//input")
    WebElement constructionType;

    @FindBy(xpath = "//div[text()='Roof Type']/../../../..//input")
    WebElement roofType;

    @FindBy(xpath = "//div[text()='Contents']/../../../..//input")
    WebElement contents;

    @FindBy(xpath = "//div[text()='Loss of Use']/../../../..//input")
    WebElement lossOfUse;

    @FindBy(xpath = "//span[text()='save changes']")
    WebElement save;

    public LocationCoverage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLocationCoverage(){
        clickElement(locationCoverage,"");
    }

    public void enterResidenceType(String residenceType1){
        clickElement(residenceType,"");
        clickElement(driver.findElement(By.xpath("//li[text()='"+residenceType1+"']")), "");
    }

    public void enterReplacementCost(String value){
        typeText(replacementCost,value,"");
    }
    public void enterContents(String value){
        typeText(contents,value,"");
    }

    public void enterLossOfUse(String value){
        typeText(lossOfUse,value,"");
    }

    public void enterOtherStructures(String value){
        typeText(otherStructures,value,"");
    }
    public void enterYearBuilt(String value){
        typeText(yearBuilt,value,"");
    }

    public void enterAllPerilsDed(String value){
        typeText(allPerilsDeductible, value, "");
//        clickElement(allPerilsDeductible,"");
//        clickElement(driver.findElement(By.xpath("//li[text()='"+value+"']")), "");
    }
    public void enterWindstormOrHailDed(String value){
        typeText(windstormOrHailDeductible, value, "");
//        clickElement(windstormOrHailDeductible,"");
//        clickElement(driver.findElement(By.xpath("//li[text()='"+value+"']")), "");
    }
    public void enterLiability(String value){
        typeText(liability, value, "");
//        clickElement(liability,"");
//        clickElement(driver.findElement(By.xpath("//li[text()='"+value+"']")), "");
    }

    public void enterMedicalPayments(String value){
        typeText(medicalPayments, value, "");
//        clickElement(medicalPayments,"");
//        clickElement(driver.findElement(By.xpath("//li[text()='"+value+"']")), "");
    }
    public void enterConstructionType(String value){
        clickElement(constructionType,"");
        clickElement(driver.findElement(By.xpath("//li[text()='"+value+"']")), "");
    }
    public void enterRoofType(String value){
        clickElement(roofType,"");
        clickElement(driver.findElement(By.xpath("//li[text()='"+value+"']")), "");
    }

    public void anyLossesOnTheLastThreeYears(String yesNo) {
        clickElement(driver.findElement(By.xpath("//div[text()='Any losses in the last three years?']/../../../..//label[text()='" + yesNo + "']")), "");
    }

    public void saveChanges() {
        clickElement(save, "");
    }

}
