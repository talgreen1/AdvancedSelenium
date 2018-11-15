package _01_page_object_model_1.pages;

import _01_page_object_model_1.GlobalParameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static _01_page_object_model_1.GlobalParameters.LOGIN_PAGE_URL;

public class LoginPage extends BasePage{

    // Web elements
    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openLoginPage(){
        driver.get(LOGIN_PAGE_URL);
        return this;
    }

    public MainPage login(String username, String password){
        writeText(usernameInput, username);
        writeText(passwordInput, password);
        click(loginButton);
        return new MainPage(driver);
    }
}
