package pages;

import extensions.Element;
import models.users.UserCredentials;
import extensions.Driver;
import org.openqa.selenium.support.How;
import static org.junit.Assert.assertTrue;

public class LoginPage extends BasePage {


    private Element userNameInput = new Element(How.ID, "user-name");
    private Element userPasswordInput = new Element(How.CSS, "#password");
    private Element loginButton = new Element(How.XPATH, "//input[@id='login-button']");
    private Element errorMessage = new Element(How.XPATH, "//h3[@data-test='error']");


    public LoginPage() {
        URL += "/";
    }



    public LoginPage open() {
        Driver.get().get(URL);
        return this;
    }


    public LoginPage fillUserInput(String s) {
        userNameInput.sendKeys(s);
        return this;
    }

    public LoginPage fillPasswordInput(String s) {
        userPasswordInput.sendKeys(s);
        return this;
    }


    public InventoryItem clickLoginButton() {
        loginButton.click();
        return Pages.inventoryList;
    }


    public InventoryItem loginUserSuccess(UserCredentials creds) {

        return fillUserInput(creds.getUsername())
                .fillPasswordInput(creds.getPassword())
                .clickLoginButton();

    }

    public LoginPage loginUserFailed(UserCredentials creds) {
        fillUserInput(creds.getUsername())
                .fillPasswordInput(creds.getPassword())
                .clickLoginButton();
        return this;
    }


    public LoginPage assertErrorMessagePresent(){
        assertTrue(errorMessage.isDisplayed());
        return this;
    }



    public LoginPage assertIsOnPage() {
        assertTrue(loginButton.isDisplayed());
        return this;
    }


}
