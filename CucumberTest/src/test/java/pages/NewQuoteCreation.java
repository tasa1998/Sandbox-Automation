package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewQuoteCreation extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'new quote')]")
    WebElement newQuote;

    @FindBy(xpath = "//span[contains(text(),'Sherrie Insurance Co')]/../../..//span")
    WebElement agent;

    @FindBy(xpath = "//span[text()='>>> next']")
    WebElement createNewQuote;

    @FindBy(xpath = "//div[text()='First Name']/../../../..//input")
    WebElement firstNameField;

    @FindBy(xpath = "//div[text()='Last Name']/../../../..//input")
    WebElement lastNameField;

    @FindBy(xpath = "//div[text()='Date of Birth']/../../../..//input")
    WebElement dateOfBirthField;

    @FindBy(xpath = "//div[text()='Email']/../../../..//input")
    WebElement emailField;

    @FindBy(xpath = "//div[text()='Phone']/../../../..//input")
    WebElement phoneField;
    @FindBy(xpath = "//div[text()='Address Line 1']/../../../..//input")
    WebElement addressField;

    @FindBy(xpath = "//div[text()='ZIP Code']/../../../..//input")
    WebElement zipCodeField;

    @FindBy(xpath = "//div[text()='City']/../../../..//input")
    WebElement cityField;

    @FindBy(xpath = "//span[text()='>>> Search']/../../..")
    WebElement search;

    @FindBy(xpath = "//span[text()='>>> Create A New Customer']/../../..")
    WebElement createNewCustomer;

    @FindBy(xpath = "//span[text()='   >>> next']/../../..")
    WebElement nextBtn;

    @FindBy(xpath = "//span[text()='>>> skip']/../../..")
    WebElement skipBtn;

    public NewQuoteCreation(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createNewQuote() {
        clickElement(newQuote, "");
        clickElement(agent, "");
        clickElement(createNewQuote, "");
    }

    public void enterFirstname(String firstName1) {
        typeText(firstNameField, firstName1, "");
    }

    public void enterLastName(String lastName1) {
        typeText(lastNameField, lastName1, "");
    }

    public void enterDateOfBirth(String dateOfBirth1) {
        typeText(dateOfBirthField, dateOfBirth1, "");
    }

    public void enterEmail(String email1) {
        typeText(emailField, email1, "");
    }

    public void enterPhone(String phone1) {
        typeText(phoneField, phone1, "");
    }

    public void enterAddress(String address1) {
        typeText(addressField, address1, "");
    }

    public void enterZipCode(String zipCode1) {
        typeText(zipCodeField, zipCode1, "");
    }

    public void CreateNewCustomer() throws InterruptedException {
        clickElement(search, "search");
        Thread.sleep(3000);
        clickElement(createNewCustomer, "create new customer");
        Thread.sleep(3000);
        clickElement(createNewCustomer, "create new customer");
        clickElement(nextBtn, "");
        clickElement(skipBtn, "");
    }

    public void enterCustomerInformation(String firstName, String lastName, String DOB, String email, String phone, String address, String zip) throws InterruptedException {
        createNewQuote();
        enterFirstname(firstName);
        enterLastName(lastName);
        enterDateOfBirth(DOB);
        enterEmail(email);
        enterPhone(phone);
        enterAddress(address);
        enterZipCode(zip);
        CreateNewCustomer();
    }


}
