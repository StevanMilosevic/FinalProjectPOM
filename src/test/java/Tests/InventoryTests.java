package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class InventoryTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to(homeURL);
        logIn(VALID_USERNAME, VALID_PASSWORD);
    }
    @Test
    public void addProductsToCart(){
        inventoryPage.addBackpackToCart();
        Assert.assertEquals(inventoryPage.numberOfProductsInCart(), 1);
        inventoryPage.addBikeLightToCart();
        Assert.assertEquals(inventoryPage.numberOfProductsInCart(), 2);
        scrollToElement(inventoryPage.onesieButton);
        inventoryPage.addOnesieToCart();
        Assert.assertEquals(inventoryPage.numberOfProductsInCart(), 3);
    }
    @Test
    public void selectFromDropDownMenu(){
        String firstItem = inventoryPage.getFirstInventoryFromList();
        inventoryPage.selectDropdown("Name (Z to A)");
        String secondItem = inventoryPage.getFirstInventoryFromList();
        Assert.assertFalse(firstItem.equalsIgnoreCase(secondItem));
    }
    @Test
    public void hiddenMenuItems(){
        String[] menuItems = {"All Items", "About", "Logout", "Reset App State"};
        Assert.assertTrue(hiddenMenu.hiddenMenuButton.isDisplayed());
        hiddenMenu.clickOnHiddenMenu();
        wait.until(ExpectedConditions.visibilityOf(hiddenMenu.allItems));
        for (int i = 0; i < hiddenMenu.hiddenMenuItems.size();i++) {
            Assert.assertEquals(hiddenMenu.hiddenMenuItems.get(i).getText(), menuItems[i]);
        }
    }
    @Test
    public void checkFooterIcons(){
        inventoryPage.clickOnLinkedInIcon();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        String actualURL = driver.switchTo().window(tabs.get(1)).getCurrentUrl();
        Assert.assertEquals(actualURL, "https://www.linkedin.com/company/sauce-labs/");
    }
}
