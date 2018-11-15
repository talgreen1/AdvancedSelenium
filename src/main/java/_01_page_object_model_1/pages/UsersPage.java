package _01_page_object_model_1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsersPage extends BasePage {

    // Web elements
    private By newUserButton=By.id("newUser");

    public UsersPage(WebDriver driver) {
        super(driver);
    }

    public NewUserPage clickNewUser(){
        click(newUserButton);
        return new NewUserPage(driver);
    }


}
