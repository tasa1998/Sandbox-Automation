package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LocationCoverage extends BasePage{

    WebDriver driver;

    @FindBy(xpath = "//div[text()='Residence Type']/../../../..//input")
    WebElement residenceTypeSelect;

    @FindBy(xpath = "//div[text()='All Perils Deductible']/../../../..//input")
    WebElement allPerilsDeductibleSelect;

    @FindBy(xpath = "//div[text()='Replacement Cost']/../../../..//input")
    WebElement replacementCostField;

    @FindBy(xpath = "//div[text()='Other Structures']/../../../..//input")
    WebElement otherStructuresField;

    @FindBy(xpath = "//div[text()='Year Built']/../../../..//input")
    WebElement yearBuiltField;

    @FindBy(xpath = "//div[text()='Windstorm or Hail  Deductible']/../../../..//input")
    WebElement windstormOrHailDeductibleSelect;

    @FindBy(xpath = "//div[text()='Liability']/../../../..//input")
    WebElement liabilitySelect;

    @FindBy(xpath = "//div[text()='Medical Payments']/../../../..//input")
    WebElement medicalPaymentsSelect;

    @FindBy(xpath = "//a[text()='homeowners | location coverage']")
    WebElement locationCoverage;

    @FindBy(xpath = "//div[text()='Construction Type']/../../../..//input")
    WebElement constructionTypeSelect;

    @FindBy(xpath = "//div[text()='Roof Type']/../../../..//input")
    WebElement roofTypeSelect;

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
        clickElement(residenceTypeSelect,"");
        clickElement(driver.findElement(By.xpath("//li[text()='"+residenceType1+"']")), "");
    }

    public void enterReplacementCost(String value){
        typeText(replacementCostField,value,"");
    }
    public void enterContents(String value){
        typeText(contents,value,"");
    }

    public void enterLossOfUse(String value){
        typeText(lossOfUse,value,"");
    }

    public void enterOtherStructures(String value){
        typeText(otherStructuresField,value,"");
    }
    public void enterYearBuilt(String value){
        typeText(yearBuiltField,value,"");
    }

    public void enterAllPerilsDed(String value){
        typeText(allPerilsDeductibleSelect, value, "");
//        clickElement(allPerilsDeductible,"");
//        clickElement(driver.findElement(By.xpath("//li[text()='"+value+"']")), "");
    }
    public void enterWindstormOrHailDed(String value){
        typeText(windstormOrHailDeductibleSelect, value, "");
//        clickElement(windstormOrHailDeductible,"");
//        clickElement(driver.findElement(By.xpath("//li[text()='"+value+"']")), "");
    }
    public void enterLiability(String value){
        typeText(liabilitySelect, value, "");
//        clickElement(liability,"");
//        clickElement(driver.findElement(By.xpath("//li[text()='"+value+"']")), "");
    }

    public void enterMedicalPayments(String value){
        typeText(medicalPaymentsSelect, value, "");
//        clickElement(medicalPayments,"");
//        clickElement(driver.findElement(By.xpath("//li[text()='"+value+"']")), "");
    }
    public void enterConstructionType(String value){
        clickElement(constructionTypeSelect,"");
        clickElement(driver.findElement(By.xpath("//li[text()='"+value+"']")), "");
    }
    public void enterRoofType(String value){
        clickElement(roofTypeSelect,"");
        clickElement(driver.findElement(By.xpath("//li[text()='"+value+"']")), "");
    }

    public void anyLossesOnTheLastThreeYears(String yesNo) {
        clickElement(driver.findElement(By.xpath("//div[text()='Any losses in the last three years?']/../../../..//label[text()='" + yesNo + "']")), "");
    }

    public void saveChanges() {
        clickElement(save, "");
    }

    public void fillInLocationCoverage( String residenceType, String replacementCost, String allPerilsDed, String windstormOrHailDed, String liability, String medicalPayments, String yearBuilt, String roofType, String constructionType, String yesNo){
        clickLocationCoverage();
        enterResidenceType(residenceType);
        enterReplacementCost(replacementCost);
        enterAllPerilsDed(allPerilsDed);
        enterWindstormOrHailDed(windstormOrHailDed);
        enterLiability(liability);
        enterMedicalPayments(medicalPayments);
        enterYearBuilt(yearBuilt);
        enterRoofType(roofType);
        enterConstructionType(constructionType);
        anyLossesOnTheLastThreeYears(yesNo);
        saveChanges();
    }
}
