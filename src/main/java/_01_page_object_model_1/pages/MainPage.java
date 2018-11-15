package _01_page_object_model_1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{

    // Web elements
    private By usersButton = By.id("users");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public UsersPage clickUsersButton(){
        click(usersButton);
        return new UsersPage(driver);
    }

}
