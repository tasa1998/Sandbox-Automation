package pages.HomePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class LocationCoverage extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//div[text()='Residence Type']/../../../..//input")
    WebElement residenceTypeSelect;

    @FindBy(xpath = "//div[text()='# of Floors']/../../../..//input")
    WebElement numberOfFloorsField;

    @FindBy(xpath = "//div[text()='Policy Coverage Option']/../../../..//input")
    WebElement coverageOptionField;

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
    WebElement contentsField;

    @FindBy(xpath = "//div[text()='Loss of Use']/../../../..//input")
    WebElement lossOfUseField;

    @FindBy(xpath = "//span[text()='save changes']")
    WebElement save;

    public LocationCoverage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLocationCoverage(){
        clickElement(locationCoverage,"Coverage");
    }

    public void enterResidenceType(String residenceType1, String number, String coverageOptions){
        clickElement(residenceTypeSelect,"Residence Type Dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='"+residenceType1+"']")), "Residence Type");
        if(residenceType1.equals("Tenants")){
            typeText(numberOfFloorsField, number, "Number of Floors");
            typeText(coverageOptionField, coverageOptions, "Coverage Options");
        }
    }

    public void enterReplacementCost(String value){
        typeText(replacementCostField,value,"Replacement Cost");
    }
    public void enterContents(String value){
        typeText(contentsField,value,"Contents");
    }

    public void enterLossOfUse(String value){
        typeText(lossOfUseField,value,"Loss of Use");
    }

    public void enterOtherStructures(String value){
        typeText(otherStructuresField,value,"");
    }
    public void enterYearBuilt(String value){
        typeText(yearBuiltField,value,"Year Built");
    }

    public void enterAllPerilsDed(String value){
        typeText(allPerilsDeductibleSelect, value, "AOP");
//        clickElement(allPerilsDeductible,"");
//        clickElement(driver.findElement(By.xpath("//li[text()='"+value+"']")), "");
    }
    public void enterWindstormOrHailDed(String value){
        typeText(windstormOrHailDeductibleSelect, value, "Windstorm or Hail");
//        clickElement(windstormOrHailDeductible,"");
//        clickElement(driver.findElement(By.xpath("//li[text()='"+value+"']")), "");
    }
    public void enterLiability(String value){
        typeText(liabilitySelect, value, "Liability");
//        clickElement(liability,"");
//        clickElement(driver.findElement(By.xpath("//li[text()='"+value+"']")), "");
    }

    public void enterMedicalPayments(String value){
        typeText(medicalPaymentsSelect, value, "Medical Payments");
//        clickElement(medicalPayments,"");
//        clickElement(driver.findElement(By.xpath("//li[text()='"+value+"']")), "");
    }
    public void enterConstructionType(String value){
        clickElement(constructionTypeSelect,"Construction Type Dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='"+value+"']")), "Construction Type");
    }
    public void enterRoofType(String value){
        clickElement(roofTypeSelect,"Roof Type Dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='"+value+"']")), "Roof Type");
    }

    public void anyLossesOnTheLastThreeYears(String yesNo) {
        clickElement(driver.findElement(By.xpath("//div[text()='Any losses in the last three years?']/../../../..//label[text()='" + yesNo + "']")), "Previous Losses");
    }

    public void saveChanges() {
        clickElement(save, "Save Changes");
    }

    public void fillInLocationCoverage( String residenceType, String replacementCost, String coverageOptions, String allPerilsDed, String windstormOrHailDed, String liability, String medicalPayments, String yearBuilt, String roofType, String constructionType, String yesNo, String number){
        clickLocationCoverage();
        enterResidenceType(residenceType, number, coverageOptions);
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
    public void fillInLocationCoverageTenant( String residenceType, String contents, String lossOfUse, String coverageOptions, String allPerilsDed, String windstormOrHailDed, String liability, String medicalPayments, String yearBuilt, String roofType, String constructionType, String yesNo, String number){
        clickLocationCoverage();
        enterResidenceType(residenceType, number, coverageOptions);
        enterContents(contents);
        enterLossOfUse(lossOfUse);
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
