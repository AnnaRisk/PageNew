package cucumber.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import extensions.Driver;
import pages.Pages;

public class Hooks {

    @Before
    public void setup() {
        Pages.login.open();
    }

    @After
    public void teardown() {
        Driver.quit();
    }
}
