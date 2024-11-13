package nscPages;

import applicationUtility.ActionUtils;
import baselibary.BaseLibrary;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Random;

public class CreateAdminPage extends BaseLibrary {

    public CreateAdminPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Admin Management')]")
    WebElement adminManagment;
    @FindBy(xpath = "//button[contains(text(),'Add New')]")
    WebElement addManagementNew;
    @FindBy(xpath = "//label[contains(text(),'NSC Admin')]")
    WebElement NSCAdmin;
    @FindBy(xpath = "//input[@name='firstName']")
    WebElement firstName;
    @FindBy(xpath = "//p[contains(text(),'First name must contain only alphabets')]")
    WebElement firstNameError;
    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastName;
    @FindBy(xpath = "//p[contains(text(),'Last name must contain only alphabets')]")
    WebElement lastNameError;
    @FindBy(xpath = "//input[@name='emailAddress']")
    WebElement emailAddress;
    @FindBy(xpath = "//p[contains(text(),'Invalid email address')]")
    WebElement emailError;
    @FindBy(xpath = "//input[@name='loginId']")
    WebElement adminLoginId;
    @FindBy(xpath = "//p[contains(text(),'Login Id must be at least 5 characters long')]")
    WebElement adminLoginIdError;
    @FindBy(xpath = "//input[@name='password']")
    WebElement adminPassword;
    @FindBy(xpath = "//p[contains(text(),'Password must be at least 8 characters long')]")
    WebElement adminPasswordError;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement save;
    @FindBy(xpath = "//div[@class='flex relative flex-1']//input[@placeholder='Search...']")
    WebElement search;

    @FindBy(xpath = "//label[contains(text(),'Company Admin')]")
    WebElement companyAdmin;
    @FindBy(xpath = "(//button[@role='combobox'])[1]")
    WebElement associatedCompany;
    @FindBy(xpath = "(//button[@role='combobox'])[2]")
    WebElement AccessCodes;
    @FindBy(xpath = "(//button[@role='combobox'])[3]")
    WebElement roleType;

    Random random = new Random();
    int randomNumber = random.nextInt(100) + 1;
    String loginID = "prashant" + randomNumber;
    String loginId = "prashant" + randomNumber + 1;

    public void addNSCAdmin() throws InterruptedException {
        ActionUtils.click(adminManagment);
        ActionUtils.click(addManagementNew);
        ActionUtils.click(NSCAdmin);
        ActionUtils.set_text(firstName, "@123" + Keys.TAB);
        Assert.assertEquals(ActionUtils.get_text(firstNameError), "First name must contain only alphabets");
        ActionUtils.click(firstName);
        ActionUtils.clear(firstName);
        ActionUtils.waitFor(2);
        ActionUtils.set_text(firstName, "Prashant");

        ActionUtils.set_text(lastName, "@123" + Keys.TAB);
        Assert.assertEquals(ActionUtils.get_text(lastNameError), "Last name must contain only alphabets");
        ActionUtils.click(lastName);
        ActionUtils.clear(lastName);
        ActionUtils.waitFor(2);
        ActionUtils.set_text(lastName, "Saini");

        ActionUtils.set_text(emailAddress, "prashant@" + Keys.TAB);
        Assert.assertEquals(ActionUtils.get_text(emailError), "Invalid email address");
        ActionUtils.click(emailAddress);
        ActionUtils.clear(emailAddress);
        ActionUtils.waitFor(2);
        ActionUtils.set_text(emailAddress, "akshay@gmail.com");

        ActionUtils.set_text(adminLoginId, "Admi" + Keys.TAB);
        Assert.assertEquals(ActionUtils.get_text(adminLoginIdError), "Login Id must be at least 5 characters long");
        ActionUtils.click(adminLoginId);
        ActionUtils.clear(adminLoginId);
        ActionUtils.waitFor(2);
        ActionUtils.set_text(adminLoginId, loginID);

        ActionUtils.set_text(adminPassword, "test" + Keys.TAB);
        Assert.assertEquals(ActionUtils.get_text(adminPasswordError), "Password must be at least 8 characters long");
        ActionUtils.click(adminPassword);
        ActionUtils.clear(adminPassword);
        ActionUtils.waitFor(2);
        ActionUtils.set_text(adminPassword, "akshayTest@123");

        ActionUtils.click(save);
        System.out.println("Create Admin succefully");
        ActionUtils.waitFor(4);
        ActionUtils.set_text(search, loginID + Keys.ENTER);
        ActionUtils.waitFor(4);
        ActionUtils.screenshot();
    }

    public void addCompanyAdmin() throws InterruptedException {
        ActionUtils.click(adminManagment);
        ActionUtils.click(addManagementNew);
        ActionUtils.click(companyAdmin);

        ActionUtils.set_text(firstName, "@123" + Keys.TAB);
        Assert.assertEquals(ActionUtils.get_text(firstNameError), "First name must contain only alphabets");
        ActionUtils.click(firstName);
        ActionUtils.clear(firstName);
        ActionUtils.waitFor(2);
        ActionUtils.set_text(firstName, "Akshay");

        ActionUtils.set_text(lastName, "@123" + Keys.TAB);
        Assert.assertEquals(ActionUtils.get_text(lastNameError), "Last name must contain only alphabets");
        ActionUtils.click(lastName);
        ActionUtils.clear(lastName);
        ActionUtils.waitFor(2);
        ActionUtils.set_text(lastName, "kumar");

        ActionUtils.set_text(emailAddress, "prashant@" + Keys.TAB);
        Assert.assertEquals(ActionUtils.get_text(emailError), "Invalid email address");
        ActionUtils.click(emailAddress);
        ActionUtils.clear(emailAddress);
        ActionUtils.waitFor(2);
        ActionUtils.set_text(emailAddress, "akshay@gmail.com");

        ActionUtils.set_text(adminLoginId, "Admi" + Keys.TAB);
        Assert.assertEquals(ActionUtils.get_text(adminLoginIdError), "Login Id must be at least 5 characters long");
        ActionUtils.click(adminLoginId);
        ActionUtils.clear(adminLoginId);
        ActionUtils.waitFor(2);
        ActionUtils.set_text(adminLoginId, loginId);

        ActionUtils.set_text(adminPassword, "test" + Keys.TAB);
        Assert.assertEquals(ActionUtils.get_text(adminPasswordError), "Password must be at least 8 characters long");
        ActionUtils.click(adminPassword);
        ActionUtils.clear(adminPassword);
        ActionUtils.waitFor(2);
        ActionUtils.set_text(adminPassword, "Ankit@1234");

        ActionUtils.set_text(associatedCompany, "Global Holdings Ltd." + Keys.ENTER);
        ActionUtils.set_text(AccessCodes, "GH123");
        ActionUtils.set_text(roleType, "Write Access" + Keys.ENTER);

        ActionUtils.click(save);
        System.out.println("Company Admin create successfully");
        ActionUtils.waitFor(4);
        ActionUtils.set_text(search, loginId + Keys.ENTER);
        ActionUtils.waitFor(4);
        ActionUtils.screenshot();
    }
}
