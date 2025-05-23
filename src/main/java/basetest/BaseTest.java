package basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeClass
    public void setUp() {
       
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://todomvc.com/examples/react/dist/");
            driver.manage().window().maximize();
       
    }

    @AfterClass
    public void tearDown() {
        
            driver.quit();
           
    }
}
