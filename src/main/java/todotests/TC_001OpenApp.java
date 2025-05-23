package todotests;

import org.testng.annotations.Test;
import utilities.TestUtil;

public class TC_001OpenApp extends TodoTest {

    @Test(priority = 1)
    public void openApplication() {
        TestUtil.createTest("Open the Application");
        TestUtil.logPass("Application launched successfully: " + driver.getCurrentUrl());
    }
}

