import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {      
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testNavigateToMyAccountPage() {     
        driver.get("https://alchemy.hguy.co/lms");       
        WebElement myAccountLink = driver.findElement(By.linkText("My Account"));
        myAccountLink.click();      
        String actualTitle = driver.getTitle();
        String expectedTitle = "My Account – Alchemy LMS";
        Assert.assertEquals(actualTitle, expectedTitle, "Page title doesn't match! Navigation might have failed.");
    }

    @AfterClass
    public void tearDown() {      
        if (driver != null) {
            driver.quit();
        }
    }
}