package _01_page_object_model_1.tests;

import _01_page_object_model_1.GlobalParameters;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    private static final String INVALID_LOGIN_MESSAGE = "Incorrect Credentials";
    @Test
    public void Given_I_open_login_page_When_typing_valid_username_and_wrong_password_Then_I_get_error_message(){
        loginPage.openLoginPage()
                .login(GlobalParameters.VALID_USERNAME, "InvalidPassword")
                .assertTextFound(INVALID_LOGIN_MESSAGE);
    }

    @Test
    public void Given_I_open_login_page_When_leaving_username_and_password_empty_Then_I_get_error_message(){
        loginPage.openLoginPage()
                .login("", "")
                .assertTextFound(INVALID_LOGIN_MESSAGE);
    }
}
