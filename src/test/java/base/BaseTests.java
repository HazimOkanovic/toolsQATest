package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class BaseTests {
    public WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resourcesAut/chromedriver.exe");
        driver = new ChromeDriver();
        goHome();
        homePage = new HomePage(driver);
        }
    @BeforeMethod
    public void goHome() {
            driver.get("https://demoqa.com/");
        }
    @AfterClass
    public void tearDown() {
            driver.quit();
        }
}
