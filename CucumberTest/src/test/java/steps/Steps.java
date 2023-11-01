package steps;

import excel_core.GetExcelData;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Reporter;
import pages.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Steps extends BaseTest {

    Map<String, String> customerData = new HashMap<>();
    Map<String, String> homePageData = new HashMap<>();
    Map<String,String> homeOwnersData = new HashMap<>();

    final String BROWSER = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("BROWSER");
    final String WAIT = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("WAIT");

    @Before
    public void beforeCucumber() {
        setup(BROWSER, Integer.parseInt(WAIT));
    }

    @After
    public void after() {
        basequit();
    }

    @Given("user open sandbox")
    public void userOpenSandbox() {
        driver.get("https://inforcedev.oneshield.com/oneshield/");
    }

    @And("user enters {string} in {string}")
    public void userEntersIn(String arg0, String arg1) throws IOException {
        String jsonFilePath = System.getProperty("user.dir") + "/src/webElements.json";
        driver.findElement(By.xpath(CommonUtility.getWebLocator("webLocators." + arg1 + ".xpath", jsonFilePath))).sendKeys(arg0);
    }

    @Then("user logs in")
    public void userLogsIn() {
        new LoginPage(driver).login();
    }

    @Given("load data from excel")
    public void loadDataFromExcel() throws IOException {
        customerData = new GetExcelData().getRowData("src/TestData/SandboxDataAutomatin_Practice.xlsx", "CustomerData", 0);
        homeOwnersData = new GetExcelData().getRowData("src/TestData/SandboxDataAutomatin_Practice.xlsx", "Homeowners", 0);
        homePageData = new GetExcelData().getRowData("src/TestData/SandboxDataAutomatin_Practice.xlsx", "HomePage", 2);
    }

    @Then("user create new customer")
    public void userCreateNewCustomer() throws InterruptedException {
        new NewQuoteCreation(driver).createNewQuote();
        new NewQuoteCreation(driver).enterFirstname(customerData.get("FirstName"));
        new NewQuoteCreation(driver).enterLastName(customerData.get("LastName"));
        new NewQuoteCreation(driver).enterDateOfBirth(customerData.get("DOB"));
        new NewQuoteCreation(driver).enterEmail(customerData.get("Email"));
        new NewQuoteCreation(driver).enterPhone(customerData.get("Phone"));
        new NewQuoteCreation(driver).enterAddress(customerData.get("Address Line 1"));
        new NewQuoteCreation(driver).enterZipCode(customerData.get("ZIP Code"));
        new NewQuoteCreation(driver).CreateNewCustomer();
    }

    @And("user register quote")
    public void userRegisterQuote() {
        new QuoteRegistration(driver).fillInQuoteRegistration(homePageData.get("Producer"), homePageData.get("Effective Date"), homePageData.get("Program"));
    }

    @And("user fill in policy information")
    public void userFillInPolicyInformation() throws InterruptedException {
        new PolicyInformation(driver).billingMethod(homeOwnersData.get("Billing Method"));
        new PolicyInformation(driver).programType(homeOwnersData.get("Program Type"));
        new PolicyInformation(driver).isChildOrDayCareRunOutOfTheHome(homeOwnersData.get("Is Child or Day Care run out of the home?"));
        new PolicyInformation(driver).anyUndergroundOilOrStorageTanks(homeOwnersData.get("Any underground oil or storage tanks?"));
        new PolicyInformation(driver).isTheResidenceRentedMoreThan10Weeks(homeOwnersData.get("Is the residence rented more than 10 weeks per year?"));
        new PolicyInformation(driver).isTheResidenceVacant(homeOwnersData.get("Is the residence vacant?"));
        new PolicyInformation(driver).areThereAnyAnimalsOrExoticPetsKeptOnThePremises(homeOwnersData.get("Are there any animals or exotic pets kept on the premises?"));
    }

    @And("user fill in location coverage")
    public void userFillInLocationCoverage() {
        new LocationCoverage(driver).clickLocationCoverage();
        new LocationCoverage(driver).enterResidenceType(homeOwnersData.get("Residence Type"));
        new LocationCoverage(driver).enterReplacementCost(homeOwnersData.get("Replacement Cost"));
        new LocationCoverage(driver).enterAllPerilsDed(homeOwnersData.get("All Perils Deductible"));
        new LocationCoverage(driver).enterWindstormOrHailDed(homeOwnersData.get("Windstorm or Hail Deductible"));
        new LocationCoverage(driver).enterLiability(homeOwnersData.get("Liability"));
        new LocationCoverage(driver).enterMedicalPayments(homeOwnersData.get("Medical Payments"));
        new LocationCoverage(driver).enterYearBuilt(homeOwnersData.get("Year Built"));
        new LocationCoverage(driver).enterRoofType(homeOwnersData.get("Roof Type"));
        new LocationCoverage(driver).enterConstructionType(homeOwnersData.get("Construction Type"));
        new LocationCoverage(driver).anyLossesOnTheLastThreeYears(homeOwnersData.get("Any losses in the last three years?"));
        new LocationCoverage(driver).saveChanges();
    }

    @And("user binds quote")
    public void userBindsQuote() throws InterruptedException {
        new EndOfQuoteCreation(driver).rateAndRequestIssue();
        new EndOfQuoteCreation(driver).bindInformation(homeOwnersData.get("Existing Agency Client?"),homeOwnersData.get("Has any company cancelled or refused to insure in the past 3 years?"),homeOwnersData.get("Has coverage been non-renewed or Declined?"));
        new EndOfQuoteCreation(driver).rateAndRequestIssue();
        new EndOfQuoteCreation(driver).clickNext();
    }
}
