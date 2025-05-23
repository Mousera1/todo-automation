package todotests;

import org.testng.annotations.Test;
import utilities.TestUtil;

public class TC_002AddThreeTask extends TodoTest {

    @Test(priority = 2)
    public void addThreeTasks() {
        TestUtil.createTest("Add Three Tasks");
        homePage.addTask("Buy milk");
	    homePage.addTask("Call mom");
	    homePage.addTask("Read book");
        TestUtil.logPass("Added Buy milk, Call mom, and Read book");
    }
}
