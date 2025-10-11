import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity2 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup(); 
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void testHeading() {       
        WebElement heading = driver.findElement(By.className("uagb-ifb-title"));      
        String actualHeading = heading.getText();
        String expectedHeading = "Learn from Industry Experts";
        Assert.assertEquals(actualHeading, expectedHeading, "Heading does not match!");
    }

    @AfterClass
    public void tearDown() {        
        if (driver != null) {
            driver.quit();
        }
    }
}