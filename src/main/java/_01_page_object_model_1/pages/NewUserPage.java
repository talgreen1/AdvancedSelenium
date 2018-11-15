package _01_page_object_model_1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewUserPage extends BasePage{

    // Web elements
    private By firstNameInput=By.id("firstname");
    private By lastNameInput=By.id("lastname");
    private By submitButton=By.id("submit");

    public NewUserPage(WebDriver driver) {
        super(driver);
    }

    public NewUserAddedPage fillAddUserFormAndSave(String firstName, String lastName){
        writeText(firstNameInput, firstName);
        writeText(lastNameInput, lastName);
        click(submitButton);
        return new NewUserAddedPage(driver);
    }
}
