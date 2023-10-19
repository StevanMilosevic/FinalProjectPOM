package Tests;

import Base.BaseTest;
import Pages.HiddenMenuPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        loginPage = new LoginPage();
        hiddenMenu = new HiddenMenuPage();
        driver.navigate().to(homeURL);
    }

    @Test
    public void logInUserWithValidUsername(){
        logIn(VALID_USERNAME, VALID_PASSWORD);
        Assert.assertEquals(driver.getCurrentUrl(), InventoryPage.inventoryURL);
        Assert.assertTrue(inventoryPage.cartButton.isDisplayed());
        Assert.assertTrue(inventoryPage.sortDropDown.isDisplayed());
    }
    @Test
    public void logInUserWithInvalidUsername() {
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String invalidUsername = excelReader.getStringData("Login", i, 5);
            logIn(invalidUsername, VALID_PASSWORD);
            Assert.assertTrue(loginPage.errorMessage.isDisplayed());
            Assert.assertEquals(driver.getCurrentUrl(), homeURL);
        }
    }
    @Test
    public void logInWithInvalidPassword(){
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String invalidPassword = excelReader.getStringData("Login", i, 6);
            logIn(VALID_USERNAME, invalidPassword);
            Assert.assertTrue(loginPage.errorMessage.isDisplayed());
            Assert.assertEquals(driver.getCurrentUrl(), homeURL);
        }
    }
    @Test
    public void logInUserWithInvalidUsernameAndPassword(){
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String invalidUsername = excelReader.getStringData("Login", i, 5);
            String invalidPassword = excelReader.getStringData("Login", i, 6);
            logIn(invalidUsername, invalidPassword);
            Assert.assertTrue(loginPage.errorMessage.isDisplayed());
            Assert.assertEquals(driver.getCurrentUrl(), homeURL);
        }
    }
    @Test
    public void logInProblemUser() throws IOException {
        logIn(excelReader.getStringData("Login", 1, 3), VALID_PASSWORD);
        wait.until(ExpectedConditions.visibilityOf(inventoryPage.sortDropDown));
        takeScreenshot("src/test/java/problem_user.png");
        Assert.assertEquals(driver.getCurrentUrl(), InventoryPage.inventoryURL);
        Assert.assertTrue(inventoryPage.sortDropDown.isDisplayed());
        Assert.assertTrue(inventoryPage.cartButton.isDisplayed());
    }
    @Test
    public void logOutUser(){
        logIn(VALID_USERNAME, VALID_PASSWORD);
        hiddenMenu.clickOnHiddenMenu();
        wait.until(ExpectedConditions.elementToBeClickable(hiddenMenu.logOutButton));
        hiddenMenu.clickOnLogOutButton();
        Assert.assertEquals(driver.getCurrentUrl(), homeURL);
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }
}
