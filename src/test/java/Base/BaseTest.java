package Base;

import Pages.HiddenMenuPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public WebDriverWait wait;
    public static String VALID_USERNAME = "standard_user";
    public static String VALID_PASSWORD = "secret_sauce";
    public static String homeURL = "https://www.saucedemo.com/";
    public LoginPage loginPage;
    public InventoryPage inventoryPage;
    public ExcelReader excelReader;
    public HiddenMenuPage hiddenMenu;

    public void logIn(String username, String password) {
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
    }
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        excelReader = new ExcelReader("src/test/java/users.xlsx");
        hiddenMenu = new HiddenMenuPage();
    }

}
