package Tests;

import Base.BaseTest;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp(){
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        driver.navigate().to(homeURL);
        logIn(VALID_USERNAME, VALID_PASSWORD);
    }
    @Test
    public void checkIfUserCanLogInWithoutFirstName(){
        inventoryPage.addOnesieToCart();
        inventoryPage.clickOnCartButton();
        cartPage.clickOnCheckoutButton();
        checkoutPage.inputFirstName("");
        checkoutPage.inputLastname("Peric");
        checkoutPage.inputPostalCode("012");
        checkoutPage.clickOnContinueButton();
        Assert.assertTrue(checkoutPage.errorMessage.isDisplayed());
        Assert.assertEquals(checkoutPage.errorMessage.getText(), "Error: First Name is required");
    }
    @Test
    public void checkIfUserCanCheckoutWithoutLastName(){
        inventoryPage.addBackpackToCart();
        inventoryPage.clickOnCartButton();
        cartPage.clickOnCheckoutButton();
        checkoutPage.inputFirstName("Pera");
        checkoutPage.inputLastname("");
        checkoutPage.inputPostalCode("012");
        checkoutPage.clickOnContinueButton();
        Assert.assertEquals(checkoutPage.errorMessage.getText(), "Error: Last Name is required");
        Assert.assertTrue(checkoutPage.errorMessage.isDisplayed());
    }
    @Test
    public void checkIfUserCanCheckoutWithoutPostalCode(){
        inventoryPage.addBikeLightToCart();
        inventoryPage.clickOnCartButton();
        cartPage.clickOnCheckoutButton();
        checkoutPage.inputFirstName("Pera");
        checkoutPage.inputLastname("Peric");
        checkoutPage.inputPostalCode("");
        checkoutPage.clickOnContinueButton();
        Assert.assertEquals(checkoutPage.errorMessage.getText(), "Error: Postal Code is required");
        Assert.assertTrue(checkoutPage.errorMessage.isDisplayed());
    }
    public void oneStep(){
        inventoryPage.addBackpackToCart();
        inventoryPage.clickOnCartButton();
        cartPage.clickOnCheckoutButton();
    }
    @AfterMethod
    public void tearDown(){
        driver.manage().deleteAllCookies();
    }

}
