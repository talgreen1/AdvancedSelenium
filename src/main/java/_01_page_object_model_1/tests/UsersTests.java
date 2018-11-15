package _01_page_object_model_1.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static _01_page_object_model_1.GlobalParameters.VALID_PASSWORD;
import static _01_page_object_model_1.GlobalParameters.VALID_USERNAME;

public class UsersTests extends BaseTest{

    private static final String FIRST_NAME="Gidi";
    private static final String LAST_NAME="Gov";
    private static final String NEW_USER_ADDED_TEXT = "New User Added OK";

    @BeforeClass
    public void login(){
        loginPage.login(VALID_USERNAME, VALID_PASSWORD);
    }

    @Test
    public void Given_I_open_the_new_user_page_When_typing_first_and_last_name_and_click_submit_Then_new_user_added(){
        mainPage.clickUsersButton()
                .clickNewUser()
                .fillAddUserFormAndSave(FIRST_NAME, LAST_NAME)
                .assertTextFound(NEW_USER_ADDED_TEXT);
    }
}
