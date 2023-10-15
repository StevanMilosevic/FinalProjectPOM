package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class InventoryPage extends BaseTest {
    public static String inventoryURL = "https://www.saucedemo.com/inventory.html";
    public InventoryPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement backpackAddButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement removeBackpack;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    public WebElement bikeLightAddButton;

    @FindBy(id = "remove-sauce-labs-bike-light")
    public WebElement removeBikeLight;

    @FindBy(id = "shopping_cart_container")
    public WebElement cartButton;

    @FindBy(className = "product_sort_container")
    public WebElement sortDropDown;

    @FindBy(className = "shopping_cart_badge")
    public WebElement numberOfProductsInCart;

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    public WebElement onesieButton;

    @FindBy(id = "remove-sauce-labs-onesie")
    public WebElement removeOnesie;

    @FindBy(className = "inventory_item_name")
    public List<WebElement> inventoryList;

    // -------------------
    public void addBackpackToCart(){
        backpackAddButton.click();
    }
    public void removeBackpackFromCart(){
        removeBackpack.click();
    }
    public void addBikeLightToCart(){
        bikeLightAddButton.click();
    }
    public void removeBikeLightFromCart(){
        removeBikeLight.click();
    }
    public int numberOfProductsInCart(){
        String number =  numberOfProductsInCart.getText();
        return Integer.parseInt(number);
    }
    public void addOnesieToCart(){
        onesieButton.click();
    }
    public void removeOnesieFromCart(){
        removeOnesie.click();
    }
    public void selectDropdown(String choice){
        Select select = new Select(sortDropDown);
        select.selectByVisibleText(choice);
    }
    public String getFirstInventoryFromList(){
        return inventoryList.get(0).getText();
    }
    public void clickOnCartButton(){
        cartButton.click();
    }

}
