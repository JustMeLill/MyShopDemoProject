package Pages;

import Objects.RegisterObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver){
        super (driver);
    }

    @FindBy(id = "reg_username")
    private WebElement Username;

    @FindBy(id = "reg_email")
    private WebElement Email;

    @FindBy(id = "reg_password")
    private WebElement Password;

    @FindBy(css = "ul.woocommerce-error")
    private WebElement ErrorValidation;


    public void registerProcess (RegisterObject registerObject){
        elementMethods.FillElement(Username, registerObject.getName());
        elementMethods.FillElement(Email, registerObject.getEmail());
        elementMethods.FillElement(Password, registerObject.getPassword());
    }

    public void registerInvalid (RegisterObject registerObject){
        elementMethods.FillElement(Username, registerObject.getName());
        elementMethods.FillElement(Email, registerObject.getEmail());
        elementMethods.FillElement(Password, registerObject.getPassword());
        elementMethods.ValidateElementText(ErrorValidation, registerObject.getMessage());
    }



}
