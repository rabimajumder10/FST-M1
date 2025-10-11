import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {       
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();    }

    @Test
    public void verifyTitle() {
        driver.get("https://alchemy.hguy.co/lms");  
        String actualTitle = driver.getTitle();
        String expectedTitle = "Alchemy LMS – An LMS Application";
        System.out.println("Page Title: " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
    }

    @AfterClass
    public void tearDown() {
   
        if (driver != null) {
            driver.quit();
        }
    }
}