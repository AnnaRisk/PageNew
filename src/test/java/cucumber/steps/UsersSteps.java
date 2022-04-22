package cucumber.steps;

import cucumber.api.java.en.Given;
import models.users.Context;
import models.users.UserCredentials;

public class UsersSteps {

    @Given("^I am user with nickname \"(.*)\"$")
    public void iAmUserWithNickname(String username) {
        if (!Context.hasKey("userCredentials")) {
            Context.set("userCredentials", new UserCredentials());
        }
        ((UserCredentials) Context.get("userCredentials"))
                .setUsername(username);
    }

    @Given("^I am user with password \"([^\"]*)\"$")
    public void iAmUserWithPassword(String password) {
        if (!Context.hasKey("userCredentials")) {
            Context.set("userCredentials", new UserCredentials());
        }
        ((UserCredentials) Context.get("userCredentials"))
                .setPassword(password);
    }
}
