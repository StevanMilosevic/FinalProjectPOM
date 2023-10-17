package Tests;

import Base.BaseTest;
import Pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp(){
        driver.navigate().to(homeURL);
        logIn(VALID_USERNAME, VALID_PASSWORD);
    }
    @Test
    public void canUserCheckoutItems(){
        inventoryPage.addBackpackToCart();
        inventoryPage.addBikeLightToCart();
        inventoryPage.clickOnCartButton();
        cartPage.clickOnCheckoutButton();
        cartPage.inputFirstname("Pera");
        cartPage.inputLastname("Peric");
        cartPage.inputPostalCode("ZIP 420");
        cartPage.clickOnContinueButton();
        scrollToElement(cartPage.finishButton);
        cartPage.clickOnFinishButton();
        Assert.assertEquals(driver.getCurrentUrl(), CartPage.completeCheckoutURL);
        Assert.assertTrue(cartPage.backToProductsButton.isDisplayed());
        Assert.assertEquals(cartPage.header.getText(), "Thank you for your order!");
    }
    @Test
    public void canUserCancelCheckout(){
        inventoryPage.addOnesieToCart();
        inventoryPage.addBikeLightToCart();
        inventoryPage.clickOnCartButton();
        cartPage.clickOnCheckoutButton();
        cartPage.clickOnCancelButton();
        Assert.assertEquals(inventoryPage.numberOfProductsInCart(), 1);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
        Assert.assertTrue(cartPage.checkoutButton.isDisplayed());
    }
    @Test
    public void canUserRemoveItemsFromCart(){
        inventoryPage.addBackpackToCart();
        inventoryPage.addBikeLightToCart();
        inventoryPage.clickOnCartButton();
        Assert.assertEquals(inventoryPage.numberOfProductsInCart(), 2);
        inventoryPage.removeBackpackFromCart();
        Assert.assertEquals(inventoryPage.numberOfProductsInCart(), 1);
    }
    @Test
    public void probaTest(){
        inventoryPage.addBackpackToCart();
        inventoryPage.addBikeLightToCart();
        inventoryPage.clickOnCartButton();


    }
}
