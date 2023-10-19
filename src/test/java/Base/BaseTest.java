package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
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
    public CartPage cartPage;
    public CheckoutPage checkoutPage;

    public void logIn(String username, String password) {
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
    }
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void takeScreenshot(String path) throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File screenFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(path);
        FileUtils.copyFile(screenFile, destinationFile);
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
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE || result.getStatus() == ITestResult.SKIP){
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File savedScreenshot = new File("target/screenshots/"+System.currentTimeMillis()+".jpg");
            FileUtils.copyFile(screenshot, savedScreenshot);
        }
        //driver.quit();
    }

}
