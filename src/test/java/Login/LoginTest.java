package Login;

import сonfig.Config;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pages.pages;
import users.UsersCred;

@Epic("New user role")

@Feature("Registration")

@Story("Inncorrect login")

public class LoginTest extends WebTest {


    public int goodsPerPage = 6;
    UsersCred creds;

    @BeforeEach
    @Step("Open main page")

    void setup(){
        creds = new UsersCred();
        creds.setUsername(Config.correctUsername);
        creds.setPassword(Config.correctPassword);

        pages.login.open();

    }


    @Test
    void CorrectLogin() {


        pages.login.loginUserSuccess(creds)
                .assertInventoryItemsCountIs(goodsPerPage);


    }

    @Test
    void IncorrectLogin() {

        pages.login.loginUserFailed(creds)
                .assertErrorMessagePresent();
    }


}