package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BaseTest {
    public static String completeCheckoutURL = "https://www.saucedemo.com/checkout-complete.html";
    public CartPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    @FindBy(id = "first-name")
    public WebElement firstname;

    @FindBy(id = "last-name")
    public WebElement lastname;

    @FindBy(id = "postal-code")
    public WebElement postalcode;

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(id = "finish")
    public WebElement finishButton;

    @FindBy(id = "back-to-products")
    public WebElement backToProductsButton;

    @FindBy(className = "complete-header")
    public WebElement header;

    @FindBy(id = "cancel")
    public WebElement cancelButton;

    @FindBy(className = "inventory_item_price")
    public WebElement itemPrice;

    @FindBy(className = "inventory_item_price")
    public List<WebElement> itemsPrice;

    //-------------------------------
    public void clickOnCheckoutButton(){
        checkoutButton.click();
    }
    public void inputFirstname(String firstName){
        firstname.clear();
        firstname.sendKeys(firstName);
    }
    public void inputLastname(String lastName){
        lastname.clear();
        lastname.sendKeys(lastName);
    }
    public void inputPostalCode(String postalCode){
        postalcode.clear();
        postalcode.sendKeys(postalCode);
    }
    public void clickOnContinueButton(){
        continueButton.click();
    }
    public void clickOnFinishButton(){
        finishButton.click();
    }
    public void clickOnCancelButton(){
        cancelButton.click();
    }
}
