package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "user-name")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(css = ".error-message-container.error")
    public WebElement errorMessage;

    // ----------------------------
    public void inputUsername(String user){
        username.clear();
        username.sendKeys(user);
    }
    public void inputPassword(String pass){
        password.clear();
        password.sendKeys(pass);
    }
    public void clickOnLoginButton(){
        loginButton.click();
    }
}
