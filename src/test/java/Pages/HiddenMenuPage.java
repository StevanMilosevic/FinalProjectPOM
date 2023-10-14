package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HiddenMenuPage extends BaseTest {
    public HiddenMenuPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "bm-burger-button")
    public WebElement hiddenMenuButton;

    @FindBy(css = ".bm-item.menu-item")
    public List<WebElement> hiddenMenuItems;

    @FindBy(id = "inventory_sidebar_link")
    public WebElement allItems;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logOutButton;

    // ------------------------
    public void clickOnHiddenMenu(){
        hiddenMenuButton.click();
    }
    public void clickOnLogOutButton(){
        logOutButton.click();
    }
}
