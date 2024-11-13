package nscTest;

import baselibary.BaseLibrary;
import io.qameta.allure.Step;
import nscPages.CreateAdminPage;
import nscPages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import propertyutility.PropertyUtility;

public class CreateAdminTest extends BaseLibrary {

    LoginPage loginPage;
    CreateAdminPage createAdminPage;

    @BeforeTest
    public void launchURL(){
        getLaunchUrl(PropertyUtility.readData("browser"), PropertyUtility.readData("url"));
        loginPage = new LoginPage();
        createAdminPage = new CreateAdminPage();
        loginPage.loginWithValidDetails();
    }

    @Step
    @Test(priority = 1)
    public void addNSCAdmin() throws InterruptedException {
        createAdminPage.addNSCAdmin();
    }

    @Step
    @Test(priority = 2)
    public void addCompanyAdmin() throws InterruptedException {
        createAdminPage.addCompanyAdmin();
    }

    @AfterTest
    public void userLogout() throws InterruptedException {
        driver.quit();
    }
}
