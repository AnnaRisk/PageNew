package Login;

import pages.CheckOut;
import сonfig.Config;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pages.Pages;
import users.UsersCred;

@Epic("New user role")

@Feature("Registration")

@Story("Inncorrect login")

public class LoginTest extends WebTest {


    public int goodsPerPage = 6;
    UsersCred creds;

    @BeforeEach
    @Step("Open main page")
    void setup() {
        creds = new UsersCred();
        creds.setUsername(Config.correctUsername);
        creds.setPassword(Config.correctPassword);

        Pages.login.open();

    }


    @Test
    void CorrectLogin() {


        Pages.login.loginUserSuccess(creds)
                .assertInventoryItemsCountIs(goodsPerPage);


    }

    @Test
    void IncorrectLogin() {
        creds.setUsername(Config.incorrectUsername);
        Pages.login.loginUserFailed(creds)
                .assertErrorMessagePresent();
    }

    @Test
    void addToBasket() {

        Pages.login.loginUserSuccess(creds);
        Pages.checkButton
                .clickButton1()
                .clickAddButton()
                .clickCart()
                .checkOrder("Sauce Labs Fleece Jacket");
    }

    @Test
    void delFromBasket() {
        Pages.login.loginUserSuccess(creds);
        Pages.checkButton
                .clickButton1()
                .clickAddButton()
                .clickCart()
                .checkOrder("Sauce Labs Fleece Jacket")
                .removeClick()
                .checkOrder("");
    }

    @Test
    void checkOutInput() {
        Pages.login.loginUserSuccess(creds);
        Pages.checkButton
                .clickButton1()
                .clickAddButton()
                .clickCart()
                .checkOrder("Sauce Labs Fleece Jacket");
        Pages.clickCheck
                .clickCheckOut()
                .checkHeader("CHECKOUT: YOUR INFORMATION")
                .fillFirstName("Anna")
                .fillLastName("Rain")
                .zipCode("112233");
    }

    @Test
    void clickCancel() {
        Pages.login.loginUserSuccess(creds);
        Pages.checkButton
                .clickButton1()
                .clickAddButton()
                .clickCart()
                .checkOrder("Sauce Labs Fleece Jacket");
        Pages.clickCheck
                .clickCheckOut()
                .checkHeader("CHECKOUT: YOUR INFORMATION")
                .fillFirstName("Anna")
                .fillLastName("Rain")
                .zipCode("112233")
                .cancelClick();
    }

    @Test
    void clickContinueError() {
        Pages.login.loginUserSuccess(creds);
        Pages.checkButton
                .clickButton1()
                .clickAddButton()
                .clickCart()
                .checkOrder("Sauce Labs Fleece Jacket");
        Pages.clickCheck
                .clickCheckOut()
                .checkHeader("CHECKOUT: YOUR INFORMATION")
                .continueClick()
                .errorContinue();

    }
    @Test
    void successCheckout() {
        Pages.login.loginUserSuccess(creds);
        Pages.checkButton
                .clickButton1()
                .clickAddButton()
                .clickCart()
                .checkOrder("Sauce Labs Fleece Jacket");
        Pages.clickCheck
                .clickCheckOut()
                .checkHeader("CHECKOUT: YOUR INFORMATION")
                .fillFirstName("Anna")
                .fillLastName("Rain")
                .zipCode("112233")
                .continueClick()
                .headerCheckout("Sauce Labs Fleece Jacket");

    }
}

