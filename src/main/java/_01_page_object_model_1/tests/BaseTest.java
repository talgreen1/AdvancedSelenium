package _01_page_object_model_1.tests;

import _01_page_object_model_1.GlobalParameters;
import _01_page_object_model_1.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;

    // All pages
    protected LoginPage loginPage;
    protected MainPage mainPage;
    protected NewUserAddedPage newUserAddedPage;
    protected NewUserPage newUserPage;
    protected UsersPage usersPage;


    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", GlobalParameters.CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        newUserAddedPage = new NewUserAddedPage(driver);
        newUserPage = new NewUserPage(driver);
        usersPage = new UsersPage(driver);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
