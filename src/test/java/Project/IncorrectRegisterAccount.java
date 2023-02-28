package Project;

import ExtentUtility.ExtentReport;
import Objects.RegisterObject;
import Pages.IndexPage;
import Pages.RegisterPage;
import SharedData.Hooks;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.sql.Driver;

public class IncorrectRegisterAccount extends Hooks {
    @Test
    public void MetodaTest(){

        RegisterObject registerObject = new RegisterObject(TestData);

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickDismiss();
        TestReport.attachReport("Pass", "I clicked the Dismiss button.");
        indexPage.clickMyAccount();
        TestReport.attachReport("Pass", "I clicked on the My Account button.");
        indexPage.clickRegisterButton();

        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.registerProcess(registerObject);
        TestReport.attachReport("Pass", "Register data is incorrect.");
        registerPage.registerInvalid(registerObject);
        TestReport.attachReport("Pass", "Error: Please provide a valid email address.");


    }
}
