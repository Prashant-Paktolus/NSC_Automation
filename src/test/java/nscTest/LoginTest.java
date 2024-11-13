package nscTest;

import baselibary.BaseLibrary;
import io.qameta.allure.Step;
import nscPages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import propertyutility.PropertyUtility;

public class LoginTest extends BaseLibrary
{
    LoginPage loginPage;

    @BeforeTest
    public void getLaunchUrl(){
        getLaunchUrl(PropertyUtility.readData("browser"), PropertyUtility.readData("url"));
        loginPage = new LoginPage();
    }

    @Step
    @Test(priority = 1)
    public void loginWithInvalidDetails()
    {
       loginPage.loginWithInvalidDetails();
    }

    @Step
    @Test(priority = 2)
    public void loginWithValidDetails() {
        loginPage.loginWithValidDetails();
    }

    @AfterTest
    public void userLogout() throws InterruptedException {
        driver.quit();
    }
}
