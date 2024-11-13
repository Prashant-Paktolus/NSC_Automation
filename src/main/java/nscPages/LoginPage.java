package nscPages;

import applicationUtility.ActionUtils;
import baselibary.BaseLibrary;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import propertyutility.PropertyUtility;

public class LoginPage extends BaseLibrary {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='loginId']")
    WebElement loginID;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    WebElement signIn;
    @FindBy(xpath = "//h3[contains(text(),'Invalid Credentials')]")
    WebElement invalid_text;
    @FindBy(xpath = "//a[contains(text(),'Back to Login')]")
    WebElement backToLogin;

    public void loginWithInvalidDetails() {
        ActionUtils.set_text(loginID, PropertyUtility.readData("invalidUserName"));
        ActionUtils.set_text(password, PropertyUtility.readData("invalidPassword"));
        ActionUtils.click(signIn);
        ActionUtils.screenshot();
        Assert.assertEquals(ActionUtils.get_text(invalid_text), "Invalid Credentials");
        System.out.println("SignIn not succesfully");
        ActionUtils.click(backToLogin);
    }

    public void loginWithValidDetails() {
        ActionUtils.set_text(loginID, PropertyUtility.readData("validUserName"));
        ActionUtils.set_text(password, PropertyUtility.readData("validPassword"));
        ActionUtils.click(signIn);
        System.out.println("SignIn succesfully");
        ActionUtils.screenshot();
    }
}
