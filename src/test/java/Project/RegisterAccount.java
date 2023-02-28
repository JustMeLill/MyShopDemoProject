package Project;

import Objects.RegisterObject;
import Pages.IndexPage;
import Pages.RegisterPage;
import SharedData.Hooks;
import org.testng.annotations.Test;

public class RegisterAccount extends Hooks {

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
        TestReport.attachReport("Pass", "I filled in the register data.");
        registerPage.registerInvalid(registerObject);
        TestReport.attachReport("Pass", "The Registration Validation took place");

    }
}
