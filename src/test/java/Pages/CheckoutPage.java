package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BaseTest {
    public CheckoutPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "first-name")
    public WebElement firstName;

    @FindBy(id = "last-name")
    public WebElement lastName;

    @FindBy(id = "postal-code")
    public WebElement postalCode;

    @FindBy(id = "continue")
    public WebElement continuneButton;

    @FindBy(css = ".error-message-container.error")
    public WebElement errorMessage;

    //--------------------------
    public void inputFirstName(String name){
        firstName.clear();
        firstName.sendKeys(name);
    }
    public void inputLastname(String LastName){
        lastName.clear();
        lastName.sendKeys(LastName);
    }
    public void inputPostalCode(String postal){
        postalCode.clear();
        postalCode.sendKeys(postal);
    }
    public void clickOnContinueButton(){
        continuneButton.click();
    }
}
