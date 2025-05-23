package todotests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import basetest.BaseTest;
import pages.HomePage;
import utilities.TestUtil;

public class TodoTest extends BaseTest {

    protected HomePage homePage;

    @BeforeClass
    public void startReport() {
        TestUtil.initExtentReport();
    }

    @BeforeMethod
    public void setUpPage() {
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void endReport() {
        TestUtil.flushReport();
    }
}
