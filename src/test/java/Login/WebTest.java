package Login;

import extensions.Driver;
import org.junit.jupiter.api.AfterEach;

public class WebTest  {

    @AfterEach

    void teardown() {

        Driver.quit();
    }
}
