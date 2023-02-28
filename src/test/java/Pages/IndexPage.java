package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends BasePage{

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Dismiss']")
    private WebElement DismissAlert;

    @FindBy (xpath = "//a[text()='My Account']")
    private WebElement MyAccount;


    @FindBy (css = "p.woocommerce-form-row.form-row button[name='register']")
    private WebElement RegisterButton;



    public void clickDismiss(){
        elementMethods.ClickElement(DismissAlert);
    }

    public void clickMyAccount(){
        elementMethods.ClickElement(MyAccount);
    }

    public void clickRegisterButton(){
       elementMethods.ClickElement(RegisterButton);
    }


}
